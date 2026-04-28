package controller; 

import model.Model;
import view.View;

public class Controller {

	private final Model model;
	private final View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		controller_init();
	}

	private void controller_init() {

		String[] currencies = model.get_currencies();
		view.get_from_currency().getItems().addAll(currencies);
		view.get_to_currency().getItems().addAll(currencies);

		view.get_from_currency().getSelectionModel().selectFirst();
		view.get_to_currency().getSelectionModel().selectFirst();

		init_handlers();
	}

	private void init_handlers() {

		// double[] rates = model.get_rates();
		view.get_convert_button().setOnAction(e-> {
			try {
				String amount 	= view.get_amount().getText();
				String from 	= view.get_from_currency().getValue();
				String to 		= view.get_to_currency().getValue();
				double res 		= model.convert(amount, from, to);

				if(Double.parseDouble(amount) < 0) {
					view.get_result_label().setText("Please enter a positive amount");
				} else {
					String _fmt = "%.2f %s = %.2f %s";
					String result = String.format(_fmt, Double.parseDouble(amount), 
							from, res, to);
					view.get_result_label().setText(result);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				view.get_result_label().setText("Invalid input");
			}
		});
	}
}






