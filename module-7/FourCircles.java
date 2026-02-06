// Jackson Webster
// 2/6/2026
// CSD-420
// This program makes 4 circles one with in a rectangle another just plain hollow and 2 others that are green and red. It uses a style css sheet to add the color.

import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class FourCircles extends Application {

    @Override
    public void start(Stage stage) {

        // Circle with border
        Circle c1 = new Circle(40);
        c1.getStyleClass().addAll("plaincircle", "circleborder");

        // Tall rectangle
        Rectangle border = new Rectangle(90, 400);
        border.getStyleClass().add("border");

        
        Pane firstCirclePane = new Pane();
        firstCirclePane.setPrefSize(90, 80);   

        // Center circle vertically in the rectangle
        c1.setLayoutX(45);   
        c1.setLayoutY(200);  

        firstCirclePane.getChildren().addAll(border, c1);

        Circle c2 = new Circle(40);
        c2.getStyleClass().addAll("plaincircle", "circleborder");

        Circle c3 = new Circle(40);
        c3.setId("redcircle");

        Circle c4 = new Circle(40);
        c4.setId("greencircle");

        HBox circles = new HBox(20, firstCirclePane, c2, c3, c4);
        circles.setAlignment(Pos.CENTER);

        StackPane root = new StackPane(circles);

        Scene scene = new Scene(root, 550, 300);
        scene.getStylesheets().add("file:./style.css");

        stage.setTitle("Exercise31_01");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
