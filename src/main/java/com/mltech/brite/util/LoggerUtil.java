package com.mltech.brite.util;

import org.apache.log4j.Logger;

public class LoggerUtil extends Logger{

	protected LoggerUtil(String name) {
		super(name);
	}
	
	public static void error(String msg ,Exception e){
//		Logger.getLogger("errorLogger").info(msg+e);
		Logger.getLogger("errorLogger").error(msg, e);
	}

	public static void inout(Object e){
		Logger.getLogger("inOutLogger").info(e);
	}
	
	public static void outin(Object e){
		Logger.getLogger("outInLogger").info(e);
	}
	
}
