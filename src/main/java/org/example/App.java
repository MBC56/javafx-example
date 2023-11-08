package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */


public class App extends Application {

    private final static int SCENE_HEIGHT = 500;
    private final static int SCENE_WIDTH = 500;

    @Override
    public void start(Stage stage) {

        Pane pane = new Pane();
        Scene scene = new Scene(pane, SCENE_HEIGHT, SCENE_WIDTH);
        Rectangle rectangle = new Rectangle(20, 20, Color.RED); // Width, Height, and Color
        pane.getChildren().add(rectangle);



        Text bounceText = new Text("Bounce Bounce");
        bounceText.setFont(Font.font(20));
        bounceText.setFill(Color.BLACK);
        bounceText.setLayoutX(130);
        bounceText.setLayoutY(5);

        pane.getChildren().add(bounceText);

        stage.setScene(scene);
        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(25), new EventHandler<ActionEvent>() {
            double dx = 2;
            double dy = 5;
            @Override
            public void handle(ActionEvent actionEvent) {
                rectangle.setLayoutX(rectangle.getLayoutX() + dx);
                rectangle.setLayoutY(rectangle.getLayoutY() + dy);

                Bounds bounds = pane.getBoundsInLocal();

                if(rectangle.getLayoutX() <= (bounds.getMinX() + rectangle.getWidth()) ||
                        rectangle.getLayoutX() >= (bounds.getMaxX() - rectangle.getWidth())) {
                    System.out.println("Out of bounds X " + rectangle.getLayoutX());

                    dx = -dx;
                }

                if(rectangle.getLayoutY() <= (bounds.getMinY() + rectangle.getWidth()) ||
                        rectangle.getLayoutY() >= (bounds.getMaxY() - rectangle.getWidth())) {
                    dy = -dy;
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


    }

    public static void main(String[] args) {
        launch();
    }

}