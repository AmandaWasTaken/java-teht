package model;

// common
import java.util.Map;

// javafx
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

	private final Map<String, Double> rates = Map.of(
			"EUR", 1.0,
			"USD", 1.1,
			"GBP", 0.85
	);

	public double convert(String amount, String base, String quote){
		double from = rates.get(base);
		double to = rates.get(quote);
		double final_amount = Double.parseDouble(amount) / from;
		return final_amount * to;
	}

	public String[] get_currencies() {
		return rates.keySet().toArray(new String[0]);
	}	
}
