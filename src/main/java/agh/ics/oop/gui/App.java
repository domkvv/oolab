package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;


public class App extends Application {
    Label label = new Label("Zwierzak");
    Scene scene = new Scene(label, 400, 400);
    GridPane grid = new GridPane();

    public void init()
    {
        try {
            String [] args = {"f", "b", "r", "l"};
            //System.out.println(args);
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            //System.out.println(map.toString());
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            //System.out.println(map.toString());
            engine.run();
            System.out.println(map.toString());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void start(Stage primaryStage){
        grid.setGridLinesVisible(true);
        grid.add(label, 0, 0, 300, 300);
        primaryStage.setScene(new Scene(grid, 400, 400));
        primaryStage.show();
    }

}
