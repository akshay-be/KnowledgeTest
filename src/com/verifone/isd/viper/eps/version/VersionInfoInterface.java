/*
 * Created on April 4, 2016 
 * Author: akshayb1
 * Verifone Inc., Copyright(c) 2016 All rights reserved
 */
package com.verifone.isd.viper.eps.version;

import java.util.List;

/**
 * Interface defines the version details should be provided.
 * @author akshayb1
 *
 */
public interface VersionInfoInterface {

	/** API to provide the module name. Ex : Core Viper, FSA, Loyalty */
	public String getModuleName();

	/** API to provide the module version. */
	public String getModuleVersion();

	/** API to provide the module build time */
	public String getModuleBuildTime();

	/** API to provide the build hash */
	public String getModuleBuildHash();
	
	public boolean isPrimaryFEP();
	
	/** API to provide the sub module version info associated with module.*/
	public List<VersionInfoInterface> getSubModulesVersionInfo();

}
