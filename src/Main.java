
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        int buffer[][] = new int[256][256];
        // 32 x 32 grid
        // 16 x 16 sprite
        Player player = new Player(0, 0, 90);
        // getX(), getY(), getD(), move(), and turn()
        launch(args);
    }

    @Override
    public void start(Stage s) {
//         Hbox sets horizontal
//         Vbox sets vertical
//         BorderPane sets top, left, right, bottom, and center
//         AnchorPane sets distance of node from window
//         TextFlow sets text nodes in a flow
//         TilePane sets nodes in uniformly sized boxes
//         GridPane sets rows and columns (used for forms)

        Group root = new Group();
        AnchorPane anchor = new AnchorPane();
        VBox vbox = new VBox();
		Buttons buttons = new Buttons();
		root.getChildren().add(anchor);
		anchor.getChildren().add(vbox);
        anchor.setLeftAnchor(vbox, 5.0);
        vbox.setSpacing(10.0);
        vbox.setPadding(new Insets(5, 5, 5, 5));

        Button menuButtons[] = new Button[5];

        for (int i = 0; i < 5; i++) {
            menuButtons[i] = new Button();
        }

        for (int i = 0; i < 5; i++) {
            menuButtons[i].setMinWidth(100.0);
        	menuButtons[i].setMaxWidth(100.0);
        }

        for (int i = 0; i < 5; i ++) {
            vbox.getChildren().add(menuButtons[i]);
        }

        menuButtons[0].setText("New game");
        menuButtons[1].setText("Load game");
        menuButtons[2].setText("Settings");
        menuButtons[3].setText("About");
        menuButtons[4].setText("Quit");

        menuButtons[0].setOnAction(new EventHandler<ActionEvent>() {
			@Override
        	public void handle(ActionEvent e) {
            	buttons.newGame();
        	}
        });
		menuButtons[1].setOnAction(new EventHandler<ActionEvent>() {
			@Override
        	public void handle(ActionEvent e) {
            	buttons.loadGame();
        	}
        });
		menuButtons[2].setOnAction(new EventHandler<ActionEvent>() {
			@Override
        	public void handle(ActionEvent e) {
            	buttons.changeSettings();
        	}
        });
		menuButtons[3].setOnAction(new EventHandler<ActionEvent>() {
			@Override
        	public void handle(ActionEvent e) {
            	buttons.showAbout();
        	}
        });
		menuButtons[4].setOnAction(new EventHandler<ActionEvent>() {
			@Override
        	public void handle(ActionEvent e) {
            	buttons.quit();
        	}
        });
        s.setTitle("Simulation Game");
        s.setScene(new Scene(root, 640, 480, Color.BLACK));
        s.setResizable(false);
        s.show();

    }

}
