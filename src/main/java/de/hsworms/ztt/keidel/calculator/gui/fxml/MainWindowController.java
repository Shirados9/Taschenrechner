package de.hsworms.ztt.keidel.calculator.gui.fxml;

import de.hsworms.ztt.keidel.calculator.Calculator;
import de.hsworms.ztt.keidel.calculator.Main;
import de.hsworms.ztt.keidel.calculator.gui.ResizeHelper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainWindowController {

    //region declare variables
    @FXML
    private Button buttonEquals;
    @FXML
    private TextField resultTextField;
    @FXML
    private Button buttonOne;
    @FXML
    private Button buttonTwo;
    @FXML
    private Button buttonThree;
    @FXML
    private Button buttonFour;
    @FXML
    private Button buttonFive;
    @FXML
    private Button buttonSix;
    @FXML
    private Button buttonSeven;
    @FXML
    private Button buttonEight;
    @FXML
    private Button buttonNine;
    @FXML
    private Button buttonZero;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonSub;
    @FXML
    private Button buttonMulti;
    @FXML
    private Button buttonDivide;
    @FXML
    private Button buttonSqrRoot;
    @FXML
    private Button buttonFactorial;
    @FXML
    private Button buttonPower;
    @FXML
    private Button buttonOpenBracket;
    @FXML
    private Button buttonCloseBracket;
    @FXML
    private Button buttonSin;
    @FXML
    private Button buttonCos;
    @FXML
    private Button buttonTan;
    @FXML
    private Button buttonPi;
    @FXML
    private Button buttonLog;
    @FXML
    private Button buttonLn;
    @FXML
    private Button buttonE;
    @FXML
    private Button buttonMod;
    @FXML
    private Button buttonPeriod;
    @FXML
    private Button buttonClear;
    @FXML
    private HBox titleBar;
    private double xOffSet, yOffSet = 0;
    private double fontSize = 26.;
    //endregion

    /**
     * Initialize all the events for buttons, textfield and make the window dragable
     */
    public void initialize() {
        makeWindowDraggable();
        calculateOnPressingEnter();
        resultTextField.textProperty().addListener(((observableValue, s, t1) -> scaleFont()));
        buttonEquals.setOnAction(actionEvent -> {
            try {
                resultTextField.setText(String.valueOf(Calculator.getResult(resultTextField.getText())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonOne.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("1")));
        buttonTwo.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("2")));
        buttonThree.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("3")));
        buttonFour.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("4")));
        buttonFive.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("5")));
        buttonSix.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("6")));
        buttonSeven.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("7")));
        buttonEight.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("8")));
        buttonNine.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("9")));
        buttonZero.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("0")));
        buttonAdd.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat(" + ")));
        buttonSub.setOnAction(actionEvent -> {
            // Differentiate between sign and operator. "-" = sign, " - " = operator
            if (resultTextField.getLength() == 0) {
                resultTextField.appendText("-");
            } else if (resultTextField.getText(resultTextField.getLength() - 1, resultTextField.getLength()).matches("[0-9]")) {
                resultTextField.appendText(" - ");
            } else if (resultTextField.getText(resultTextField.getLength() - 2, resultTextField.getLength() - 1).matches("[-+*/%^]")) {
                resultTextField.appendText("-");
            } else if (resultTextField.getText(resultTextField.getLength() - 1, resultTextField.getLength()).matches("[(]")) {
                resultTextField.appendText("-");
            }
        });
        buttonMulti.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat(" * ")));
        buttonDivide.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat(" / ")));
        buttonSqrRoot.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("sqrt(")));
        buttonFactorial.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("fac(")));
        buttonPower.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("^")));
        buttonOpenBracket.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("(")));
        buttonCloseBracket.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat(")")));
        buttonSin.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("sin(")));
        buttonCos.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("cos(")));
        buttonTan.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("tan(")));
        buttonPi.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("\u03C0")));
        buttonLog.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("log(")));
        buttonLn.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("ln(")));
        buttonE.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat("e")));
        buttonMod.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat(" % ")));
        buttonPeriod.setOnAction(actionEvent -> resultTextField.setText((resultTextField.getText()).concat(".")));
        buttonClear.setOnAction(actionEvent -> resultTextField.setText(""));
    }

    /**
     * Changes the font-size dependent on the width of the text in resultTextField
     */
    private void scaleFont() {
        Platform.runLater(() -> {
            Text resultText = new Text(resultTextField.getText());
            resultText.setFont(Font.font(fontSize));

            //Compares the size of the text to the size of the textfield and changes the fontsize dependent on each other

            if (resultText.getLayoutBounds().getWidth() >= resultTextField.getBoundsInLocal().getWidth() - 15 && fontSize >= 25) {
                fontSize /= 1.3;
            } else if (resultText.getLayoutBounds().getWidth() >= resultTextField.getBoundsInLocal().getWidth() - 15 && fontSize < 25) {
                fontSize /= 1.1;
            } else if (resultText.getLayoutBounds().getWidth() <= (resultTextField.getBoundsInLocal().getWidth() / 2) && fontSize < 35) {
                fontSize = 25;
            } else if (resultText.getLayoutBounds().getWidth() <= (resultTextField.getBoundsInLocal().getWidth() / 4) && fontSize < 35) {
                fontSize = 35;
            }
            resultTextField.setStyle("-fx-font-size: " + fontSize + "px");
        });
    }

    /**
     * Starts calculate after pressing Enter in the TextField
     */
    private void calculateOnPressingEnter() {
        resultTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                    try {
                        resultTextField.setText(String.valueOf(Calculator.getResult(resultTextField.getText())));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * Allows the window to be moved when clicking and dragging the title bar
     */
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

    /**
     * Changes Scene to PlotWindow
     *
     * @param event
     * @throws IOException
     */
    public void changeToPlotWindow(final ActionEvent event) throws IOException {
        URL url = new File("src/main/java/de/hsworms/ztt/keidel/calculator/gui/fxml/PlotWindow.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Scene plotScene = new Scene(root);
        Main.stage.setScene(plotScene);
        ResizeHelper.addResizeListener(Main.stage);
        Main.stage.show();
    }

    /**
     * Exits program when clicking the "x" in the top right corner
     *
     * @param mouseEvent
     */
    public void closeApp(final javafx.scene.input.MouseEvent mouseEvent) {
        System.exit(0);
    }

    /**
     * Minimizes program when clicking the "_" in the top right corner
     *
     * @param mouseEvent
     */
    public void minimizeApp(final javafx.scene.input.MouseEvent mouseEvent) {
        Main.stage.setIconified(true);
    }
}
