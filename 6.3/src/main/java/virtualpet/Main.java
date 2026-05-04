package virtualpet;
import javafx.application.Application;
import javafx.stage.Stage;
import model.PetModel;
import view.*;
import controller.PetController;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		PetModel model = new PetModel();
		MainView view = new MainView();
		PetController controller = new PetController(model, view);

		stage.setTitle("Otus");
		stage.setScene(view.get_scene());
		stage.show();

		controller.init();
	}

	public static void Main(String[] args) {
		launch(args);
	}
}

