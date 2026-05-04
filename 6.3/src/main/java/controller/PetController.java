package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.input.MouseEvent;
import model.PetModel;
import view.MainView;
import view.PetView;

public class PetController {

	private PetModel model;
	private MainView view;

	private AnimationTimer timer;

	public PetController(PetModel model, MainView view){
		this.model = model;
		this.view = view;
	}

	public void init() {
		set_mouse_handlers();
		set_game_loop();
	}
	
	private void set_mouse_handlers() {
		view.get_canvas().setOnMouseMoved((MouseEvent e) -> {
			model.set_moving(true);
			model.set_target_x(e.getX());
			model.set_target_y(e.getY());
		});

		view.get_canvas().setOnMouseExited(e -> {
			model.set_moving(false);
		});

		view.get_canvas().setOnMouseEntered(e -> {
			model.set_moving(true);
		});
	}
	
	private void set_game_loop() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if(model.is_moving()) {
					model.update_position();

					if(model.has_reached_target()){ model.set_moving(false); }

					view.get_pet_view().updatePosition(
							model.get_x(),
							model.get_y()
					);
				}
			}
		};
		timer.start();
	}
}

