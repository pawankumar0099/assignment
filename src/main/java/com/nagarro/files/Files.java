package com.nagarro.files;

import java.io.File;

/**
 * Class for Files
 **/
public class Files {
	public static File files = new File(
			"C:\\Users\\pawan\\Desktop\\New folder");
	// create list of files and add all the files present in given path
	public static File filesList[] = files.listFiles();

}
