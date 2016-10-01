/*
 * Created on April 4, 2016 
 * Author: akshayb1
 * Verifone Inc., Copyright(c) 2016 All rights reserved
 */
package com.verifone.isd.viper.eps.version;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.Manifest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VersionManager is singleton class For managing the version info details. It
 * provides utility APIs to read,register and unregister version details of
 * module. It provides APSs to read the registered module version details and sub
 * module version details.
 * 
 * @author AkshayB1
 * 
 */
public class VersionManager {

	private static final Logger log = LoggerFactory.getLogger(VersionManager.class.getName());
	private static volatile VersionManager theInstance = new VersionManager();
	private  Map<String,VersionInfo> versionInfoMap = new ConcurrentHashMap<String,VersionInfo>();
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
	private final Lock readLock = readWriteLock.readLock();
	private final Lock writeLock = readWriteLock.writeLock();

	static{
		org.apache.log4j.BasicConfigurator.configure();
	}
	
	/**
	 * A private Constructor prevents any other class from instantiating.
	 */
	private VersionManager(){
		
	}
	
	/**
	 * Singleton class Static 'instance' method to get VersionManager instance.
	 * 
	 * @return
	 */
	public static VersionManager getInstance(){
		return (theInstance);
	}
	
	/**
	 * API to provide version details of specified module name.
	 * @param moduleName - Module name to retrieve version information.
	 * @return returns VersionInfoInterface object.
	 */
	public  VersionInfoInterface getRegisteredModuleVersionInfo(String moduleName){
		VersionInfoInterface vInfo = null;
		readLock.lock();
		try{
			if(versionInfoMap.containsKey(moduleName)){
				vInfo = versionInfoMap.get(moduleName);
				if(vInfo!=null){
					/** Doing deep copy of version info object */
					vInfo = new VersionInfo(vInfo);
				}
			}
		}
		finally{
			readLock.unlock();
		}
		return vInfo;
	}
	
	/**
	 * API to provide version details of specified module in a map format.
	 * key will attribute (Module-Name,Module-Version,MODULE_BUILD_TIME,Module-Build-Time)
	 * Value will be value of attribute.
	 * @param moduleName
	 * @return
	 */
	public  Map<String,String> getRegisteredModuleVersionInfoMap(String moduleName){
		Map<String,String> dataMap = new HashMap<String, String>();
		readLock.lock();
		try{
			if(versionInfoMap.containsKey(moduleName)){
				VersionInfoInterface vInfo = versionInfoMap.get(moduleName);
				/**
				 * If the value is not null or not empty then only details will
				 * be added to map. Module name and module version cannot be
				 * null, this will be checked at the point of adding to
				 * versionInfoMap thats the reason not having check for module
				 * name and module version.
				 */
				dataMap.put(VersionManagerConstants.MODULE_NAME, vInfo.getModuleName());
				dataMap.put(VersionManagerConstants.MODULE_VERSION, vInfo.getModuleVersion());
				String buildTime = vInfo.getModuleBuildTime();
				String buildHash =vInfo.getModuleBuildHash();
				if(buildTime!=null && !buildTime.trim().isEmpty()){
					dataMap.put(VersionManagerConstants.MODULE_BUILD_TIME, buildTime);
				}
				if(buildHash!=null && !buildHash.trim().isEmpty()){
					dataMap.put(VersionManagerConstants.MODULE_HASH, buildHash);
				}
			}
			dataMap = Collections.unmodifiableMap(dataMap);
		}finally{
			readLock.unlock();
		}
		return dataMap;
	}
	
	/**
	 * API to provide all the sub module version details for the specified module.
	 * @param moduleName - Name of a module.
	 * @return list of sub module version details
	 */
	public  List<VersionInfoInterface> getRegisteredModuleSubModulesVersionInfo(String moduleName){
		List<VersionInfoInterface> listSubVersionInfo = new ArrayList<VersionInfoInterface>();
		readLock.lock();
		try{
			if(versionInfoMap.containsKey(moduleName)){
				List<VersionInfoInterface> originalList = versionInfoMap.get(moduleName).getSubModuleVersionInfo();
				if(originalList!=null){
					/**
					 * Doing the deep copy of sub module version objects.
					 */
					for (VersionInfoInterface versionInfoInterface : originalList) {
						if(versionInfoInterface!=null){
							listSubVersionInfo.add(new VersionInfo(versionInfoInterface));
						}
					}
					/** Below code can be used if only shallow copy is required. */
					//listSubVersionInfo = new ArrayList<VersionInfoInterface>(originalList);
				}
			}
			listSubVersionInfo = Collections.unmodifiableList(listSubVersionInfo);
		}
		finally{
			readLock.unlock();
		}
		return listSubVersionInfo;
	}
	
