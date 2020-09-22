package de.hsworms.ztt.keidel.calculator.gui.fxml;

import de.hsworms.ztt.keidel.calculator.Calculator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

public class MainWindowControllerTest extends ApplicationTest {

    //region declare variables
    private static final double DELTA = 0.0000001;
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
    //endregion

    /**
     * Set TextField after every test to ""
     */
    @After
    public void afterEachTest() {
        resultTextField.setText("");
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/main/java/de/hsworms/ztt/keidel/calculator/gui/fxml/MainWindow.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();

        //region initialize buttons for following tests
        buttonEquals = lookup("#buttonEquals").query();
        resultTextField = lookup("#resultTextField").query();
        buttonOne = lookup("#buttonOne").query();
        buttonTwo = lookup("#buttonTwo").query();
        buttonThree = lookup("#buttonThree").query();
        buttonFour = lookup("#buttonFour").query();
        buttonFive = lookup("#buttonFive").query();
        buttonSix = lookup("#buttonSix").query();
        buttonSeven = lookup("#buttonSeven").query();
        buttonEight = lookup("#buttonEight").query();
        buttonNine = lookup("#buttonNine").query();
        buttonZero = lookup("#buttonZero").query();
        buttonAdd = lookup("#buttonAdd").query();
        buttonSub = lookup("#buttonSub").query();
        buttonMulti = lookup("#buttonMulti").query();
        buttonDivide = lookup("#buttonDivide").query();
        buttonSqrRoot = lookup("#buttonSqrRoot").query();
        buttonFactorial = lookup("#buttonFactorial").query();
        buttonPower = lookup("#buttonPower").query();
        buttonOpenBracket = lookup("#buttonOpenBracket").query();
        buttonCloseBracket = lookup("#buttonCloseBracket").query();
        buttonSin = lookup("#buttonSin").query();
        buttonCos = lookup("#buttonCos").query();
        buttonTan = lookup("#buttonTan").query();
        buttonPi = lookup("#buttonPi").query();
        buttonLog = lookup("#buttonLog").query();
        buttonLn = lookup("#buttonLn").query();
        buttonE = lookup("#buttonE").query();
        buttonMod = lookup("#buttonMod").query();
        buttonPeriod = lookup("#buttonPeriod").query();
        buttonClear = lookup("#buttonClear").query();
        //endregion
    }

    //region test simple button presses
    @Test
    public void test_button_one() {
        clickOn(buttonOne);
        Assertions.assertThat(resultTextField).hasText("1");
    }

    @Test
    public void test_button_two() {
        clickOn(buttonTwo);
        Assertions.assertThat(resultTextField).hasText("2");
    }

    @Test
    public void test_button_three() {
        clickOn(buttonThree);
        Assertions.assertThat(resultTextField).hasText("3");
    }

    @Test
    public void test_button_four() {
        clickOn(buttonFour);
        Assertions.assertThat(resultTextField).hasText("4");
    }

    @Test
    public void test_button_five() {
        clickOn(buttonFive);
        Assertions.assertThat(resultTextField).hasText("5");
    }

    @Test
    public void test_button_six() {
        clickOn(buttonSix);
        Assertions.assertThat(resultTextField).hasText("6");
    }

    @Test
    public void test_button_seven() {
        clickOn(buttonSeven);
        Assertions.assertThat(resultTextField).hasText("7");
    }

    @Test
    public void test_button_eight() {
        clickOn(buttonEight);
        Assertions.assertThat(resultTextField).hasText("8");
    }

    @Test
    public void test_button_nine() {
        clickOn(buttonNine);
        Assertions.assertThat(resultTextField).hasText("9");
    }

    @Test
    public void test_button_zero() {
        clickOn(buttonZero);
        Assertions.assertThat(resultTextField).hasText("0");
    }

    @Test
    public void test_button_add() {
        clickOn(buttonAdd);
        Assertions.assertThat(resultTextField).hasText(" + ");
    }

    @Test
    public void test_button_sub() {
        clickOn(buttonSub);
        Assertions.assertThat(resultTextField).hasText("-");
    }

    @Test
    public void test_button_sub_as_operator() {
        clickOn(buttonOne);
        clickOn(buttonSub);
        clickOn(buttonOne);
        Assertions.assertThat(resultTextField).hasText("1 - 1");
    }

