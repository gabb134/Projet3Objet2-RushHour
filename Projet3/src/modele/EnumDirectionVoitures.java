package modele;

public enum EnumDirectionVoitures {HORIZONTALE("H"),VERTICAL("V");
private String strOrientation;
	
EnumDirectionVoitures(String strOrientation) {
        this.strOrientation = strOrientation;
    }

	public String getStrOrientation() {
		return strOrientation;
	}
}
