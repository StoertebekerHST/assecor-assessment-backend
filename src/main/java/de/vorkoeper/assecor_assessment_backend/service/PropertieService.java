package de.vorkoeper.assecor_assessment_backend.service;

import javax.naming.ConfigurationException;

import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertieService {
	private static PropertiesConfiguration prop;
	
	/**
	 * PropertiesConfiguration
	 *  
	 * @param Propertie-Filename
	 * @throws org.apache.commons.configuration.ConfigurationException 
	 */
	public PropertieService() throws org.apache.commons.configuration.ConfigurationException {
			prop = new PropertiesConfiguration(PropertieService.class.getClassLoader().getResource(".").getPath() + "/.properties");

	}
	
	/**
	 * Getter für Properties
	 * 
	 * @param Propertiename
	 * @return Propertieswert
	 */
	public String getProperty(String name) {

        return prop.getString(name);
    }
}
