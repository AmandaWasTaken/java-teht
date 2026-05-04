package view;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PetView {

    private ImageView petNode;

    public PetView() {
		Image image = new Image(
				getClass().getResource("/pet.png").toExternalForm()
				);
        petNode = new ImageView(image);
		if(petNode == null) {
			System.out.println("petNode is null!");
			System.exit(1);
		}

        petNode.setFitWidth(50);
        petNode.setFitHeight(50);
		System.out.println("New petview");
    }

    public Node getNode() {
        return petNode;
    }

    public void updatePosition(double x, double y) {
        petNode.setLayoutX(x);
        petNode.setLayoutY(y);
    }
}
