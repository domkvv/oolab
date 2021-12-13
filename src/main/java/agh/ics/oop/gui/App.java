package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.FileNotFoundException;
import java.util.List;

public class App extends Application implements ISimulationEngineObserver {
    private AbstractWorldMap map;
    GridPane grid = new GridPane();

    public void init() {
        try {
            List<String> args = getParameters().getRaw();
            String[] args_ = new String[args.size()];
            int j = 0;
            for (String i : args) {
                args_[j] = i;
                j += 1;
            }
            MoveDirection[] directions = new OptionsParser().parse(args_);
            this.map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            SimulationEngine engine = new SimulationEngine(directions, this.map, positions, 300);
            engine.addObserver(this);
            Thread engineThread = new Thread(engine);
            engineThread.start();
            System.out.println(this.map.toString());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void start(Stage primaryStage) throws FileNotFoundException {



        makeScene();
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void makeScene() throws FileNotFoundException {
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();

        TextField textField = new TextField();
        textField.setText("put animal moves sequence here");
        Button button = new Button("start");
        HBox hbox = new HBox(textField, button);
        hbox.setSpacing(20);
        grid.add(hbox, 20, 20);
        hbox.setAlignment(Pos.CENTER);

        grid.setGridLinesVisible(true);
        Vector2d lowerLeft = this.map.UpdateLimits()[0];
        Vector2d upperRight = this.map.UpdateLimits()[1];
        grid.setPadding(new Insets(10, 10, 10, 10));

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
