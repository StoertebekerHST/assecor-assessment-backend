package de.vorkoeper.assecor_assessment_backend.model;

public class Color {

	/**
	 * Methode zur bestimmung der Farbe
	 * @param color Farbe(deu/eng) oder Farb-ID
	 * @return "Offizelle" Farbbezeichnung
	 * @throws Exception
	 */
	public static String getColor(String color) throws Exception {
		
		color = color.trim().toLowerCase();
		
		switch (color) {
			case "1":
			case "blau":
			case "blue":
				return "blau";
			
			case "2":
			case "grün":
			case "gruen":
			case "green":
				return "grün";
			
			case "3":
			case "violett":
			case "violet":
				return "violett";
				
			case "4":
			case "rot":
			case "red":
				return "rot";
				
			case "5":
			case "gelb":
			case "yellow":
				return "gelb";
				
			case "6":
			case "türkis":
			case "tuerkis":
			case "turquoise":
				return "türkis";
			
			case "7":
			case "weiß":
			case "white":
				return "weiß";
			
			
			default:
				throw new Exception("Farbe "+color+" konnte nicht als valide Farbe erkannt werden!");
			}
		

	}
	/**
	 * Methode zur bestimmung der Farb-ID
	 * @param color Farbe(deu/eng) oder Farb-ID
	 * @return Farb-ID
	 * @throws Exception
	 */
	public static String getColorID(String color) throws Exception {
		
		color = color.trim().toLowerCase();
		
		switch (color) {
			case "1":
			case "blau":
			case "blue":
				return "1";
			
			case "2":
			case "grün":
			case "gruen":
			case "green":
				return "2";
			
			case "3":
			case "violett":
			case "violet":
				return "3";
				
			case "4":
			case "rot":
			case "red":
				return "4";
				
			case "5":
			case "gelb":
			case "yellow":
				return "5";
				
			case "6":
			case "türkis":
			case "tuerkis":
			case "turquoise":
				return "6";
			
			case "7":
			case "weiß":
			case "white":
				return "7";
			
			
			default:
				throw new Exception("Farbe "+color+" konnte nicht als valide Farbe erkannt werden!");
			}
		

	}
}
