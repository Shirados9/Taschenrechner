package de.hsworms.ztt.keidel.calculator;

import de.hsworms.ztt.keidel.calculator.gui.ResizeHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static Stage stage = null;

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/main/java/de/hsworms/ztt/keidel/calculator/gui/fxml/MainWindow.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setMinHeight(350);
        stage.setMinWidth(320);
        Main.stage = stage;
        ResizeHelper.addResizeListener(Main.stage);
        stage.show();
    }

    public static double getCalculatorResult(String infix) throws IOException {
        return Calculator.getResult(infix);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
