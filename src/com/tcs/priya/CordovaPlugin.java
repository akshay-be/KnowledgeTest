package com.tcs.priya;

/**
 * 
 * @author eshak01
 *
 */
public abstract class CordovaPlugin {

   public abstract boolean  execute(String action, String args, final CallbackContext callbackContext) ;
}


