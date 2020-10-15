package de.vorkoeper.assecor_assessment_backend.csv;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.HashMap;

import com.opencsv.CSVReader;
import de.vorkoeper.assecor_assessment_backend.model.Person;

public class CSVPerson {
	
	private String csvFile;

	/**
	 * Construktor für CSVPerson zum Einlesen der Personen-CSV
	 * @param _csvFile
	 */
	public CSVPerson(String _csvFile) {
		setCsvFile(_csvFile);
	}

	public String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		//TODO: File-Test
		this.csvFile = csvFile;
	}
	
	/**
	 * Methode zum einlesen der Personen-CSV
	 * @return HashMap mit Personen aus der CSV
	 * @throws Exception
	 */
	public HashMap<Integer,Person> getPersonList() throws Exception {
		
		HashMap<Integer,Person> personList = new HashMap<Integer,Person>();
		//CSVReader reader = new CSVReader(new FileReader(csvFile));
		CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(csvFile),"UTF-8"));
		Integer PersonID = 1;
		
		String [] line;
		Integer lineCounter=0;
		
		while ((line = reader.readNext()) != null) {
			//Leere Zeile / Gelöschte Person?
			if(line[0].trim().equals("") && line.length == 1)
			{
				PersonID++;
				continue;
			}
			
			//Zeile enthält mehr Informationen, zuordnung nicht eindeutig möglich
			if(line.length>4)
			{
				throw new Exception ("CSV-Datei kann nicht verarbeitet werden, da in Zeile " + lineCounter+ " mehr Einträge (>4) existieren, als verarbeit werden können!");
			}
			

			String [] personData = new String[4];
			Integer personDataI = 0;
			
			for (int i = 0; i < line.length; i++) {
				//Ist der Datensatz auf mehr als 1 Zeile verteilt?
				if(line[i].trim().equals("") && (i+1)==line.length)
				{
					i=-1;
					line = reader.readNext();
					continue;
				}
				personData[personDataI]=line[i].trim();
				personDataI++;
			}
		
			String zipcode = personData[2].substring(0, personData[2].indexOf(" "));
			String city = personData[2].substring(personData[2].indexOf(" ")+1);
			Person addPerson = new Person(PersonID, personData[1],  personData[0], zipcode, city,  personData[3]);
			personList.put(PersonID,addPerson);
			
			PersonID++;
	    }
	     
	     return personList;
		
	}
}
