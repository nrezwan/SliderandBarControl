package Part3;

import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;


public class BarControl extends StackPane {
    Canvas canvas1 = new Canvas(50, 200);
    Canvas canvas2 = new Canvas(40, 190);
    GraphicsContext g = canvas1.getGraphicsContext2D();
    GraphicsContext gc = canvas2.getGraphicsContext2D();
    Label temp = new Label();
    double temp2 = 0;

    public BarControl(double min, double max, double initial){
        temp2 = initial;
        g.setFill(Color.BLACK);
        g.fillRect(0,0,50,200);
        gc.setFill(Color.YELLOW);
        gc.fillRect(0, 200-(initial-min)/2, 50, 200);
        this.getChildren().addAll(canvas1,canvas2);
            canvas2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getY()>=0 && event.getY()<=(max-min)/2) {
                        gc.clearRect(0, 0, 40, 189);
                        g.fillRect(0, 0, 50, event.getY());
                        gc.fillRect(0, event.getY(), 50, 200);
                        temp.textProperty().bind(Bindings.format("%.1f", 100+(200 - event.getY())*2));
                    }
                }
            });
            canvas2.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getY()>=0 && event.getY()<=(max-min)/2) {
                        //gc.clearRect(0,0,50,getHeight());
                        gc.clearRect(0, 0, 40, 189);
                        g.fillRect(0, 0, 50, event.getY());
                        gc.fillRect(0, event.getY(), 50, 200);
                        temp.textProperty().bind(Bindings.format("%.1f", 100+(200 - event.getY())*2));
                    }
                }
            });
    }
}
