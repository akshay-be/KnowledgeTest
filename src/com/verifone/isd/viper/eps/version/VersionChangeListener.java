/*
 * Created on August 09, 2016 
 * Author: akshayb1
 * Verifone Inc., Copyright(c) 2016 All rights reserved
 */
package com.verifone.isd.viper.eps.version;

import java.util.List;

/**
 * Interface for version details change listener. If implementations class for
 * this interface is registered with version manager. then version manager will
 * notify that object for every version details change.
 * 
 * @author AkshayB1
 * 
 */
public interface VersionChangeListener {

	/**
	 * when the version details updated then version manager will notify all
	 * registered listeners.
	 * 
	 * @param data
	 *            - list of updated version info details. This contains the deep
	 *            copy objects of what version manger contains version details.
	 *            This will be an un-modifiable list.
	 */
	public void versionDetailsUpdated(List<VersionInfoInterface> versionInfo);
}
