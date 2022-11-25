package practical;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import java.util.ArrayList;

public class Ex74 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private static class SquareData {
        double x, y;  // Location of center of square.  The size is always 100-by-100.
        Color color; // The color of the square
    }

    private ArrayList<SquareData> squares;  // Info for all squares in the picture.

    private Canvas canvas;  // The canvas where the sqaures are drawn.

    public void start(Stage stage) {

        squares = new ArrayList<SquareData>();

        canvas = new Canvas(640,480);
        draw(); // Will just fill canvas with background color.

        canvas.setOnMousePressed( e -> mousePressed(e) );
        canvas.setOnMouseDragged( e -> mouseDragged(e) );
        canvas.setOnMouseReleased( e -> mouseReleased(e) );

        Pane root = new Pane(canvas);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Click to add a square. Right-click to drag.");
        stage.setResizable(false);
        stage.show();
    }

    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(230,255,230)); // light green
        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        g.setLineWidth(2);
        g.setStroke(Color.BLACK);
        for ( SquareData squareData: squares ) {
            g.setFill( squareData.color );
            g.fillRect( squareData.x - 50, squareData.y - 50, 100, 100);
            g.strokeRect( squareData.x - 50, squareData.y - 50, 100, 100);
        }
    }

    private boolean dragging;
    private SquareData draggedSquare;
    private double offsetX, offsetY;

    public void mousePressed(MouseEvent evt) {

        if (dragging)
            return;

        double x = evt.getX();
        double y = evt.getY();

        if (evt.isShiftDown() || evt.getButton() == MouseButton.SECONDARY) {

            for (int i = squares.size() - 1; i >= 0; i--) {
                SquareData squareData = squares.get(i);
                double cx = squareData.x; // (cx,cy) is the center of the square
                double cy = squareData.y;
                if ( x >= cx - 50 && x <= cx + 50 && y >= cy - 50 && y <= cy + 50) {
                    dragging = true;
                    draggedSquare = squareData;
                    offsetX = x - cx;
                    offsetY = y - cy;
                    break;
                }
            }
        }
        else {
            SquareData squareData = new SquareData();
            squareData.x = x;
            squareData.y = y;
            squareData.color = Color.color(
                    Math.random(), Math.random(), Math.random(), 0.5 + 0.5*Math.random() );
            squares.add( squareData );
            draw();
        }
    }

    public void mouseReleased(MouseEvent evt) {
        if ( ! dragging )
            return;

        if (draggedSquare.x > canvas.getWidth() + 50
                || draggedSquare.x < -50
                || draggedSquare.y > canvas.getHeight() + 50
                || draggedSquare.y < -50) {
            squares.remove(draggedSquare);
            System.out.println("Removed square; list size = " + squares.size());
        }

        dragging = false;
        draggedSquare = null;
    }
    public void mouseDragged(MouseEvent evt) {
        if ( ! dragging )
            return;
        double x = evt.getX();
        double y = evt.getY();
        draggedSquare.x = x - offsetX;
        draggedSquare.y = y - offsetY;
        draw();
    }

}



