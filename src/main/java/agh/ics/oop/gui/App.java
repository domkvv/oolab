package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.application.Application;

import java.util.List;


public class App extends Application {
    private AbstractWorldMap map;

    public void init() {
        try {
            List<String> args = getParameters().getRaw();
            String[] args_ = new String[args.size()];
            int j = 0;
            for (String i : args) {
                args_[j] = i;
                j += 1;
            }
            //System.out.println(args);
            MoveDirection[] directions = new OptionsParser().parse(args_);
            this.map = new GrassField(10);
            //System.out.println(map.toString());
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, this.map, positions);
            //System.out.println(map.toString());
            engine.run();
            System.out.println(this.map.toString());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void start(Stage primaryStage) {
        makeScene(primaryStage);
        primaryStage.show();
    }

    private void makeScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        Vector2d lowerLeft = this.map.UpdateLimits()[0];
        Vector2d upperRight = this.map.UpdateLimits()[1];
        Scene scene = new Scene(grid, 400, 400);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Label label_axis = new Label("y\\x");
        grid.add(label_axis, 0, 0);
        grid.setHalignment(label_axis, HPos.CENTER);

        for (int i = 0; i <= upperRight.x - lowerLeft.x + 1; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(25));
        }
        for (int i = 0; i <= upperRight.y - lowerLeft.y + 1; i++) {
            grid.getRowConstraints().add(new RowConstraints(25));
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
                    Label label = new Label(object.toString());
                    grid.add(label, i + 1 - lowerLeft.x, j + 1 - lowerLeft.y);
                    grid.setHalignment(label, HPos.CENTER);
                }
            }

        }

        primaryStage.setScene(scene);

    }


}
