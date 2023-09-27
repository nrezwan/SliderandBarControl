package Part2;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        VBox vbox = new VBox();
        vbox.setSpacing(5);

        Slider slider = new Slider(150.0,1000.0,275.0);

        Label sliderval = new Label();
        sliderval.textProperty().bind(Bindings.format("%.1f", slider.valueProperty()));
        sliderval.setFont(Font.font(24));

        Button quitbutton = new Button("Quit");
        quitbutton.setOnAction(event -> {
                System.out.println("Goodbye!");
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        });

        ObservableList list = vbox.getChildren();
        list.addAll(slider, sliderval, quitbutton);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}