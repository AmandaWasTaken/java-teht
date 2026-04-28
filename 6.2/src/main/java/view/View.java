package view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.util.function.UnaryOperator;


public class View {

	private final VBox root;
	private final TextField amount;
	private final ComboBox<String> from_currency;
	private final ComboBox<String> to_currency;
	private final Button b_convert;
	private final Label l_from, l_to, l_result, l_amount;

	public View() {

		amount = new TextField();

		UnaryOperator<TextFormatter.Change> filter = change-> {
			String new_text = change.getControlNewText();

			if(new_text.matches("\\d*(\\.\\d*)?")) {
				return change;
			}
			return null;
		};

		TextFormatter<String> fmt = new TextFormatter<>(filter);
		amount.setTextFormatter(fmt);

		from_currency = new ComboBox<>();
		to_currency   = new ComboBox<>();

		b_convert 	  = new Button("Convert");
		l_result  	  = new Label("");
		l_amount	  = new Label("Enter amount");
		l_from 		  = new Label("Convert from");
		l_to 		  = new Label("To");

		root = new VBox(10,
				l_amount,
				amount,
				l_from,
				from_currency,
				l_to,
				to_currency,
				b_convert,
				l_result
				);

		root.setPadding(new Insets(20));
	}

	// getters //
	public Parent getRoot() {
		return root;
	}
	
	public TextField get_amount() {
		return amount;
	}

	public ComboBox<String> get_from_currency() {
		return from_currency;
	}

	public ComboBox<String> get_to_currency() {
		return to_currency;
	}

	public Button get_convert_button() {
		return b_convert;
	}

	public Label get_result_label() {
		return l_result;
	}
}
