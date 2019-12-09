package modele;

public class Voiture {
	private String couleur;
	private int longueur;
	private int colonne;
	private int ligne;
	private EnumDirectionVoitures direction;
	


	public Voiture(String couleur, int longueur, int colonne, int ligne, EnumDirectionVoitures direction) {
		super();
		this.couleur = couleur;
		this.longueur = longueur;
		this.colonne = colonne;
		this.ligne = ligne;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Voiture [couleur=" + couleur + ", longueur=" + longueur + ", colonne=" + colonne + ", ligne=" + ligne
				+ ", direction=" + direction + "]";
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public EnumDirectionVoitures getDirection() {
		return direction;
	}

	public void setDirection(EnumDirectionVoitures direction) {
		this.direction = direction;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
