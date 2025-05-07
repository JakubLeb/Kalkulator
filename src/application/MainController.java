package application;

import java.text.NumberFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import application.KalkulatorStrategiczny;
import application.Operacja;

public class MainController {

    private Double liczba1;
    private Operacja operacja;
    private boolean czysc;
    private final KalkulatorStrategiczny kalkulator;

    public MainController() {
        kalkulator = new KalkulatorStrategiczny();
        czysc = false;
    }

    @FXML
    private TextField display;

    @FXML
    private Button btn3;

    @FXML
    public void initialize() {

    }

    private Double getValue(String strValue) {
        try {
            return Double.parseDouble(strValue.replace(',', '.'));
        } catch (NumberFormatException e) {
            showError("Nieprawidłowy format liczby");
            return null;
        }
    }

    private void clearDisplay() {
        display.setText("");
    }

    private void setDisplayValue(String value) {
        display.setText(value);
    }

    private void appendDisplayValue(String value) {
        if (czysc) {
            setDisplayValue(value);
            czysc = false;
        } else {
            display.appendText(value);
        }
    }

    public void onActionBtnDigit(ActionEvent event) {
        Button btn = (Button) event.getSource();
        appendDisplayValue(btn.getText());
    }

    public void handleButtonPress(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String buttonText = btn.getText();
        Double value = getValue(display.getText());
        if (value == null) return;

        try {

            switch (buttonText) {
                case "x²":
                    setDisplayValue(String.valueOf(Math.pow(value, 2)));
                    break;
                case "√":
                    if (value < 0) throw new IllegalArgumentException("Pierwiastek z liczby ujemnej");
                    setDisplayValue(String.valueOf(Math.sqrt(value)));
                    break;
                case "log":
                    if (value <= 0) throw new IllegalArgumentException("Logarytm tylko dla liczb dodatnich");
                    setDisplayValue(String.valueOf(Math.log10(value)));
                    break;
                case "+":
                    this.operacja = Operacja.DODAWANIE;
                    break;
                case "-":
                    this.operacja = Operacja.ODEJMOWANIE;
                    break;
                case "×":
                    this.operacja = Operacja.MNOZENIE;
                    break;
                case "÷":
                    this.operacja = Operacja.DZIELENIE;
                    break;
                case "%":
                    this.operacja = Operacja.MODULO;
                    break;
                default:
                    appendDisplayValue(buttonText);
                    return;
            }

            if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("×") || buttonText.equals("÷") || buttonText.equals("%")) {
                this.liczba1 = value;
                czysc = true;
            } else {
                czysc = true;  
            }

        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }


    public void handleEquals() {
        Double liczba2 = getValue(display.getText());
        if (liczba1 == null || liczba2 == null || operacja == null) {
            showError("Brak danych do wykonania obliczeń");
            return;
        }

        try {
            kalkulator.setStrategiaObliczeń(this.operacja.getStrategiaObliczeń());
            Double wynik = kalkulator.oblicz(liczba1, liczba2);
            setDisplayValue(wynik.toString());
            czysc = true;
        } catch (ArithmeticException e) {
            showError("Błąd w obliczeniach: " + e.getMessage());  
        }
    }


    public void handleClear() {
        clearDisplay();
    }

    public void handleClearAll() {
        clearDisplay();
        liczba1 = null;
        operacja = null;
    }

    public void handleDecimal() {
        if (!display.getText().contains(".")) {
            appendDisplayValue(".");
        }
    }

    public void handleNegate() {
        Double value = getValue(display.getText());
        if (value == null) return;
        setDisplayValue(String.valueOf(-value));
    }

    public void handleBackspace() {
        String currentText = display.getText();
        if (!currentText.isEmpty()) {
            setDisplayValue(currentText.substring(0, currentText.length() - 1));
        }
    }

    private void showError(String info) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText("Wystąpił błąd");
        alert.setContentText(info);
        alert.showAndWait();
    }
}