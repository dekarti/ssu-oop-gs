package com.dekarti.gs;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Main extends Application {

    static public double WIDTH = 1200;
    static public double HEIGHT = 900;
    public static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Gas Station");
        javafx.geometry.Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        Group root = new Group();
        Station station = new Station(500, 500, 100, 100);

        Timeline timeLine = new Timeline();
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.getKeyFrames().add(
                new KeyFrame(Duration.millis(20),
                        new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent t) {
                                station.update();
                            }
                        }
                )
        );
        timeLine.play();


        root.getChildren().add(station);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        station.setOnMouseClicked(event -> {
            station.setParent(scene);
            primaryStage.setScene(station.getObjectScene());
        });

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}