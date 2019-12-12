package controleurEtVue;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.LectureDesDonnees;
import modele.Voiture;

public class InterfaceGraphiqueMenu extends Application {
	private BorderPane root;
	private Scene scene;

	private ImageView imageFacile;

	// MOYEN

	private ImageView imageMoyen;

	// DIFFICILE
	private ImageView imageDifficile;
	private String strNiveau;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		try {
			root = new BorderPane();
			scene = new Scene(root, 680, 400);
			HBox hboxImageLogo = new HBox();
			HBox hboxNiveau = new HBox(40);
			HBox hboxtext = new HBox(130);
			Text txtFacile = new Text("Facile");
			Text txtMoyen = new Text("Moyen");
			Text txtDifficile = new Text("Difficile");
			Font font1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 15);

			// ***********LES IMAGES*************//
			// LOGO
			ImageView imageRushHour = new ImageView();
			Image image1 = new Image("logo.gif");

			// FACILE
			imageFacile = new ImageView();
			Image image2 = new Image("mini_facile.png");
			imageFacile.setImage(image2);

			// MOYEN

			imageMoyen = new ImageView();
			Image image3 = new Image("mini_moyen.png");
			imageMoyen.setImage(image3);

			// DIFFICILE
			imageDifficile = new ImageView();
			Image image4 = new Image("mini_diff.png");
			imageDifficile.setImage(image4);

			// ATTRIBUTION DES SPECS AUX NODES
			txtFacile.setFont(font1);
			txtMoyen.setFont(font1);
			txtDifficile.setFont(font1);
			txtFacile.setFill(Color.YELLOW);
			txtMoyen.setFill(Color.YELLOW);
			txtDifficile.setFill(Color.YELLOW);

			imageRushHour.setImage(image1);

			hboxImageLogo.getChildren().add(imageRushHour);
			hboxImageLogo.setAlignment(Pos.CENTER);

			hboxImageLogo.setPadding(new Insets(50));

			hboxNiveau.setPadding(new Insets(20));

			hboxtext.getChildren().addAll(txtFacile, txtMoyen, txtDifficile);
			hboxtext.setAlignment(Pos.CENTER);
			hboxNiveau.setAlignment(Pos.CENTER);
			hboxNiveau.getChildren().addAll(imageFacile, imageMoyen, imageDifficile);

			root.setBackground(new Background(
					new BackgroundImage(new Image("fondecran.png", 800, 800, false, true), BackgroundRepeat.NO_REPEAT,
							BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

			root.setTop(hboxImageLogo);
			root.setCenter(hboxtext);
			root.setBottom(hboxNiveau);

			// ************GESTIONNAIRE EVENEMENTS***********//
			Glow glow = new Glow();
			glow.setLevel(0.5);

			// FACILE
			imageFacile.setOnMouseEntered(new EventHandler<Event>() {

				@Override
				public void handle(Event e) {
					// TODO Auto-generated method stub

					if (e.getSource() == imageFacile) {
						imageFacile.setEffect(glow);
						//Tooltip.install(imageFacile, new Tooltip("NIVEAU FACILE"));
						
					
					}
				}
			});
			imageFacile.setOnMouseExited(new EventHandler<Event>() {

				@Override
				public void handle(Event e) {
					// TODO Auto-generated method stub
					if (e.getSource() == imageFacile) {
						imageFacile.setEffect(null);
					}
				}
			});

			imageFacile.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event e) {
					// TODO Auto-generated method stub
					if (e.getSource() == imageFacile) {
						
						
						 strNiveau = "facile";

						primaryStage.close();

						Stage stageRushHour = new Stage();
						stageRushHour.initModality(Modality.APPLICATION_MODAL);
						InterfaceGrapiqueRushHour rushHour = new InterfaceGrapiqueRushHour(strNiveau);
						rushHour.start(stageRushHour);
						// voir comment lui envoyes des variables avec le consttructeur pour faoire la
						// differences avec les niveaux
					}

				}
			});
			// MOYEN
			imageMoyen.setOnMouseEntered(new EventHandler<Event>() {

				@Override
				public void handle(Event e) {
					// TODO Auto-generated method stub

					if (e.getSource() == imageMoyen) {
						imageMoyen.setEffect(glow);
						//Tooltip.install(imageMoyen, new Tooltip("NIVEAU MOYEN"));

					}
				}
			});
			imageMoyen.setOnMouseExited(new EventHandler<Event>() {

				@Override
				public void handle(Event e) {
					// TODO Auto-generated method stub
					if (e.getSource() == imageMoyen) {
						imageMoyen.setEffect(null);
					}
				}
			});

			imageMoyen.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event e) {
					// TODO Auto-generated method stub
					if (e.getSource() == imageMoyen) {
						
						strNiveau = "moyen";

						primaryStage.close();

						Stage stageRushHour = new Stage();
						stageRushHour.initModality(Modality.APPLICATION_MODAL);
						InterfaceGrapiqueRushHour rushHour = new InterfaceGrapiqueRushHour(strNiveau);
						rushHour.start(stageRushHour);
					}

				}
			});
			// DIFFICILE
			imageDifficile.setOnMouseEntered(new EventHandler<Event>() {

				@Override
				public void handle(Event e) {
					// TODO Auto-generated method stub

					if (e.getSource() == imageDifficile) {
						imageDifficile.setEffect(glow);
						//Tooltip.install(imageDifficile, new Tooltip("NIVEAU DIFFICILE"));
					}
				}
			});
			imageDifficile.setOnMouseExited(new EventHandler<Event>() {

				@Override
				public void handle(Event e) {
					// TODO Auto-generated method stub
					if (e.getSource() == imageDifficile) {
						imageDifficile.setEffect(null);
					}
				}
			});

			imageDifficile.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event e) {
					// TODO Auto-generated method stub
					if (e.getSource() == imageDifficile) {
						
						strNiveau = "difficile";

						primaryStage.close();

						Stage stageRushHour = new Stage();
						stageRushHour.initModality(Modality.APPLICATION_MODAL);
						InterfaceGrapiqueRushHour rushHour = new InterfaceGrapiqueRushHour(strNiveau);
						rushHour.start(stageRushHour);
					}

				}
			});

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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