    @Test
    public void test_button_multi() {
        clickOn(buttonMulti);
        Assertions.assertThat(resultTextField).hasText(" * ");
    }

    @Test
    public void test_button_divide() {
        clickOn(buttonDivide);
        Assertions.assertThat(resultTextField).hasText(" / ");
    }

    @Test
    public void test_button_sqr_root() {
        clickOn(buttonSqrRoot);
        Assertions.assertThat(resultTextField).hasText("sqrt(");
    }

    @Test
    public void test_button_factorial() {
        clickOn(buttonFactorial);
        Assertions.assertThat(resultTextField).hasText("fac(");
    }

    @Test
    public void test_button_power() {
        clickOn(buttonPower);
        Assertions.assertThat(resultTextField).hasText("^");
    }

    @Test
    public void test_button_open_bracket() {
        clickOn(buttonOpenBracket);
        Assertions.assertThat(resultTextField).hasText("(");
    }

    @Test
    public void test_button_close_bracket() {
        clickOn(buttonCloseBracket);
        Assertions.assertThat(resultTextField).hasText(")");
    }

    @Test
    public void test_button_sin() {
        clickOn(buttonSin);
        Assertions.assertThat(resultTextField).hasText("sin(");
    }

    @Test
    public void test_button_cos() {
        clickOn(buttonCos);
        Assertions.assertThat(resultTextField).hasText("cos(");
    }

    @Test
    public void test_button_tan() {
        clickOn(buttonTan);
        Assertions.assertThat(resultTextField).hasText("tan(");
    }

    @Test
    public void test_button_pi() {
        clickOn(buttonPi);
        Assertions.assertThat(resultTextField).hasText("\u03C0");
    }

    @Test
    public void test_button_log() {
        clickOn(buttonLog);
        Assertions.assertThat(resultTextField).hasText("log(");
    }

    @Test
    public void test_button_ln() {
        clickOn(buttonLn);
        Assertions.assertThat(resultTextField).hasText("ln(");
    }

    @Test
    public void test_button_E() {
        clickOn(buttonE);
        Assertions.assertThat(resultTextField).hasText("e");
    }

    @Test
    public void test_button_mod() {
        clickOn(buttonMod);
        Assertions.assertThat(resultTextField).hasText(" % ");
    }

    @Test
    public void test_button_period() {
        clickOn(buttonPeriod);
        Assertions.assertThat(resultTextField).hasText(".");
    }

    //endregion

    /**
     * Tests if the text size scales down after the text gets too long
     */
    @Test
    public void scaleFont_down() {
        double fontSizeStart = resultTextField.getFont().getSize();
        for (int i = 0; i <= 25; i++) {
            clickOn(buttonOne);
        }
        System.out.println("Before: " + fontSizeStart + "\nAfter: " + resultTextField.getFont().getSize());
        assertTrue(fontSizeStart > resultTextField.getFont().getSize());
    }

    /**
     * Tests if the text size scales back up after scaling down
     */
    @Test
    public void scaleDownButton_up() {
        double fontSizeAfterScalingDown;
        for (int i = 0; i <= 25; i++) {
            clickOn(buttonOne);
        }
        fontSizeAfterScalingDown = resultTextField.getFont().getSize();
        clickOn(buttonClear);
        clickOn(buttonOne);
        System.out.println("Before: " + fontSizeAfterScalingDown + "\nAfter: " + resultTextField.getFont().getSize());
        assertTrue(fontSizeAfterScalingDown < resultTextField.getFont().getSize());
    }

    /**
     * Tests "-" as an operator
     */
    @Test
    public void test_minus_as_operator() throws IOException {
        clickOn(buttonOne);
        clickOn(buttonSub);
        clickOn(buttonOne);
        assertEquals("1 - 1", resultTextField.getText());
        assertEquals(0.0, Calculator.getResult(resultTextField.getText()), DELTA);

        clickOn(buttonClear);

        clickOn(buttonSub);
        clickOn(buttonOne);
        clickOn(buttonSub);
        clickOn(buttonOpenBracket);
        clickOn(buttonSub);
        clickOn(buttonOne);
        clickOn(buttonCloseBracket);
        assertEquals("-1 - (-1)", resultTextField.getText());
        assertEquals(0.0, Calculator.getResult(resultTextField.getText()), DELTA);
    }


