package de.vorkoeper.assecor_assessment_backend.model;

import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

	private Integer id;
	private String name;
	private String lastname;
	private String zipcode;
	private String city;
	private String color;
	
	public Person() {
		
	}
	

	/**
	 * Consruktor von Person
	 * @param _id Person-ID
	 * @param _name Vorname
	 * @param _lastname Nachname
	 * @param _zipcode PLZ
	 * @param _city Stadt
	 * @param _color Lieblingsfarbe
	 * @throws Exception
	 */
	public Person(Integer _id, String _name, String _lastname, String _zipcode, String _city, String _color) throws Exception {
		setId(_id);
		setName(_name);
		setLastname(_lastname);
		setZipcode(_zipcode);
		setCity(_city);
		setColor(_color);
	}


	/**
	 * Methode zum erstellen eines JSON-String von der Person 
	 * @return JSON-String von der Person
	 */
	public String getJSONSring() {
		String jsonString = "{\n\"id\" : " + getId()
		+",\n\"name\" : \""+getName()
		+"\",\n\"lastname\" : \""+getLastname()
		+"\",\n\"zipcode\" : \""+getZipcode()
		+"\",\n\"city\" : \""+getCity()
		+"\",\n\"color\" : \""+getColor()
		+"\"\n}";
		
		return jsonString;
	}


	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getZipcode() {
		return zipcode;
	}




	public void setZipcode(String zipcode) throws Exception {
		if(Pattern.matches("\\d{5}", zipcode))
		{
			this.zipcode = zipcode;
		}
		else
		{
			throw new Exception("Fehler bei der PLZ; "+zipcode+" ist keine gültige PLZ");
		}
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getColor() {
		return color;
	}




	public void setColor(String color) throws Exception {
		this.color = Color.getColor(color);
	}
	
	
}
