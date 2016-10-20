/*
 * Created on April 4, 2016 
 * Author: akshayb1
 * Verifone Inc., Copyright(c) 2016 All rights reserved
 */
package com.verifone.isd.viper.eps.version;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data bean class which implements VersionInfoInterface
 * to update the versions to VersionManager.
 * @author akshayb1
 *
 */
public final class VersionInfo implements VersionInfoInterface,Serializable {

	private static final long serialVersionUID = 1L;
	private int modulesReferenceCount = 1;
	private String moduleName;
	private String moduleVersion;
	private String moduleBuildTime;
	private String moduleBuildHash;
	private boolean isPrimaryFEP = false;
	private List<VersionInfoInterface> subModuleVersionInfo;
	
	public VersionInfo() {
		
	}

	/**
	 * Constructor for creating version info object when module name and version is known.
	 * @param moduleName - Name of the module.
	 * @param moduleVersion - version of the module.
	 */
	public VersionInfo(String moduleName, String moduleVersion) {
		this.moduleName = moduleName;
		this.moduleVersion = moduleVersion;
	}
	
	/**
	 * Constructor for creating version info object when module name,version and build time is known.
	 * @param moduleName - Name of the module.
	 * @param moduleVersion - version of the module.
	 * @param moduleBuildTime - Module build time.
	 */
	public VersionInfo(String moduleName, String moduleVersion,
			String moduleBuildTime) {
		this.moduleName = moduleName;
		this.moduleVersion = moduleVersion;
		this.moduleBuildTime = moduleBuildTime;
	}
	
	/**
	 * Constructor for creating version info object when module name,version module build time and build hash is known.
	 * @param moduleName - Name of the module.
	 * @param moduleVersion - version of the module.
	 * @param moduleBuildTime - Module build time.
	 * @param moduleBuildHash - Module build hash.
	 */
	public VersionInfo(String moduleName, String moduleVersion,
			String moduleBuildTime, String moduleBuildHash) {
		this.moduleName = moduleName;
		this.moduleVersion = moduleVersion;
		this.moduleBuildTime = moduleBuildTime;
		this.moduleBuildHash = moduleBuildHash;
	}
	
	/**
	 * Constructor for creating version info object when module name,version module build time and build hash & sub version details is known.
	 * @param moduleName - Name of the module.
	 * @param moduleVersion- version of the module.
	 * @param moduleBuildTime - Module build time.
	 * @param moduleBuildHash - Module build hash.
	 * @param subModuleVersionInfo -sub version details of the module.
	 */
	public VersionInfo(String moduleName, String moduleVersion,
			String moduleBuildTime, String moduleBuildHash,
			List<VersionInfoInterface> subModuleVersionInfo) {
		this.moduleName = moduleName;
		this.moduleVersion = moduleVersion;
		this.moduleBuildTime = moduleBuildTime;
		this.moduleBuildHash = moduleBuildHash;
		this.subModuleVersionInfo = subModuleVersionInfo;
	}
	
	/**
	 * Constructor for creating version info object when module name,version module build time and build hash & sub version details is known.
	 * @param moduleName - Name of the module.
	 * @param moduleVersion- version of the module.
	 * @param moduleBuildTime - Module build time.
	 * @param moduleBuildHash - Module build hash.
	 * @param subModuleVersionInfo -sub version details of the module.
	 */
	public VersionInfo(String moduleName, String moduleVersion,
			String moduleBuildTime, String moduleBuildHash, boolean isPrimaryFEP, 
			List<VersionInfoInterface> subModuleVersionInfo) {
		this.moduleName = moduleName;
		this.moduleVersion = moduleVersion;
		this.moduleBuildTime = moduleBuildTime;
		this.moduleBuildHash = moduleBuildHash;
		this.isPrimaryFEP = isPrimaryFEP;
		this.subModuleVersionInfo = subModuleVersionInfo;
	}
	