	/**
	 * API to provide all the sub module version details in HashMap representation.
	 * Outer HashMap - Key sub module name, Value subversion details.
	 * Inner HashMap - Key will be attribute(name,version,build time, build hash) and value will be value of attribute.
	 * @param moduleName - Name of module.
	 * @return map of subversion details.
	 */
	public  Map<String,Map<String,String>> getRegisteredModuleSubModulesVersionInfoMap(String moduleName){
		Map<String,Map<String,String>> dataMap = new HashMap<String, Map<String,String>>();
		readLock.lock();
		try{
			if(versionInfoMap.containsKey(moduleName)){
				List<VersionInfoInterface> subModuleVersionInfoList = versionInfoMap.get(moduleName).getSubModuleVersionInfo();
				for (VersionInfoInterface versionInfoInterface : subModuleVersionInfoList) {
					Map<String,String> subModuleDataMap = new HashMap<String, String>();
					String name = versionInfoInterface.getModuleName();
					String version = versionInfoInterface.getModuleVersion();
					String buildTime = versionInfoInterface.getModuleBuildTime();
					String buildHash = versionInfoInterface.getModuleBuildHash();
					if(name!=null && name.trim().isEmpty()){
						subModuleDataMap.put(VersionManagerConstants.MODULE_NAME, name);
						subModuleDataMap.put(VersionManagerConstants.MODULE_VERSION, version);
						subModuleDataMap.put(VersionManagerConstants.MODULE_BUILD_TIME, buildTime);
						subModuleDataMap.put(VersionManagerConstants.MODULE_HASH, buildHash);
						dataMap.put(versionInfoInterface.getModuleName(), subModuleDataMap);
					}
					
				}
			}
			Collections.unmodifiableMap(dataMap);
		}finally{
			readLock.unlock();
		}
		return dataMap;
	}
	
	/**
	 * API to obtain all registered module version info details in list of
	 * VersionInfoInterface object. Here the Deep copy of objects are returned.
	 * 
	 * @return list of VersionInfoInterface objects.
	 */
	public  List<VersionInfoInterface> getAllRegisteredModuleVersionInfo(){
		List<VersionInfoInterface> listVersionInfo = new ArrayList<VersionInfoInterface>();
		readLock.lock();
		try{
			List<VersionInfo> originalList = (List<VersionInfo>) versionInfoMap.values();
			if(originalList!=null){
				 /** Doing deep copy of version info details. */
				for (VersionInfoInterface versionInfoInterface : originalList) {
					if(versionInfoInterface!=null){
						listVersionInfo.add(new VersionInfo(versionInfoInterface));
					}
				}
			}
			Collections.unmodifiableList(listVersionInfo);
		}finally{
			readLock.unlock();
		}
		return listVersionInfo;  
	}
	
	/**
	 * API to provide all the  module version details in HashMap representation.
	 * Outer HashMap - Key sub module name, Value version details.
	 * Inner HashMap - Key will be attribute(name,version,build time, build hash) and value will be value of attribute. 
	 * @return
	 */
	public  Map<String,Map<String,String>> getAllRegisteredModuleVersionInfoMap(){
		Map<String,Map<String,String>> dataMap = new HashMap<String, Map<String,String>>();
		readLock.lock();
		try{
			for(Entry<String, VersionInfo> entry : versionInfoMap.entrySet()){
	            String moduleName = entry.getKey();
	            Map<String,String> innerDataMap = getRegisteredModuleVersionInfoMap(moduleName);
	            dataMap.put(moduleName, innerDataMap);
	        }
			dataMap = Collections.unmodifiableMap(dataMap);
		}finally{
			readLock.unlock();
		}
		return dataMap;
	}
	
