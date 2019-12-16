package modele;
/**
 * Classe qui peremt d'obtenir les directions des voitures.
 *
 * @author Gabriel Marrero
 * @version 1.0 2019-12-15
 */
public enum EnumDirectionVoitures {HORIZONTALE("H"),VERTICAL("V");
private String strOrientation;
	
EnumDirectionVoitures(String strOrientation) {
        this.strOrientation = strOrientation;
    }
/**Les getters et les setters
*
* C'est m�thodes permettent aux variables priv�e d'�tre utilis� ailleurs
*
* @param <strOrientation> <fonction>
* 

* @return <Elles retournent les variables en tant que tel>
*/
	public String getStrOrientation() {
		return strOrientation;
	}
}
