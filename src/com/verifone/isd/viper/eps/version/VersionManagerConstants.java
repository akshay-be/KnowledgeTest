/*
 * Created on April 4, 2016 
 * Author: akshayb1
 * Verifone Inc., Copyright(c) 2016 All rights reserved
 */
package com.verifone.isd.viper.eps.version;

/**
 * The interface to define constants.
 * @author AkshayB1
 *
 */
public interface VersionManagerConstants {
	public String UNDERSCORE_SEPARATOR = "_";
	public String MODULE_NAME = "Module-Name";
	public String MODULE_VERSION = "Module-Version";
	public String MODULE_BUILD_TIME = "Module-Build-Time";
	public String MODULE_HASH = "Module-Hash";
	public String VERSION_REGEX = "[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{1,2}";
	//IF 2 digits is not mandatory use regex :  [0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9]
	public String MODULE = "Module";
	public String NAME = "Name";
	public String VERSION = "Version";
	public String BUILD_TIME = "Build-Time";
	public String HASH = "Module-Hash";
	public String VIPER_CORE = "Viper Core";
	public String DEFAULT_VERSION = "0.0.0";
}
