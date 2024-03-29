package modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
/**
 * Classe qui permet de lire les trois fichier suivant : f1.txt, f2.txt, f3.txt, afin de remplir 
 * Un arrayList qui va contenir tous les voitures.
 *
 * @author Gabriel Marrero
 * @version 1.0 2019-12-15
 */
public class LectureDonnees2 {
	private ArrayList<Voiture> lstVoitures = new ArrayList<Voiture>();
	private String strFichierLu = "";
	private int[][] tabVoiture = new int[6][6];
	
	public LectureDonnees2(int numNiveau) {
		
		
		switch(numNiveau) {
		case 1:
			strFichierLu = "f1.txt";
			break;
		case 2:
			strFichierLu = "f2.txt";
			break;
		case 3:
			strFichierLu = "f3.txt";
			break;
		}
		BufferedReader brFichier = null;
		String strLigne;
		StringTokenizer st;
		 String couleur;
		 int longueur;
		 int colonne;
		 int ligne;
		 EnumDirectionVoitures direction = null;
		 String fichierVoiture = "";
		 String auto = "auto";
		 String camion = "camion";
		 
		
		 
		 
		 try {
			 brFichier = new BufferedReader(new FileReader(strFichierLu));

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {

				while ((strLigne = brFichier.readLine()) != null) {

					try {
			
						st = new StringTokenizer(strLigne,",");
						couleur = st.nextToken().trim();
						longueur = Integer.parseInt(st.nextToken().trim());
						colonne =  Integer.parseInt(st.nextToken().trim());
						ligne =  Integer.parseInt(st.nextToken().trim());
						
						switch(st.nextToken()) {
						case "V":
							direction = EnumDirectionVoitures.VERTICAL;
							break;
						case "H":
							direction = EnumDirectionVoitures.HORIZONTALE;
							break;
						
						}
						
						
						//contruction du fichier voiture
						if(longueur==2) { //voiture
							fichierVoiture = auto+"_"+direction.getStrOrientation()+"_"+couleur+".gif";
						}
						else {//camion
							fichierVoiture = camion+"_"+direction.getStrOrientation()+"_"+couleur+".gif";
						}
						
						//les coordonees
						double dblx = 45+colonne*72;
						double dbly = 70+ligne*72;
						
						System.out.println("Dans le constructeur\nx: "+dblx+" y : "+dbly+"\n");
						
						Voiture voiture = new Voiture(couleur, longueur, colonne, ligne, direction, fichierVoiture, dblx, dbly);
						
						lstVoitures.add(voiture);
						
						
						
						//attribue des 1 lorsque'il y a une voiture, et attribued es 0 lorsqu'il y en a pas
						
				
					
						
						//System.out.println(directionFacile.getStrOrientation());
						
					} catch (NoSuchElementException e) {

					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			
	}
	/**Les getters et les setters
	 *
	 * C'est m�thodes permettent aux variables priv�e d'�tre utilis� ailleurs
	 *
	 * @param <lstVoitures> <fonction>
	 * @param <strFichierLu> <fonction>
	 
	 * @return <Elles retournent les variables en tant que tel>
	 * @throws <Aucune exception est lanc�e manuellement>
	 */ 


	public ArrayList<Voiture> getLstVoitures() {
		return lstVoitures;
	}

	public void setLstVoitures(ArrayList<Voiture> lstVoitures) {
		this.lstVoitures = lstVoitures;
	}

	public String getStrFichierLu() {
		return strFichierLu;
	}

	public void setStrFichierLu(String strFichierLu) {
		this.strFichierLu = strFichierLu;
	}
}
