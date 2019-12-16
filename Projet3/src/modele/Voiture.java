package modele;

import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Voiture extends ImageView {
	
	
	private String couleur;
	private int longueur;
	private int colonne;
	private int ligne;
	private EnumDirectionVoitures direction;
	private int[][] tabVoiture ;





	String fichierImageVoture;
	double dblX;
	double dblY;
	
	



	public Voiture(String couleur, int longueur, int colonne, int ligne, EnumDirectionVoitures direction,
			String fichierImageVoture, double dblX, double dblY) {
		super();
		this.couleur = couleur;
		this.longueur = longueur;
		this.colonne = colonne;
		this.ligne = ligne;
		this.direction = direction;
		this.fichierImageVoture = fichierImageVoture;
		this.dblX = dblX;
		this.dblY = dblY;
		this.setImage(new Image(fichierImageVoture)); //associe l'image a l'objet voiture
		
		this.tabVoiture = new int[6][6];

		if (direction.getStrOrientation() == "H") {
			for (int i = 0; i < longueur; i++) {
				tabVoiture[(int) ligne][(int) colonne+i] =1;
				
			}
		} else {
			for (int i = 0; i < longueur; i++) {
				tabVoiture[(int) ligne+i][(int) colonne] =1;
			}
		}

		/*for(int i = 0; i < tabVoiture.length;i++) {
			for(int j = 0; j < tabVoiture.length;j++) {
				tabVoiture[i][j] = 1;
			}
		}*/
	}


	public int[][] getTabVoiture() {
		return tabVoiture;
	}




	public void setTabVoiture(int[][] tabVoiture) {
		this.tabVoiture = tabVoiture;
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




	public String getFichierImageVoture() {
		return fichierImageVoture;
	}




	public void setFichierImageVoture(String fichierImageVoture) {
		this.fichierImageVoture = fichierImageVoture;
	}




	public double getDblX() {
		return dblX;
	}




	public void setDblX(double dblX) {
		this.dblX = dblX;
	}




	public double getDblY() {
		return dblY;
	}




	@Override
	public String toString() {
		return "Voiture [couleur=" + couleur + ", longueur=" + longueur + ", colonne=" + colonne + ", ligne=" + ligne
				+ ", direction=" + direction + ", fichierImageVoture=" + fichierImageVoture + ", dblX=" + dblX
				+ ", dblY=" + dblY + "]";
	}




	public void setDblY(double dblY) {
		this.dblY = dblY;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
