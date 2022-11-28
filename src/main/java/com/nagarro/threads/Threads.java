package com.nagarro.threads;

import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.files.CsvReader;
import com.nagarro.files.Files;

/**
 * Class for thread, updates file list if new file is added in directory
 * 
 **/
@Component
public class Threads extends TimerTask {

	@Autowired
	CsvReader csvReader;

	public void run() {
		int fileListLen = Files.filesList.length; // length of list before check for new files
		Files.filesList = Files.files.listFiles();

		// if length is changed then add new file into database
		if (fileListLen < Files.filesList.length) {
			csvReader.insertCsvRecordIntoDatabase();
		}
	}

}
