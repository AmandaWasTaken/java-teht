package app;

import model.DictModel;
import view.DictView;
import controller.DictController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;

public class Main {

	public static void main (String[] args) {

		DictModel model = new DictModel();
		DictController controller = new DictController(model);
		DictView.set_controller(controller);
		
		// This doesn't work either
		// see comments in `model/DictModel.java` 
		model.add_word("Hello", "World");

		DictView.launch(DictView.class, args);
	}	
}
