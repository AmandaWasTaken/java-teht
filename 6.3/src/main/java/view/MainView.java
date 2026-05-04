package view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MainView {

    private Pane canvas;
    private Scene scene;
    private PetView petView;

    public MainView() {
        canvas = new Pane();
        canvas.setPrefSize(600, 400);

        petView = new PetView();

        canvas.getChildren().add(petView.getNode());

        scene = new Scene(canvas);
    }

    public Scene get_scene() {
        return scene;
    }

    public Pane get_canvas() {
        return canvas;
    }

    public PetView get_pet_view() {
        return petView;
    }
}
