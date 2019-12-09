package controleurEtVue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import javafx.stage.Stage;

public class InterfaceGraphiqueMenu extends Application {
	BorderPane root;
	Scene scene;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		try {
			root = new BorderPane();
			scene = new Scene(root, 780, 400);
			HBox hboxImageLogo = new HBox();
			HBox hboxNiveau = new HBox(40);
			
			//***********LES IMAGES*************//
			//LOGO
			ImageView imageRushHour = new ImageView();
			Image image1 = new Image("logo.gif");
			imageRushHour.setImage(image1);
			
			
			hboxImageLogo.getChildren().add(imageRushHour);
			hboxImageLogo.setAlignment(Pos.CENTER);
			
			hboxImageLogo.setPadding(new Insets(50));
			
			
			//FACILE
			ImageView imageFacile = new ImageView();
			Image image2 = new Image("mini_facile.png");
			imageFacile.setImage(image2);
			
			//MOYEN
			
			ImageView imageMoyen = new ImageView();
			Image image3 = new Image("mini_moyen.png");
			imageMoyen.setImage(image3);
			
			
			//DIFFICILE
			ImageView imageDifficile = new ImageView();
			Image image4 = new Image("mini_diff.png");
			imageDifficile.setImage(image4);
			
			
			hboxNiveau.setAlignment(Pos.CENTER);
			hboxNiveau.getChildren().addAll(imageFacile,imageMoyen,imageDifficile);
			
			
			
			
			root.setBackground(new Background(new BackgroundImage(new Image("fondecran.png",800,800,false,true),
			        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
			
			
			
			root.setTop(hboxImageLogo);
			root.setCenter(hboxNiveau);
			
			//************GESTIONNAIRE EVENEMENTS***********//
			
			

			
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
	
	private class GestionImages implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
		}
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
