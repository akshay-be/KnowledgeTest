/*
 * Created on April 4, 2016 
 * Author: akshayb1
 * Verifone Inc., Copyright(c) 2016 All rights reserved
 */
package com.verifone.isd.viper.eps.version;

import java.util.ArrayList;
import java.util.List;

/**
 * Data bean class which implements VersionInfoInterface
 * to update the versions to VersionManager.
 * @author akshayb1
 *
 */
public final class VersionInfo implements VersionInfoInterface {

	private int modulesReferenceCount = 1;
	private String moduleName;
	private String moduleVersion;
	private String moduleBuildTime;
	private String moduleBuildHash;
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
	 * Copy constructor to do deep copy of VersionInfoInterface implemented object.
	 * @param versionInfo
	 */
	public VersionInfo(VersionInfoInterface versionInfo){
		this.moduleName = versionInfo.getModuleName();
		this.moduleVersion = versionInfo.getModuleVersion();
		this.moduleBuildTime = versionInfo.getModuleBuildTime();
		this.moduleBuildHash = versionInfo.getModuleBuildHash();
		List<VersionInfoInterface> subModuleVersionInfo = versionInfo.getSubModuleVersionInfo();
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
	public List<VersionInfoInterface> getSubModuleVersionInfo() {
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
	 * If the module name and module version are same then both objects are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VersionInfo other = (VersionInfo) obj;
		if (moduleName == null) {
			if (other.moduleName != null)
				return false;
		} else if (!moduleName.equals(other.moduleName))
			return false;
		if (moduleVersion == null) {
			if (other.moduleVersion != null)
				return false;
		} else if (!moduleVersion.equals(other.moduleVersion))
			return false;
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
}
