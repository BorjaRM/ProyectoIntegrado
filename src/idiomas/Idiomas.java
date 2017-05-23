package idiomas;

import java.util.ResourceBundle;

public class Idiomas {

	static ResourceBundle bundle = null;
	String var_idioma = new String("");
	
	
	private Idiomas() {
		//Esto no hace na
		
	}

	public static ResourceBundle newIdioma(String idioma) {
		
		//Seleccion entre un idioma y otro
		
		if (bundle == null) {
			if (idioma == "ingles") {
				
				bundle = ResourceBundle.getBundle("en_UK");
			} else {
			
				bundle = ResourceBundle.getBundle("es_ES");
			}
		}
		
		return bundle;
	}
	
	public static ResourceBundle getBundle() {
		
		return bundle;
	}
}
