package view;

import controller.DictController;
import model.DictModel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DictView extends Application {

	private static DictController controller;

	public static void set_controller(DictController ctrl){
		controller = ctrl;
	}

	public DictView() {}

	@Override
	public void start(Stage stage){
		
		TextField search_field = new TextField();
		search_field.setPromptText("Enter a word");

		Button search_button = new Button("Search");

		TextField word_field = new TextField();
		word_field.setEditable(false);
		word_field.setPromptText("Word");

		TextArea definition_area = new TextArea();
		definition_area.setEditable(false);
		definition_area.setWrapText(true);
		definition_area.setPrefHeight(200);

		search_button.setOnAction(e->handle_search(
					search_field.getText(),
					word_field,
					definition_area
					));

		search_field.setOnAction(e->search_button.fire());

		HBox search_box = new HBox(10, search_field, search_button);

		VBox root = new VBox(10, search_box, word_field, definition_area);
		root.setPadding(new Insets(15));

		Scene scene = new Scene(root, 400, 300);
		stage.setTitle("Dictionary");
		stage.setScene(scene);
		stage.show();
	}

	private void handle_search(String input, TextField word_field, 
			TextArea definition_area) {
		
		if(input == null || input.trim().isEmpty()){
			definition_area.setText("Please enter a word");
			word_field.clear();
			return;
		}

		String word = input.trim();
		String definition = controller.search_word(word.toLowerCase());

		
		if(definition != null) {
			word_field.setText(new String("Definition of " + word + ":"));
			definition_area.setText(definition);
		} else {
			word_field.clear();
			definition_area.setText("Word not found!");
		}
	}

	public static void main (String[] args) {
		launch(args);
	}
}













