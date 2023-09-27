package Part3;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
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
        primaryStage.setTitle("CS3035: Widgets & Events");
        HBox hbox = new HBox();
        VBox vbox = new VBox();
        hbox.setSpacing(10);
        BarControl b1 = new BarControl(100.0,500.0,250.0);
        BarControl b2 = new BarControl(100.0,500.0,200.0);
        BarControl b3 = new BarControl(100.0,500.0,300.0);
        Label b1lab = b1.temp;
        b1lab.setFont(Font.font(22));
        b1lab.setText(String.format("%.1f", b1.temp2));
        Label b2lab = b2.temp;
        b2lab.setFont(Font.font(22));
        b2lab.setText(String.format("%.1f", b2.temp2));
        Label b3lab = b3.temp;
        b3lab.setFont(Font.font(22));
        b3lab.setText(String.format("%.1f", b3.temp2));

        Slider slider = new Slider(150.0,1000.0,275.0);
        Label sliderval = new Label();
        sliderval.textProperty().bind(Bindings.format("%.1f", slider.valueProperty()));
        Button quitbutton = new Button("Quit");
        quitbutton.setOnAction(event -> {
            System.out.println("Goodbye!");
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        });

        ObservableList list = hbox.getChildren();
        ObservableList list2 = vbox.getChildren();
        list.addAll(b1,b1lab,b2,b2lab,b3,b3lab);
        list2.addAll(hbox,slider,sliderval,quitbutton);

        Scene scene = new Scene(vbox,400,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}