	/**
	 * API for registering version info. This API will take input object
	 * implementing interface VersionInfoInterface. Performs the deep copy of
	 * object to maintain the version info details.
	 * 
	 * @param versionInfo
	 *            object implementing interface VersionInfoInterface
	 * @return status of updating version info.
	 */
	public boolean registerModule(VersionInfoInterface versionInfo){
		if(versionInfo!=null){
			return registerModule(new VersionInfo(versionInfo));
		}else{
			log.warn("VersionInfo object is null.");
			return false;
		}
		
	}

	/**
	 * API for registering version info. If the module is already registered
	 * before then the reference count of the module will be incremented. This
	 * API intentional;y made private as we are not doing a deep copy of object
	 * here. The User will be calling above API
	 * registerModule(VersionInfoInterface versionInfo)
	 * 
	 * @param versionInfo
	 * @return status of updating version info.
	 */
	private boolean registerModule(VersionInfo versionInfo){
		writeLock.lock();
		Boolean updateStatus= Boolean.FALSE;
		try{
			if(versionInfo!=null){
				String moduleName = versionInfo.getModuleName();
				String moduleVersion = versionInfo.getModuleVersion();
				boolean legalVersion = validateVesrion(moduleVersion);
				log.info(moduleName+" invoked registerModule API of Version Manager for Version : "+moduleVersion);
				if (null != moduleName && legalVersion) {
					if (versionInfoMap.containsKey(moduleName)) {
						log.info(moduleName+" module was registerd already.");
						VersionInfo existingVersionInfo = versionInfoMap.get(moduleName);
						String existingModuleVersion = existingVersionInfo.getModuleVersion();
						if(existingModuleVersion.equals(moduleVersion)){
							existingVersionInfo.incrementReferenceCount();
							versionInfo = existingVersionInfo;
							log.info(moduleName+" module was refernce count incremented.");
						}
						/**
						 * If  existing module version is not matching with new version info 
						 * then the reference count will be reset to 1 as we will be using new versionInfo object. 
						 * This situation will not occur as per the design discussion is made.
						 */
					}
					versionInfoMap.put(moduleName, versionInfo);
					log.debug("Module " + moduleName+" with vesrion "+moduleVersion+" registred wirh VersionManager");
					updateStatus = Boolean.TRUE;
				}else{
					log.warn("Invalid version details, Module not registred.");
				}
			}else{
				log.warn("VersionInfo object is null.");
			}
		}finally{
			writeLock.unlock();
		}
		log.debug("Module Register status : "+updateStatus);
		return updateStatus;
	}
	
	/**
	 * This API is used to validate the version.
	 * Version validation will be done using regex. 
	 * @param version
	 * @return
	 */
	private final boolean validateVesrion(String version){
		Boolean validationStatus= Boolean.FALSE;
		if(version!=null && version.length()>5 && version.length()<=8){
			validationStatus = version.matches(VersionManagerConstants.VERSION_REGEX);
		}
		log.debug(version+" validation status : "+validationStatus);
		return validationStatus;
	}
	
	/**
	 * This is an Utility API provided when the module is knowing name and version details to its own.
	 * @param moduleName - Name of the module.
	 * @param moduleVersion - Module version.
	 * @return
	 */
	public  boolean registerModule(String moduleName,String moduleVersion){	
		return registerModule(new VersionInfo(moduleName, moduleVersion));
	}
	
	/**
	 * This is an Utility API provided when the module is knowing name and version details to its own.
	 * @param moduleName - Name of the module.
	 * @param moduleVersion - Module version.
	 * @param moduleBuildTime - Module build time
	 * @return
	 */
	public  boolean registerModule(String moduleName,String moduleVersion, String moduleBuildTime){
		return registerModule(new VersionInfo(moduleName, moduleVersion,moduleBuildTime));
	}
	
	/**
	 * This is an Utility API provided when the module is knowing name and version details to its own.
	 * @param moduleName- Name of the module.
	 * @param moduleVersion  - Module version.
	 * @param moduleBuildTime - Module build time
	 * @param moduleBuildHash - Module build hash
	 * @return
	 */
	public  boolean registerModule(String moduleName,String moduleVersion, String moduleBuildTime, String moduleBuildHash){
		return registerModule(new VersionInfo(moduleName, moduleVersion,moduleBuildTime,moduleBuildHash));
	}
	
