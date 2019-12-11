package controleurEtVue;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.LectureDesDonnees;
import modele.Voiture;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modele.LectureDesDonnees;

public class InterfaceGrapiqueRushHour extends Application implements Runnable {

	BorderPane root;
	Scene scene;
	/*************************
	 * CREATION DES PANNEAUX ET DES ELEMENTS QUE JE VAIS UTILISER
	 ********************************/
	Pane paneGaucheGrille;
	VBox vboxDroiteButton;
	VBox vboxDeplacement;
	Label lblCompteurTemps;
	Label lblDeplacements;
	Text txtNombreDeplacements;
	Button btnReinitialiser;
	Button btnRetourAuMenu;
	LocalTime tempsDepart;
	String strNiveau;

	private ArrayList<Voiture> arrVoituresFaciles = new ArrayList<Voiture>();
	private ArrayList<Voiture> arrVoituresMoyennes = new ArrayList<Voiture>();
	private ArrayList<Voiture> arrVoituresDifficiles = new ArrayList<Voiture>();

	public InterfaceGrapiqueRushHour(String strNiveau) {
		super();
		this.strNiveau = strNiveau;

	}

	public void start(Stage primaryStage) {
		try {
			root = new BorderPane();
			scene = new Scene(root, 780, 600);
			GridPane gpane = new GridPane();
			/*************************
			 * CREATION DES PANNEAUX ET DES ELEMENTS QUE JE VAIS UTILISER
			 ********************************/
			LectureDesDonnees l = new LectureDesDonnees("f1.txt", "f2.txt", "f3.txt");
			paneGaucheGrille = new Pane();
			vboxDroiteButton = new VBox(50);
			vboxDeplacement = new VBox(5);
			lblCompteurTemps = new Label();
			lblDeplacements = new Label("0");
			txtNombreDeplacements = new Text("Nombre de déplacements");
			btnReinitialiser = new Button("Réinitialiser");
			btnRetourAuMenu = new Button("Retour au menu");

			Border border = new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(5),
					new BorderWidths(5), new Insets(0)));

