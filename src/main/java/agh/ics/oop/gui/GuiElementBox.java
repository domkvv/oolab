package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;

public class GuiElementBox {
    public VBox vbox;

    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        Image image = element.setOrientation();
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Label label = new Label(element.getPosition().toString());
        this.vbox = new VBox(label, imageView);
    }

}
