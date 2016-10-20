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
	public static final  String UNDERSCORE_SEPARATOR = "_";
	public static final String MODULE_NAME = "Module-Name";
	public static final String MODULE_VERSION = "Module-Version";
	public static final String MODULE_BUILD_TIME = "Module-Build-Time";
	public static final String MODULE_HASH = "Module-Hash";
	public static final String VERSION_REGEX = "[a-zA-Z0-9]{1,2}\\.[a-zA-Z0-9]{1,2}\\.[a-zA-Z0-9]{1,2}";
	public static final String MODULE = "Module";
	public static final String NAME = "Name";
	public static final String VERSION = "Version";
	public static final String BUILD_TIME = "Build-Time";
	public static final String HASH = "Module-Hash";
	public static final String VIPER_CORE = "Viper Core";
	public static final String DEFAULT_VERSION = "0.0.0";
	
	public static final String PrimaryFEP = "PrimaryFEP";
	public static final String ViperModule  = "ViperModule";
	public static final String ViperDemonModule  = "ViperDemonModule";
	
	public static final int VERSION_MIN_LENGTH = 5;
	public static final int VERSION_MAX_LENGTH = 8;
}
