package controleurEtVue;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;

import modele.LectureDonnees2;
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


public class InterfaceGrapiqueRushHour extends Application implements Runnable {

	private BorderPane root;
	private Scene scene;
	/*************************
	 * CREATION DES PANNEAUX ET DES ELEMENTS QUE JE VAIS UTILISER
	 ********************************/
	 Pane paneGaucheGrille;
	private VBox vboxDroiteButton;
	private VBox vboxDeplacement;
	private Label lblCompteurTemps;
	private Label lblDeplacements;
	private Text txtNombreDeplacements;
	private Button btnReinitialiser;
	private Button btnRetourAuMenu;
	private LocalTime tempsDepart;
	private int intNiveau;

	private ArrayList<Voiture> lstvVoitures ;


	public InterfaceGrapiqueRushHour(int intNiveau) {
		super();
		this.intNiveau = intNiveau;

	}

	public void start(Stage primaryStage) {
		try {
			root = new BorderPane();
			scene = new Scene(root, 780, 600);
			//GridPane gpane = new GridPane();
			/*************************
			 * CREATION DES PANNEAUX ET DES ELEMENTS QUE JE VAIS UTILISER
			 ********************************/
			
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

		/*	BackgroundImage imageGrilleJeu = new BackgroundImage(new Image("grille.gif", 530, 580, false, true),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);*/
			
			Image imgGrille = new Image("grille.gif");
			
			BackgroundSize grilleTaille = new BackgroundSize(100,80,true,true,true,false);
			BackgroundImage fondGrille = new BackgroundImage(imgGrille, BackgroundRepeat.SPACE,BackgroundRepeat.SPACE,BackgroundPosition.DEFAULT,grilleTaille);
			Background fondGrid = new Background(fondGrille);
			
			
			
			
			
			Font font1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 23);
			Font fontDeplacement = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 50);
			Font fontCompteurTemps = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 45);

			/*************************
			 * ATTRIBUTONS DES ELEMENTS AUXX PANNEAUX
			 ********************************/

			// le temps
			tempsDepart = LocalTime.now();
			new Thread(this).start();
			// paneGaucheGrille.setBackground(new Background(imageGrilleJeu));
			paneGaucheGrille.setBackground(fondGrid);

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
			 root.setCenter(paneGaucheGrille);
			//root.setCenter(gpane);
			root.setRight(vboxDroiteButton);

			/**********************
			 * AJOUT DES IMAGES(VOITURES) DANS LE PANE(BLOCK A GAUCHE) EN FONCTION DU NIVEAU
			 * RECUPERE DE LINTERFACE MENU
			 ******************************/
		

	
			LectureDonnees2	lec = new LectureDonnees2(intNiveau);
				System.out.println("le niveau: "+intNiveau);
			
			lstvVoitures = lec.getLstVoitures();
			
			
			for(Voiture voiture:lstvVoitures) {
				
				voiture.setLayoutX(voiture.getDblX());
				voiture.setLayoutY(voiture.getDblY());
			
				System.out.println(voiture.toString());
				
				paneGaucheGrille.getChildren().addAll(voiture);
				System.out.println("Dans le pane \nx: "+voiture.getDblX()+" y : "+voiture.getDblY()+"\n");
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
