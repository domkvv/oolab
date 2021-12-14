package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.FileNotFoundException;

public class App extends Application implements ISimulationEngineObserver {
    private AbstractWorldMap map;
    GridPane grid = new GridPane();
    SimulationEngine engine;

    public void init() {
        try {
            this.map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            this.engine = new SimulationEngine(this.map, positions, 300);
            engine.addObserver(this);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void start(Stage primaryStage) throws FileNotFoundException {
        makeScene();
        TextField textField = new TextField();
        textField.setText("animal moves sequence");
        textField.setPrefWidth(200);
        textField.setMaxWidth(200);
        Button start = new Button("start");
        start.setOnAction(e -> {
            MoveDirection[] directions = new OptionsParser().parse(
                    textField.getText().split(" ")
            );
            engine.setDirections(directions);
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });

        VBox vbox = new VBox(grid, textField, start);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        Scene scene = new Scene(vbox, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void makeScene() throws FileNotFoundException {
        grid.setAlignment(Pos.CENTER);
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();

        grid.setGridLinesVisible(true);
        Vector2d lowerLeft = this.map.UpdateLimits()[0];
        Vector2d upperRight = this.map.UpdateLimits()[1];

        Label label_axis = new Label("y\\x");
        grid.add(label_axis, 0, 0);
        grid.setHalignment(label_axis, HPos.CENTER);

        for (int i = 0; i <= upperRight.x - lowerLeft.x + 1; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(45));
        }
        for (int i = 0; i <= upperRight.y - lowerLeft.y + 1; i++) {
            grid.getRowConstraints().add(new RowConstraints(45));
        }

        for (int i = 1; i <= upperRight.x - lowerLeft.x + 1; i++) {
            Label label = new Label(String.valueOf(i + lowerLeft.x - 1));
            grid.add(label, i, 0);
            grid.setHalignment(label, HPos.CENTER);
        }

        for (int i = 1; i <= upperRight.y - lowerLeft.y + 1; i++) {
            Label label = new Label(String.valueOf(upperRight.y + 1 - i));
            grid.add(label, 0, i);
            grid.setHalignment(label, HPos.CENTER);
        }

        for (int i = lowerLeft.x; i <= upperRight.x + 1; i++) {
            for (int j = lowerLeft.y; j <= upperRight.y + 1; j++) {
                Object object = this.map.objectAt(new Vector2d(i, upperRight.y + lowerLeft.y - j));
                if (object != null) {
                    VBox vbox = new GuiElementBox((IMapElement) object).vbox;
                    vbox.setAlignment(Pos.CENTER);
                    grid.add(vbox, i + 1 - lowerLeft.x, j + 1 - lowerLeft.y);
                    grid.setHalignment(vbox, HPos.CENTER);
                }
            }
        }

    }

    @Override
    public void mapChanged() {
        Platform.runLater(() -> {
            grid.setGridLinesVisible(false);
            grid.getChildren().clear();
            try {
                makeScene();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
    }

}