	/**
	 * Copy constructor to do deep copy of VersionInfoInterface implemented object.
	 * @param versionInfo
	 */
	public VersionInfo(VersionInfoInterface versionInfo){
		this.moduleName = versionInfo.getModuleName();
		this.moduleVersion = versionInfo.getModuleVersion();
		this.moduleBuildTime = versionInfo.getModuleBuildTime();
		this.moduleBuildHash = versionInfo.getModuleBuildHash();
		this.isPrimaryFEP = versionInfo.isPrimaryFEP();
		List<VersionInfoInterface> subModuleVersionInfo = versionInfo.getSubModulesVersionInfo();
		if(subModuleVersionInfo!=null){
			List<VersionInfoInterface> newSubModuleVersionInfo = new ArrayList<VersionInfoInterface>();
			for (VersionInfoInterface versionInfoInterface : subModuleVersionInfo) {
				VersionInfo v = new VersionInfo(versionInfoInterface);
				newSubModuleVersionInfo.add(v);
			}
			this.subModuleVersionInfo = newSubModuleVersionInfo;
		}
	}

	@Override
	public String getModuleName() {
		return moduleName;
	}

	@Override
	public String getModuleVersion() {
		return moduleVersion;
	}

	@Override
	public String getModuleBuildTime() {
		return moduleBuildTime;
	}

	@Override
	public String getModuleBuildHash() {
		return moduleBuildHash;
	}
	
	@Override
	public List<VersionInfoInterface> getSubModulesVersionInfo() {
		return subModuleVersionInfo;
	}


	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public void setModuleVersion(String moduleVersion) {
		this.moduleVersion = moduleVersion;
	}

	public void setModuleBuildTime(String moduleBuildTime) {
		this.moduleBuildTime = moduleBuildTime;
	}

	public void setModuleBuildHash(String moduleBuildHash) {
		this.moduleBuildHash = moduleBuildHash;
	}
	
	public void setSubModuleVersionInfo(List<VersionInfoInterface> subModuleVersionInfo) {
		this.subModuleVersionInfo = subModuleVersionInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((moduleName == null) ? 0 : moduleName.hashCode());
		result = prime * result
				+ ((moduleVersion == null) ? 0 : moduleVersion.hashCode());
		return result;
	}

	/**
	 * If the module name and module version are same then both objects are
	 * equal. Module build time and build hash is not considered for objects
	 * compare usually these 2 fields are not mandatory in VersionInfo.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if(obj instanceof VersionInfoInterface){
			VersionInfoInterface other = (VersionInfo) obj;
			if (moduleName == null) {
				if (other.getModuleName() != null){
					return false;
				}
			} else if (!moduleName.equals(other.getModuleName())){
				return false;
			}
			if (moduleVersion == null) {
				if (other.getModuleVersion() != null){
					return false;
				}
			} else if (!moduleVersion.equals(other.getModuleVersion())){
				return false;
			}
		}else{
			return false;
		}
		
		return true;
	}
	
	/**
	 * API to get reference count of the module registered.
	 * @return
	 */
	public int getModulesReferenceCount() {
		return modulesReferenceCount;
	}
	
	/**
	 * API to increment the reference count. Intentionally made API of package
	 * scope for not allowing to change by others except VersionManager..
	 * 
	 * @return this return always success as we can increment the reference count
	 */
	boolean incrementReferenceCount(){
		modulesReferenceCount++;
		return true;
	}
	
