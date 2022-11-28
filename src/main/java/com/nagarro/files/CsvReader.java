package com.nagarro.files;

import java.io.FileReader;
import java.io.IOException;
import javax.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.nagarro.model.TShirt;

/**
 * 
 * Class for parse csv file and insert data into database
 **/
@Component
public class CsvReader {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// Method to insert data from csv file to database
	public void insertCsvRecordIntoDatabase() {

		/*
		 * create an object of session to connect db
		 */

		Session session = hibernateTemplate.getSessionFactory().openSession();
		// file reader object
		FileReader currentCsvFile = null;
		int csvFileIndex = 0;
		// loop to iterate all files in file list
		try {
			while (csvFileIndex < Files.filesList.length) {

				currentCsvFile = new FileReader(Files.filesList[csvFileIndex]); // creating object to read file

				// read and parse csv file by passing FileReader
				CSVReader csvReader = new CSVReaderBuilder(currentCsvFile).withSkipLines(1).build();

				String[] row; // to store 1 line of csv file

				while ((row = csvReader.readNext()) != null) { // initialize current line in row string
					String[] column = row[0].split("\\|"); // split line by '|' and storing in column

					// starts a new transaction
					Transaction transaction = session.beginTransaction();

					session.save(new TShirt(column[0], column[1], column[2], column[3], column[4],
							Float.parseFloat(column[5]), Float.parseFloat(column[6]), column[7]));

					try {
						transaction.commit();
					}
					// catch if any of acid properties is violated
					catch (PersistenceException l) { // if try to insert same data
						transaction.rollback();
						break; // break the loop because current file already present in database
					} catch (Exception e) {
						transaction.rollback();
						break;
					}

				}

				csvFileIndex++;
			}
		} catch (Exception e) {
			if(e instanceof CsvValidationException |e instanceof IOException | e instanceof NullPointerException) {
				System.out.println("Csv file not available or Data not valid in Csv file");
			} else { System.out.println(e);}
		}
		session.close();
	}
}
