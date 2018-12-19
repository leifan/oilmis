package com.mltech.brite.util;

import java.util.HashMap;


/**
 * 存储文件名称fileName和对应的fileUtil对象
 * @author user
 *
 */
public class FileMap {
	
	private static HashMap<String, FileUtil> fileMap = new HashMap<String,FileUtil>();
	
	public static void registerFile(String fileName,FileUtil fileUtil){
		String[] arrStrings = fileName.split("/");
		fileName = arrStrings[arrStrings.length-1];
		fileMap.put(fileName, fileUtil);
	}
	

}
