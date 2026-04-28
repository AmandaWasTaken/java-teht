// javafx
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// mvc
import model.Model;
import view.View;
import controller.Controller;


public class Main extends Application {

	@Override
	public void start(Stage stage) {
		Model model = new Model();
		View view = new View();
		new Controller(model, view);

		Scene scene = new Scene(view.getRoot(), 800, 600);
		scene.getStylesheets().add(
				getClass().getResource("/style.css").toExternalForm());

		stage.setTitle("Currency Converter");
		stage.setScene(scene);
		stage.show();
	}

	public static void main (String[] args) {
		launch(args);
	}
}