	/**
	 * API to unregister the version details from version manager.
	 * @param versionInfo versionInfo object.
	 * @return unRegister status. True for success and false for failure.
	 */
	public  boolean unRegisterModule(VersionInfoInterface versionInfo){
		if(versionInfo!=null){
			return unRegisterVersion(versionInfo.getModuleName());
		}else{
			log.warn("VersionInfo object can't be null for unregister.");
			return false;
		}
		
	}
	
	/**
	 * API to unregister the version details from version manager.
	 * @param moduleName name of module need to unregister.
	 * @return unRegister status. True for success and false for failure.
	 */
	public  boolean unRegisterVersion(String moduleName){
		writeLock.lock();
		Boolean unRegisterStatus =Boolean.FALSE;
		try{
		log.info("unRegister is invoked for module : "+moduleName);
		if (moduleName!=null) {
			if (versionInfoMap.containsKey(moduleName)) {
					/**
					 * The reference count will be more than or equal 1. It will
					 * be more than one in case of 2 or more instance of module
					 * is running like currently Loyalty is having 4 instances
					 * (PCATS01,PCATS02,PCATS03,PCATS04).
					 * 
					 * The version info object of module is retrieved and if the
					 * reference count is more than 1 then the reference count
					 * is decremented by 1. if the reference count is one then
					 * the version info object for the module will be removed
					 * from HashMap.
					 */
				VersionInfo existingVersionInfo = versionInfoMap.get(moduleName);
				int referenceCount = existingVersionInfo.getModulesReferenceCount();
				log.info("Version info reference count : "+referenceCount);
				if(referenceCount>1){
					existingVersionInfo.decrementReferenceCount();
					log.info("Version info reference count is decremented by 1 ");
					
				}else{
					versionInfoMap.remove(moduleName);
					log.info(moduleName+"Module Un-registerd with VersionManager and removed version info data");
				}
				
				unRegisterStatus= Boolean.TRUE;
			}
		}
		}finally{
			writeLock.unlock();
		}
		return unRegisterStatus.booleanValue();
	}
	
		
	/**
	 * API to read Version info details from MANIFEST.MF file from META-INF/MANIFEST.MF location.
	 * @param moduleClass Should be the class of the specific jar belongs.
	 * @return
	 * @throws VersionReadException
	 */
	public VersionInfoInterface getVersionInfo(Class moduleClass) throws VersionReadException {
		Enumeration<URL> resources;
		VersionInfoInterface vInfo = null;
		try {
			resources = VersionManager.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
			while (resources.hasMoreElements()) {
				URL url = resources.nextElement();
				log.info("URL : "+url);
				String moduleJarName = moduleClass.getProtectionDomain().getCodeSource().getLocation().getFile(); 
				log.info("Jar name : "+moduleJarName);
				if(url.getFile().contains(moduleJarName)){
					Manifest manifest = new Manifest(url.openStream());
					Attributes attributes = manifest.getMainAttributes();
					Set<Object>  keys = attributes.keySet();
					/**
					 * Creating hashMap all the version details irrespective of
					 * module or sub module by reading all the entries of
					 * MANIFEST file. later the sub module version object will
					 * be merged to module version object
					 */
					Map<String,VersionInfo> mapData = new HashMap<String, VersionInfo>();
					for (Object object : keys) {
						if(object!=null && object instanceof Name){
							String name = object.toString();
							String value = attributes.getValue((Name)object);
							if(name!=null && !name.trim().isEmpty() && name.contains("-") && name.toLowerCase().contains(VersionManagerConstants.MODULE.toLowerCase()) 
									&& value!=null && !value.isEmpty()){
								VersionInfo versionInfo = null;
								/**
								 * Key will be the starting of the attribute till the dash symbol The naming convention
								 * will be used in generating version details will be Module-name. 
								 * Example : 
								 * 		Module-Name: Core Viper
								 * 		Module-Version: 1.1.1
								 * 		Module-Build-Time: YYYY-MM-DD HH:MM:SS
								 * 		Module-Hash: some random hash
								 * 		SubModule1-Name: Viper Library 
								 * 		SubModule1-Version: 1.1.2
								 * 		SubModule2-Name: Viper Agent
								 * 		SubModule2-Version: 1.1.3
								 * 		Note: sub module can also have different build time and hash.
								 * 
								 * The keys in the hashMap will be Module,SubModule1 & SubModule2.
								 */
								String key = name.trim().substring(0,name.indexOf("-")).toLowerCase();
																
								if(mapData.containsKey(key)){
									log.debug("Picked avilable  VersionInfo object from HashMap ");
									versionInfo = mapData.get(key);
								}else{
									log.debug("Created new VersionInfo object ");
									versionInfo = new VersionInfo();
								}
								
								if(name.toLowerCase().endsWith(VersionManagerConstants.NAME.toLowerCase())){
									versionInfo.setModuleName(value);
								} else if(name.toLowerCase().endsWith(VersionManagerConstants.VERSION.toLowerCase())){
									versionInfo.setModuleVersion(value);
								}else if(name.toLowerCase().endsWith(VersionManagerConstants.BUILD_TIME.toLowerCase())){
									versionInfo.setModuleBuildTime(value);
								}else if(name.toLowerCase().endsWith(VersionManagerConstants.HASH.toLowerCase())){
									versionInfo.setModuleBuildHash(value);
								} else{
									log.warn(name+" property not updated to VersionInfo object.");
								}
								mapData.put(key.toLowerCase(), versionInfo);
							}else{
								log.warn(name+" property not updated to VersionInfo object.");
							}
						}
					}
					if(!mapData.isEmpty()){
						VersionInfo mainObject = mapData.get(VersionManagerConstants.MODULE.toLowerCase());
						/** The key with the Name Module will be the main object of version details.
						 * 	After retrieving the main object the same will be removed from hashmap
						 *  And all other version objects will be added as sub module details. */
						mapData.remove(VersionManagerConstants.MODULE.toLowerCase());
						String moduleName = mainObject.getModuleName();
						String moduleVersion = mainObject.getModuleVersion();
						/** Module name and module version should be mandatory if not available 
						 *  then should be treat as invalid details for the module and 
						 *  module will be notified by throwing exception  */
						if(moduleName!=null && !moduleName.trim().isEmpty()
								&& moduleVersion!=null && !moduleVersion.trim().isEmpty()){
							List<VersionInfoInterface> subModuleVersionList = new ArrayList<VersionInfoInterface>();
							for(Entry<String, VersionInfo> entry : mapData.entrySet()){
								VersionInfo subModule = entry.getValue();
								String subModuleName = subModule.getModuleName();
								String subModuleVersion = subModule.getModuleVersion();
								if(subModuleName!=null && !subModuleName.trim().isEmpty()
										&& subModuleVersion!=null && !subModuleVersion.trim().isEmpty()){
									subModuleVersionList.add((VersionInfoInterface)subModule);
								}else{
									log.warn("Ignored sub module version details. SubModule name : "+subModuleName+", Vesrsion : "+subModuleVersion);
								}
					        }
							mainObject.setSubModuleVersionInfo(subModuleVersionList);
							vInfo = (VersionInfoInterface) mainObject;
						}else{
							throw new VersionReadException("Module name or Module version is not correct.");
						}
					}
				}
			}
		} catch (IOException e) {
			throw new VersionReadException("IOException in reading version");
		}catch (Exception ie) {
			throw new VersionReadException("Exception in reading version");
		}
		if(vInfo!=null){
			return vInfo;
		}else{
			throw new VersionReadException("Not found version file for specified jar.");
		}
	}
	
	
	/**
	 * This API will read the version info from MANIFEST.MF file. and the
	 * version details will be registered with version manager.
	 * 
	 * @param moduleName - Should be the class of the specific jar belongs.
	 * @return module register status. 
	 * @throws VersionReadException if version details are not read by version manager this will
	 *             be thrown.
	 */
	public boolean readAndRegisterVersionInfo(Class moduleName) throws VersionReadException {
		VersionInfoInterface vInfo =getVersionInfo(moduleName);
		return registerModule(vInfo);
	}	
	
}