			Border borderDeplacements = new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID,
					new CornerRadii(0), new BorderWidths(5), new Insets(0)));

			Border borderCompteurtemps = new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID,
					new CornerRadii(10), new BorderWidths(5), new Insets(0)));

			BackgroundImage imageGrilleJeu = new BackgroundImage(new Image("grille.gif", 530, 580, false, true),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			Font font1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 23);
			Font fontDeplacement = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 50);
			Font fontCompteurTemps = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 45);

			/*************************
			 * ATTRIBUTONS DES ELEMENTS AUXX PANNEAUX
			 ********************************/

			// le temps
			// paneGaucheGrille.setBackground(new Background(imageGrilleJeu));
			gpane.setBackground(new Background(imageGrilleJeu));

			lblCompteurTemps.setPrefWidth(150);
			lblCompteurTemps.setPrefHeight(80);
			lblCompteurTemps.setFont(fontCompteurTemps);
			lblCompteurTemps
					.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(0), new Insets(5))));
			lblCompteurTemps.setBorder(borderCompteurtemps);
			lblCompteurTemps.setAlignment(Pos.CENTER);

			// les deplacements
			lblDeplacements.setFont(fontDeplacement);
			lblDeplacements.setPrefWidth(95);
			lblDeplacements.setPrefHeight(80);
			lblDeplacements.setBorder(borderDeplacements);
			lblDeplacements.setAlignment(Pos.CENTER);

			vboxDeplacement.getChildren().addAll(lblDeplacements, txtNombreDeplacements);
			vboxDeplacement.setAlignment(Pos.CENTER);

			btnReinitialiser.setPrefWidth(175);
			btnReinitialiser.setPrefHeight(50);

			btnRetourAuMenu.setPrefWidth(225);
			btnRetourAuMenu.setPrefHeight(50);

			btnReinitialiser.setFont(font1);
			btnRetourAuMenu.setFont(font1);

			btnReinitialiser.setBorder(border);
			btnRetourAuMenu.setBorder(border);
			btnRetourAuMenu.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					// TODO Auto-generated method stub
					primaryStage.close();

					Stage stageMenu = new Stage();
					stageMenu.initModality(Modality.APPLICATION_MODAL);
					InterfaceGraphiqueMenu menu = new InterfaceGraphiqueMenu();
					menu.start(stageMenu);

				}
			});
			btnReinitialiser.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					// TODO Auto-generated method stub
					tempsDepart = LocalTime.now();
					new Thread().start();
					lblDeplacements.setText("0");
				}
			});

			vboxDroiteButton.getChildren().addAll(lblCompteurTemps, vboxDeplacement, btnReinitialiser, btnRetourAuMenu);
			vboxDroiteButton.setAlignment(Pos.CENTER);
			vboxDroiteButton.setPadding(new Insets(15));
			// root.setCenter(paneGaucheGrille);
			root.setCenter(gpane);
			root.setRight(vboxDroiteButton);

			/**********************
			 * AJOUT DES IMAGES(VOITURES) DANS LE PANE(BLOCK A GAUCHE) EN FONCTION DU NIVEAU
			 * RECUPERE DE LINTERFACE MENU
			 ******************************/

			switch (strNiveau) {
			case "facile":

				System.out.println("alloFacile");

				// pour demarer le temps

				tempsDepart = LocalTime.now();
				new Thread(this).start();
				
				//POUR LE GRIDPANE(GRILLE DE JEU)

				gpane.setGridLinesVisible(true);
				gpane.setPadding(new Insets(70, 0, 0, 45));
				for (int i = 0; i < 6; i++) {
					ColumnConstraints col1 = new ColumnConstraints(72);

					// col1.setPrefWidth(45);
					gpane.getColumnConstraints().add(col1);

				}

				for (int i = 0; i < 6; i++) {

					RowConstraints row1 = new RowConstraints(72);

					gpane.getRowConstraints().add(row1);

				}
				

				// Voitures horizontales
				ImageView voitureRougeH = new ImageView();
				Image image1 = new Image("auto_H_rouge.gif");
				voitureRougeH.setImage(image1);

				ImageView voitureVerteH = new ImageView();
				Image image2 = new Image("auto_H_vert.gif");
				voitureVerteH.setImage(image2);

				ImageView voitureBleuPaleH = new ImageView();
				Image image3 = new Image("auto_H_bleu.gif");
				voitureBleuPaleH.setImage(image3);
				
				ImageView camionTurquoiseH = new ImageView();
				Image image8 = new Image("camion_H_vert.gif");
				voitureBleuPaleH.setImage(image8);

				// Voitures verticales
				ImageView camionMauveV = new ImageView();
				Image image4 = new Image("camion_V_mauve.gif");
				camionMauveV.setImage(image4);

				ImageView voitureOrangeV = new ImageView();
				Image image5 = new Image("auto_V_orange.gif");
				voitureOrangeV.setImage(image5);

				ImageView camionBleuV = new ImageView();
				Image image6 = new Image("camion_V_bleu.gif");
				camionBleuV.setImage(image6);

				ImageView camionJauneV = new ImageView();
				Image image7 = new Image("camion_V_jaune.gif");
				camionJauneV.setImage(image7);
				
				
				
				//ajout des voitures dans la grille de jeu
				//horinzontales
				gpane.add(voitureRougeH,1, 2);
				gpane.add(voitureVerteH, 0, 0);
				gpane.add(voitureBleuPaleH, 4, 4);
				gpane.add(camionTurquoiseH, 2, 5);
				//verticales
				gpane.add(camionMauveV, 0, 2);
				gpane.add(voitureOrangeV, 0,(int)4.8);
				gpane.add(camionBleuV, 3, 1);
				gpane.add(camionJauneV, 5, 0);
				
				

				// insertion des voitures dans le pane

				// arrVoituresFaciles = l.getArrVoituresFaciles();

				/*
				 * for(int i =0; i < arrVoituresFaciles.size();i++) {
				 * 
				 * 
				 * }
				 */

				// Button btnTest = new Button("Test");

				/*
				 * for(Voiture v:arrVoituresFaciles) {
				 * 
				 * paneGaucheGrille.setLayoutX(1*v.getLongueur()+70);
				 * paneGaucheGrille.setLayoutY(1*v.getLongueur()+45);
				 * 
				 * }
				 */
				// paneGaucheGrille.setLayoutX(1*l.getVoitureFacile().getLongueur()+70);
				// paneGaucheGrille.setLayoutY(1*l.getVoitureFacile().getLongueur()+45);
				// paneGaucheGrille.getChildren().add(btnTest);

				break;
			case "moyen":
				// insertion des voitures dans le pane
				System.out.println("alloMoyen");

				// pour demarer le temps

				tempsDepart = LocalTime.now();
				new Thread(this).start();

				break;
			case "difficile":
				// insertion des voitures dans le pane
				System.out.println("alloDifficile");

				// pour demarer le temps

				tempsDepart = LocalTime.now();
				new Thread(this).start();

				break;

			default:
				break;
			}

			primaryStage.setScene(scene);
			// primaryStage.sizeToScene();
			primaryStage.setTitle("Rush Hour par Gabriel Marrero");
			primaryStage.getIcons().add(new Image("icone.png"));
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void voitureDansGrilleFacile(LectureDesDonnees l) {
		arrVoituresFaciles = l.getArrVoituresFaciles();

		for (int i = 0; i < arrVoituresFaciles.size(); i++) {

		}

	}

	/**************** METHOD QUI PERMET DAFFICHER LE TEMPS ****************/
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			try {

				LocalTime tempsActuel = LocalTime.now();
				long tempsEnSecondes = ChronoUnit.SECONDS.between(tempsDepart, tempsActuel);

				LocalTime tempsInterfsce = LocalTime.ofSecondOfDay(tempsEnSecondes);
				Platform.runLater(() -> {
					lblCompteurTemps.setText(
							String.format("%02d:%02d", tempsInterfsce.getMinute(), tempsInterfsce.getSecond()));
				});

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
