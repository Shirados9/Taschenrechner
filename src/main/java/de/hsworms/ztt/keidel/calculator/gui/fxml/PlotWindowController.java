package de.hsworms.ztt.keidel.calculator.gui.fxml;

import de.hsworms.ztt.keidel.calculator.Calculator;
import de.hsworms.ztt.keidel.calculator.Main;
import de.hsworms.ztt.keidel.calculator.gui.ResizeHelper;
import de.hsworms.ztt.keidel.calculator.tokenizer.Token;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

public class PlotWindowController implements Initializable {

    @FXML
    private LineChart<Double, Double> lineChart;

    private MyPlot plotting;

    @FXML
    private HBox titleBar;

    private double xOffSet, yOffSet = 0;

    @FXML
    private TextField resultTextField;

    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        makeWindowDraggable();
        plotting = new MyPlot(lineChart, 10);
    }

    @FXML
    private void handleButtonPlottingAction(final ActionEvent event) {
        plotLine(x -> x);
    }

    /**
     * Changes scene to MainWindow
     *
     * @param event
     * @throws IOException
     */
    public void changeToMainWindow(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/de/hsworms/ztt/keidel/calculator/gui/fxml/MainWindow.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Scene plotScene = new Scene(root);
        Main.stage.setScene(plotScene);
        ResizeHelper.addResizeListener(Main.stage);
        Main.stage.show();
    }

    // function to convert all "x" in a number in dependence of the characters before the "x"
    public String xToStringConverter(String[] textArray, double x) {
        StringBuilder calculatePlot = new StringBuilder();
        for (int i = 0; i < textArray.length; i++) {
            // check for "-" before "x"
            if (textArray[i].equals("-") && textArray[i + 1].equals("x")) {
                if (i == 0) {
                    calculatePlot.append(x * -1);
                }
                // else insert whitespace to calc with minus
                else {
                    int j = i - 1;
                    Token character = new Token(textArray[j]);
                    while (character.getType() == Token.Type.WHITESPACE) {
                        j--;
                        character = new Token(textArray[j]);
                    }
                    switch (character.getType()) {
                        case LITERAL:
                            calculatePlot.append(" - ").append(x);
                            break;
                        case OPERATOR:
                        case LEFT_BRACKET:
                            calculatePlot.append(" ").append(x * -1);
                            break;
                        default:
                            throw new IllegalStateException("Programing Error! Implement: " + character.getType());
                    }
                }
                i++;
            }
            // checks if there is a "x" at position "[i]
            else if (textArray[i].equals("x")) {

                // checks if "x" is the first character in the string
                if (i == 0) {
                    calculatePlot.append(x);
                } else {
                    int j = i - 1;
                    Token character = new Token(textArray[j]);
                    while (character.getType() == Token.Type.WHITESPACE) {
                        j--;
                        character = new Token(textArray[j]);
                    }
                    switch (character.getType()) {
                        case LITERAL:
                            // important to calculate with "x" if it is not the first character
                            calculatePlot.append(" * ").append(x);
                            break;
                        case OPERATOR:
                        case LEFT_BRACKET:
                            calculatePlot.append(x);
                            break;
                        default:
                            throw new IllegalStateException("Programing Error! Implement: " + character.getType());
                    }
                }
            } else {
                calculatePlot.append(textArray[i]);

            }
        }
        return calculatePlot.toString();
    }

    private void plotLine(Function<Double, Double> function) {
        plotting.plotLine(function);
    }

    public class MyPlot {

        private XYChart<Double, Double> graph;
        private double range;

        public MyPlot(final XYChart<Double, Double> graph, final double range) {
            this.graph = graph;
            this.range = range;
        }


        public void plotLine(final Function<Double, Double> function) {
            final XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
            String[] textFieldArray = resultTextField.getText().split("");
            // calc from -10 to +10 in 0.5 unit steps
            for (double x = -range; x <= range; x = x + 0.5) {
                String calculatePlot = xToStringConverter(textFieldArray, x);
                try {
                    series.getData().add(new XYChart.Data<Double, Double>(x, Calculator.getResult(calculatePlot)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            graph.getData().add(series);
        }

    }

    private void makeWindowDraggable() {
        titleBar.setOnMousePressed((event) -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        titleBar.setOnMouseDragged((event) -> {
            Main.stage.setX(event.getScreenX() - xOffSet);
            Main.stage.setY(event.getScreenY() - yOffSet);
            Main.stage.setOpacity(0.8f);
        });
        titleBar.setOnDragDone((event) -> Main.stage.setOpacity(1.0f));
        titleBar.setOnMouseReleased((event) -> Main.stage.setOpacity(1.0f));
    }

    public void closeApp(javafx.scene.input.MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void minimizeApp(javafx.scene.input.MouseEvent mouseEvent) {
        Main.stage.setIconified(true);
    }
}