    /**
     * Tests "-" as an sign
     */
    @Test
    public void test_minus_as_sign() {
        clickOn(buttonSub);
        clickOn(buttonOne);
        clickOn(buttonOne);
        assertEquals("-11", resultTextField.getText());

        clickOn(buttonClear);
        clickOn(buttonOne);
        clickOn(buttonSub);
        clickOn(buttonSub);
        clickOn(buttonOne);
        assertEquals("1 - -1", resultTextField.getText());
    }

    /**
     * Test proper concatenation of button presses in the following tests
     */
    @Test
    public void test_concatenate_button_presses() {
        clickOn(buttonOne);
        clickOn(buttonTwo);
        clickOn(buttonMod);
        clickOn(buttonSqrRoot);
        clickOn(buttonCloseBracket);
        clickOn(buttonDivide);
        clickOn(buttonLn);
        assertEquals("12 % sqrt() / ln(", resultTextField.getText());
    }

    @Test
    public void test_concatenate_button_presses2() {
        clickOn(buttonOpenBracket);
        clickOn(buttonPi);
        clickOn(buttonMulti);
        clickOn(buttonE);
        clickOn(buttonPeriod);
        clickOn(buttonZero);
        assertEquals("(\u03C0 * e.0", resultTextField.getText());
    }

    @Test
    public void test_concatenate_button_presses3() {
        clickOn(buttonOpenBracket);
        clickOn(buttonPi);
        clickOn(buttonMulti);
        clickOn(buttonE);
        clickOn(buttonPeriod);
        clickOn(buttonClear);
        assertEquals("", resultTextField.getText());
    }

    @Test
    public void test_concatenate_button_presses4() {
        clickOn(buttonOne);
        clickOn(buttonTwo);
        clickOn(buttonAdd);
        clickOn(buttonThree);
        clickOn(buttonMulti);
        clickOn(buttonZero);
        clickOn(buttonEquals);
        assertEquals("12.0", resultTextField.getText());
    }

    /**
     * Test if all button presses in a row work
     */
    @Test
    public void test_every_button_in_a_row() {
        clickOn(buttonOne);
        clickOn(buttonClear);
        clickOn(buttonTwo);
        clickOn(buttonThree);
        clickOn(buttonEquals);
        clickOn(buttonFour);
        clickOn(buttonFive);
        clickOn(buttonSix);
        clickOn(buttonSeven);
        clickOn(buttonEight);
        clickOn(buttonNine);
        clickOn(buttonZero);
        clickOn(buttonAdd);
        clickOn(buttonSub);
        clickOn(buttonMulti);
        clickOn(buttonDivide);
        clickOn(buttonSqrRoot);
        clickOn(buttonFactorial);
        clickOn(buttonPower);
        clickOn(buttonOpenBracket);
        clickOn(buttonCloseBracket);
        clickOn(buttonSin);
        clickOn(buttonCos);
        clickOn(buttonTan);
        clickOn(buttonPi);
        clickOn(buttonLog);
        clickOn(buttonLn);
        clickOn(buttonE);
        clickOn(buttonMod);
        clickOn(buttonPeriod);
        assertEquals("23.04567890 + - *  / sqrt(fac(^()sin(cos(tan(\u03C0log(ln(e % .", resultTextField.getText());
    }

    /**
     * Test for correct solution after pressing "="
     */
    @Test
    public void calculate() {
        clickOn(buttonOne);
        clickOn(buttonAdd);
        clickOn(buttonThree);
        clickOn(buttonMulti);
        clickOn(buttonSix);
        clickOn(buttonEquals);
        assertEquals("19.0", resultTextField.getText());
        clickOn(buttonClear);

        clickOn(buttonPi);
        clickOn(buttonDivide);
        clickOn(buttonPi);
        clickOn(buttonMod);
        clickOn(buttonOne);
        clickOn(buttonEquals);
        assertEquals("0.0", resultTextField.getText());

        clickOn(buttonClear);

        clickOn(buttonTwo);
        clickOn(buttonSub);
        clickOn(buttonSub);
        clickOn(buttonThree);
        clickOn(buttonSub);
        clickOn(buttonFour);
        clickOn(buttonEquals);
        assertEquals("1.0", resultTextField.getText());
    }

}