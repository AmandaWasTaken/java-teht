package controller;

import model.DictModel;
import view.DictView;

public class DictController {

    private DictModel model;

	public DictController(DictModel model) {
        this.model = model;
    }

	public String search_word(String word) {
		String res = model.get_word(word);
		return res != null ? res : new String("Word not found");
	}
}
