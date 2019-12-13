package modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;



public class LectureDesDonnees {
	
	public ArrayList<Voiture> getArrVoituresFaciles() {
		return arrVoituresFaciles;
	}
	public void setArrVoituresFaciles(ArrayList<Voiture> arrVoituresFaciles) {
		this.arrVoituresFaciles = arrVoituresFaciles;
	}
	public ArrayList<Voiture> getArrVoituresMoyennes() {
		return arrVoituresMoyennes;
	}
	public void setArrVoituresMoyennes(ArrayList<Voiture> arrVoituresMoyennes) {
		this.arrVoituresMoyennes = arrVoituresMoyennes;
	}
	public ArrayList<Voiture> getArrVoituresDifficiles() {
		return arrVoituresDifficiles;
	}
	public void setArrVoituresDifficiles(ArrayList<Voiture> arrVoituresDifficiles) {
		this.arrVoituresDifficiles = arrVoituresDifficiles;
	}


	private ArrayList<Voiture> arrVoituresFaciles = new ArrayList<Voiture>();
	private ArrayList<Voiture> arrVoituresMoyennes = new ArrayList<Voiture>();
	private ArrayList<Voiture> arrVoituresDifficiles = new ArrayList<Voiture>();

	Voiture voitureFacile;
	
	public LectureDesDonnees(String fichierfacile,String fichierMoyen,String fichierDifficile) {
		
		//POUR LE FICHIER FACILE
		BufferedReader brFichierFacile = null;
		String strLigneFacile;
		StringTokenizer stFacile;
		 String couleurFacile;
		 int longueurFacile;
		 int colonneFacile;
		 int ligneFacile;
		 EnumDirectionVoitures directionFacile = null;
		
		
		try {
			brFichierFacile = new BufferedReader(new FileReader(fichierfacile));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			while ((strLigneFacile = brFichierFacile.readLine()) != null) {

				try {
		
					stFacile = new StringTokenizer(strLigneFacile,",");
					couleurFacile = stFacile.nextToken().trim();
					longueurFacile = Integer.parseInt(stFacile.nextToken().trim());
					colonneFacile =  Integer.parseInt(stFacile.nextToken().trim());
					ligneFacile =  Integer.parseInt(stFacile.nextToken().trim());
					
					switch(stFacile.nextToken()) {
					case "V":
						directionFacile = EnumDirectionVoitures.VERTICAL;
						break;
					case "H":
						directionFacile = EnumDirectionVoitures.HORIZONTALE;
						break;
					
					}
					
				//	 voitureFacile = new Voiture(couleurFacile, longueurFacile, colonneFacile, ligneFacile, directionFacile);
					//arrVoituresFaciles.add(voitureFacile);
					
					//System.out.println(directionFacile.getStrOrientation());
					
				} catch (NoSuchElementException e) {

				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		//POUR LE FICHIER MOYEN
		BufferedReader brFichierMoyen = null;
		String strLigneMoyen;
		StringTokenizer stMoyen;
		 String couleurMoyen;
		 int longueurMoyen;
		 int colonneMoyen;
		 int ligneMoyen;
		 EnumDirectionVoitures directionMoyen = null;

			try {
				brFichierMoyen = new BufferedReader(new FileReader(fichierMoyen));

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {

				while ((strLigneMoyen = brFichierMoyen.readLine()) != null) {

					try {
			
						stMoyen = new StringTokenizer(strLigneMoyen,",");
						couleurMoyen = stMoyen.nextToken().trim();
						longueurMoyen = Integer.parseInt(stMoyen.nextToken().trim());
						colonneMoyen =  Integer.parseInt(stMoyen.nextToken().trim());
						ligneMoyen =  Integer.parseInt(stMoyen.nextToken().trim());
						
						switch(stMoyen.nextToken()) {
						case "V":
							directionMoyen = EnumDirectionVoitures.VERTICAL;
							break;
						case "H":
							directionMoyen = EnumDirectionVoitures.HORIZONTALE;
							break;
						
						}
						
					//	Voiture voitureMoyenne = new Voiture(couleurMoyen, longueurMoyen, colonneMoyen, ligneMoyen, directionMoyen);
					//	arrVoituresMoyennes.add(voitureMoyenne);
						
						//System.out.println(directionFacile.getStrOrientation());
						
					} catch (NoSuchElementException e) {

					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
		//POUR LE FICHIER DIFFICILE
			BufferedReader brFichierDifficile = null;
			String strLigneDifficile;
			StringTokenizer stDifficile;
			 String couleurDifficile;
			 int longueurDifficile;
			 int colonneDifficile;
			 int ligneDifficile;
			 EnumDirectionVoitures directionDifficile = null;
		
			 try {
					brFichierDifficile = new BufferedReader(new FileReader(fichierDifficile));

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			 try {

					while ((strLigneDifficile = brFichierDifficile.readLine()) != null) {

						try {
				
							stDifficile = new StringTokenizer(strLigneDifficile,",");
							couleurDifficile = stDifficile.nextToken().trim();
							longueurDifficile = Integer.parseInt(stDifficile.nextToken().trim());
							colonneDifficile =  Integer.parseInt(stDifficile.nextToken().trim());
							ligneDifficile =  Integer.parseInt(stDifficile.nextToken().trim());
							
							switch(stDifficile.nextToken()) {
							case "V":
								directionDifficile = EnumDirectionVoitures.VERTICAL;
								break;
							case "H":
								directionDifficile = EnumDirectionVoitures.HORIZONTALE;
								break;
							
							}
							
							//Voiture voitureDifficile = new Voiture(couleurDifficile, longueurDifficile, colonneDifficile, ligneDifficile, directionDifficile);
							//arrVoituresDifficiles.add(voitureDifficile);
							
							//System.out.println(directionFacile.getStrOrientation());
							
						} catch (NoSuchElementException e) {

						}
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.toString());
				}
			 
			 
				
	}
	public Voiture getVoitureFacile() {
		return voitureFacile;
	}
	public void setVoitureFacile(Voiture voitureFacile) {
		this.voitureFacile = voitureFacile;
	}
	public void affichage() {
		
		for(Voiture v:arrVoituresDifficiles) {
			System.out.println(v.toString());
		}
	}
	
	
	public static void main(String[] args) {
		LectureDesDonnees d = new LectureDesDonnees("f1.txt", "f2.txt", "f3.txt");
		
		d.affichage();
		
	}
}
