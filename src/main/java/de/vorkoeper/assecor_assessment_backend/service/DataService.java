package de.vorkoeper.assecor_assessment_backend.service;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.configuration.ConfigurationException;

import de.vorkoeper.assecor_assessment_backend.csv.CSVPerson;
import de.vorkoeper.assecor_assessment_backend.model.Color;
import de.vorkoeper.assecor_assessment_backend.model.Person;

public class DataService {

	/**
	 * DatenService zum Laden der Personenliste
	 * @return Liste der Personen
	 * @throws Exception
	 */
	public static Collection<Person> getPersonList() throws Exception {
		PropertieService propService = new PropertieService();
		CSVPerson persons = new CSVPerson(propService.getProperty("csvdatei"));
		return persons.getPersonList().values();
		
	}
	
	/**
	 * DatenService zum Laden einer Personen durch Personen-ID
	 * @param ID ID der Person
	 * @return Person
	 * @throws Exception
	 */
	public static Person getPersonByID(Integer ID) throws Exception {
		PropertieService propService = new PropertieService();
		CSVPerson persons = new CSVPerson(propService.getProperty("csvdatei"));
		return persons.getPersonList().get(ID);
		
	}

	/**
	 * DatenService zum Laden der Personenliste nach Lieblingsfarbe
	 * @param color Lieblingsfarbe der Personen
	 * @return Liste der Personen mit der Lieblingsfarbe
	 * @throws Exception
	 */
	public static Collection<Person> getPersonListbyColor(String color) throws Exception {
		PropertieService propService = new PropertieService();
		CSVPerson persons = new CSVPerson(propService.getProperty("csvdatei"));
		
		Collection<Person> personList = persons.getPersonList().values();
		Collection<Person> returnpersonList=new ArrayList<Person>();
		String searchColor = Color.getColor(color);
		
		for (Person person : personList) {
			if(person.getColor()==searchColor) {
				returnpersonList.add(person);
			}
				
		}
		
		return returnpersonList;
	}
	
	
	/**
	 * DatenService zum hinzufügen einer neuen Person
	 * @param addPerson neue Person
	 * @return neue Person mit ID
	 * @throws Exception
	 */
	public static Person addPerson(Person addPerson) throws Exception {
		PropertieService propService = new PropertieService();
		CSVPerson persons = new CSVPerson(propService.getProperty("csvdatei"));
		return persons.addPerson(addPerson);
		
	}
}
