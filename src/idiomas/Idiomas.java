package idiomas;

import java.util.ResourceBundle;

public class Idiomas {

	private static ResourceBundle bundle = null;
	String var_idioma = new String("");
	
	
	private Idiomas() {
		//Esto no hace na
		
	}

	public static ResourceBundle newIdioma(String idioma) {
		
		//Seleccion entre un idioma y otro
		
		if (bundle == null) {
			
			switch (idioma) {
			
			case "Español": 
				bundle = ResourceBundle.getBundle("idiomas/es_ES");
				break;
			case "English":
				bundle = ResourceBundle.getBundle("idiomas/en_UK");
				break;
				
			default:
				bundle = ResourceBundle.getBundle("idiomas/es_ES");
				break;
			}
		}
		
		return bundle;
	}
	
	public static ResourceBundle getBundle() {
		
		return bundle;
	}
}
