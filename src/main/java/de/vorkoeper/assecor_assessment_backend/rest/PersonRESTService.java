package de.vorkoeper.assecor_assessment_backend.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.exception.ExceptionUtils;

import de.vorkoeper.assecor_assessment_backend.model.Person;
import de.vorkoeper.assecor_assessment_backend.service.DataService;


@Path("/persons")
public class PersonRESTService {

	//http://localhost:8080/Lovecolor/rest/persons/
	
	/**
	 * Restservice für Personenliste
	 * @return JSON mit Personenliste
	 */
	@Path("/")
	@GET
	@Produces("application/json")
	public String getPersons_JSON() {
		try {
		
		String returnString = "[";
			for (Person iPerson : DataService.getPersonList()) {
				returnString = returnString + iPerson.getJSONSring()+",";
			}	
		returnString = returnString.substring(0, returnString.length()-1)+"]";
		
		return returnString;
		} catch (Exception e) {
			return error_JSON(e);
		}
	}
		
	
	//http://localhost:8080/Lovecolor/rest/persons/4
	/**
	 * Restservice für eine Person mittels Personen-ID
	 * @param id Personen-ID
	 * @return JSON mit Person
	 * @throws Exception
	 */
	@Path("/{ID}")
	@GET
	@Produces("application/json")
	public String getPersonByID_JSON(@PathParam("ID") Integer id) throws Exception {
		try {
			return DataService.getPersonByID(id).getJSONSring();
		} catch (Exception e) {
			return error_JSON(e);
		}
	}				
		
	
	//http://localhost:8080/Lovecolor/rest/persons/color/blau
	
	/**
	 * Restservice für Personenliste mittels Lieblingsfarbe
	 * @param color Lieblingsfarbe
	 * @return JSON mit Personenliste mit der Lieblingsfarbe
	 */
	@Path("color/{color}")
	@GET
	@Produces("application/json")
	public String getPersonsColor_JSON(@PathParam("color") String color) {
		try {
			String returnString = "[";
			
			for (Person iPerson : DataService.getPersonListbyColor(color)) {
				returnString = returnString + iPerson.getJSONSring()+",";
			}
			
			returnString = returnString.substring(0, returnString.length()-1)+"]";
			
			return returnString;
		} catch (Exception e) {
			return error_JSON(e);
		}
	}
	
	/**
	 * Restservice für für Exceptions
	 * @param e Aufgetretene Exception
	 * @return JSON mit Exceptiondaten
	 */
	public String error_JSON(Exception e) {
		
		String returnString = "{\n" +
				"\"Error\" : \""+e.getClass().getName()+
				"\",\n\"Errormassage\" : \"" + e.getMessage()+
		//		"\",\n\"StackTrace\" : \"" + ExceptionUtils.getStackTrace(e).replace("\r", "").replace("\t", "").replace("\n", "") +
				"\"\n}";
		return returnString;
	}

}
