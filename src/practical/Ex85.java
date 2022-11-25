package practical;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Ex85 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private GraphCanvas graph;
    private TextField functionInput;
    private Label message;

    public void start(Stage stage) {
        graph = new GraphCanvas(new Expr("sin(x)*3 + cos(5*x)"));

        message = new Label(" Enter a function and click Enter or press return");

        functionInput = new TextField("sin(x)*3 + cos(5*x)");

        Button graphIt = new Button("Enter");
        graphIt.setDefaultButton(true);

        graphIt.setOnAction(evt -> {
            Expr function;  // The user's function.
            try {
                String def = functionInput.getText();
                function = new Expr(def);
                graph.setFunction(function);
                message.setText(" Enter a function and click Enter or press return.");
            } catch (IllegalArgumentException e) {
                graph.clearFunction();
                message.setText(e.getMessage());
            }
            functionInput.selectAll();
            functionInput.requestFocus();  // Let's user start typing in input box.
        });

        HBox bottom = new HBox(8, new Label("f(x) ="), functionInput, graphIt);

        BorderPane root = new BorderPane();
        root.setCenter(graph);
        root.setTop(message);
        root.setBottom(bottom);

        root.setStyle("-fx-border-color:gray; -fx-border-width:4px");
        message.setTextFill(Color.RED);  // User red text for the message.
        message.setStyle("-fx-background-color:white; -fx-padding:7px; "
                + "-fx-border-color:gray; -fx-border-width:0 0 4px 0");
        message.setMaxWidth(10000);  // Required to make the label (and its border)
        // extend the full width of the window.
        bottom.setStyle("-fx-border-color:gray; -fx-border-width:4px 0 0 0; -fx-padding:8px");
        HBox.setHgrow(functionInput, Priority.ALWAYS);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("A Simple Function Grapher");
        stage.show();
    }


    private static class GraphCanvas extends Canvas {
        Expr func;

        GraphCanvas(Expr firstFunction) {
            super(600, 600);  // Calls the constructor from the Canvas class.
            func = firstFunction;
            draw();  // Draw the canvas at startup.
        }

        public void setFunction(Expr exp) {
            // Set the canvas to graph the function whose definition is
            // given by the function exp.
            func = exp;
            draw();
        }

        public void clearFunction() {
            // Set the canvas to draw no graph at all.
            func = null;
            draw();
        }

        public void draw() {
            // Fill the canvas with white, then draw a set of axes
            // and the graph of the function.  Or, if func is null,
            // display a message that there is no function to be graphed.
            GraphicsContext g = getGraphicsContext2D();
            g.setFill(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            if (func == null) {
                g.setFill(Color.RED);
                g.fillText("No function is available.", 30, 40);
            } else {
                g.setFill(Color.PURPLE);
                g.fillText("y = " + func, 5, 15);
                drawAxes(g);
                drawFunction(g);
            }
        }

        void drawAxes(GraphicsContext g) {
            double width = getWidth();
            double height = getHeight();
            g.setStroke(Color.BLUE);
            g.setLineWidth(2);
            g.strokeLine(5, height/2, width-5, height/2);
            g.strokeLine(width/2, 5, width/2, height-5);
        }

        void drawFunction(GraphicsContext g) {
            double x, y;
            double prevx, prevy;

            double dx;

            dx  = 10.0 / 300;

            g.setStroke(Color.RED);
            g.setLineWidth(1);


            x = -5;
            y = func.value(x);


            for (int i = 1; i <= 300; i++) {

                prevx = x;
                prevy = y;

                x += dx;

                y = func.value(x);

                if ( (! Double.isNaN(y)) && (! Double.isNaN(prevy)) ) {
                    putLine(g, prevx, prevy, x, y);
                }

            }

        }


        void putLine(GraphicsContext g, double x1, double y1,
                     double x2, double y2) {
            if (Math.abs(y1) > 10000 || Math.abs(y2) > 10000) {
                return;
            }

            double a1, b1;
            double a2, b2;
            double width = getWidth();
            double height = getHeight();

            a1 = (int)( (x1 + 5) / 10 * width );
            b1 = (int)( (5 - y1) / 10 * height );
            a2 = (int)( (x2 + 5) / 10 * width );
            b2 = (int)( (5 - y2) / 10 * height );

            g.strokeLine(a1,b1,a2,b2);

        }
    }
}