	/**
	 * API to decrement the reference count. Intentionally made API of package
	 * scope for not allowing to change by others except VersionManager..
	 * 
	 * @return this return true if it decremented. return false if the reference
	 *         count is already zero.
	 */
	boolean decrementReferenceCount(){
		if(modulesReferenceCount>0){
			modulesReferenceCount--;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "VersionInfo [moduleName=" + moduleName + ", moduleVersion="
				+ moduleVersion + "]";
	}
	
	/**
	 * API to provide all the sub module version details in HashMap representation.
	 * Outer HashMap - Key sub module name, Value subversion details.
	 * Inner HashMap - Key will be attribute(name,version,build time, build hash) and value will be value of attribute.
	 * 
	 * @return map of subversion details 
	 * EX :	{
	 * 		  Viper Codec={Module-Name=Viper Codec, Module-Version=1.0.0,Module-Build-Time=2016-04-03 12:30:22, Module-Hash=some hash1},
	 *		  Viper Agent={Module-Name=Viper Agent, Module-Version=1.0.0,Module-Build-Time=2016-04-03 12:30:22, Module-Hash=some hash1},
	 * 		  Viper Channel={Module-Name=Viper Channel, Module-Version=1.0.1,Module-Build-Time=2016-04-03 12:30:22, Module-Hash=some hash2},
	 * 		  Viper Report={Module-Name=Viper Report, Module-Version=1.0.0,Module-Build-Time=2016-04-03 12:30:22, Module-Hash=some hash1},
	 * 		}
	 */
	public Map<String, Map<String, String>> getSubModulesVersionInfoMap() {
		Map<String, Map<String, String>> dataMap = new HashMap<String, Map<String, String>>();
		List<VersionInfoInterface> subModuleVersionInfoList = getSubModulesVersionInfo();
		if (subModuleVersionInfoList != null && !subModuleVersionInfoList.isEmpty()) {
			for (VersionInfoInterface versionInfoInterface : subModuleVersionInfoList) {
				Map<String, String> subModuleDataMap = new HashMap<String, String>();
				String name = versionInfoInterface.getModuleName();
				String version = versionInfoInterface.getModuleVersion();
				String buildTime = versionInfoInterface.getModuleBuildTime();
				String buildHash = versionInfoInterface.getModuleBuildHash();
				if (name != null && !name.trim().isEmpty() 
						&& version != null && !version.trim().isEmpty()) {
					subModuleDataMap.put(VersionManagerConstants.MODULE_NAME,name);
					subModuleDataMap.put(VersionManagerConstants.MODULE_VERSION, version);
					if (buildTime != null && !buildTime.trim().isEmpty()) {
						subModuleDataMap.put(VersionManagerConstants.MODULE_BUILD_TIME,buildTime);
					}
					if (buildHash != null && !buildHash.trim().isEmpty()) {
						subModuleDataMap.put(VersionManagerConstants.MODULE_HASH, buildHash);
					}
					dataMap.put(versionInfoInterface.getModuleName(),subModuleDataMap);
				}
			}
		}
		return dataMap;
	}
	
	/**
	 * API to provide all the sub module version details in HashMap representation.
	 * Outer container is List.
	 * Inner container is HashMap - Key will be attribute(name,version,build time, build hash) and value will be value of attribute.
	 * 
	 * @return map of subversion details 
	 * EX :	{
	 * 			{Module-Name=Viper Codec, Module-Version=1.0.0,Module-Build-Time=2016-04-03 12:30:22, Module-Hash=some hash1},
	 *			{Module-Name=Viper Agent, Module-Version=1.0.0,Module-Build-Time=2016-04-03 12:30:22, Module-Hash=some hash1},
	 * 			{Module-Name=Viper Channel, Module-Version=1.0.1,Module-Build-Time=2016-04-03 12:30:22, Module-Hash=some hash2},
	 * 			{Module-Name=Viper Report, Module-Version=1.0.0,Module-Build-Time=2016-04-03 12:30:22, Module-Hash=some hash1},
	 * 		}
	 */
	public List<Map<String, String>> getSubModulesVersionInfoListMap() {
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		List<VersionInfoInterface> subModuleVersionInfoList = getSubModulesVersionInfo();
		if (subModuleVersionInfoList != null && !subModuleVersionInfoList.isEmpty()) {
			for (VersionInfoInterface versionInfoInterface : subModuleVersionInfoList) {
				Map<String, String> subModuleDataMap = new HashMap<String, String>();
				String name = versionInfoInterface.getModuleName();
				String version = versionInfoInterface.getModuleVersion();
				String buildTime = versionInfoInterface.getModuleBuildTime();
				String buildHash = versionInfoInterface.getModuleBuildHash();
				if (name != null && !name.trim().isEmpty() 
						&& version != null && !version.trim().isEmpty()) {
					subModuleDataMap.put(VersionManagerConstants.MODULE_NAME,name);
					subModuleDataMap.put(VersionManagerConstants.MODULE_VERSION, version);
					if (buildTime != null && !buildTime.trim().isEmpty()) {
						subModuleDataMap.put(VersionManagerConstants.MODULE_BUILD_TIME,buildTime);
					}
					if (buildHash != null && !buildHash.trim().isEmpty()) {
						subModuleDataMap.put(VersionManagerConstants.MODULE_HASH, buildHash);
					}
					dataList.add(subModuleDataMap);
				}
			}
		}
		return dataList;
	}
	
	public boolean isPrimaryFEP() {
		return isPrimaryFEP;
	}

	public void setPrimaryFEP(boolean isPrimaryFEP) {
		this.isPrimaryFEP = isPrimaryFEP;
	}
}
