package swing_calc;


import javax.swing.*;
import java.math.BigDecimal;


public class Calculator extends JFrame {

    private BigDecimal currentValue = BigDecimal.ZERO;
    private BigDecimal savedValue = BigDecimal.ZERO;
    private char functionKey = '=';

    Calculator() {
        createUIComponents();
    }

    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a0Button;
    private JButton signButton;
    private JButton dotButton;
    private JButton resultButton;
    private JButton resetButton;
    private JButton divideButton;
    private JButton multiplyButton;
    private JButton subtractButton;
    private JButton addButton;
    private JFormattedTextField display;
    private JPanel panel;

    private void createUIComponents() {
        setTitle("Calculator");
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 600);
        setResizable(false);
        setVisible(true);
        display.setText(BigDecimal.ZERO.toString());

        a1Button.addActionListener(actionEvent -> keyEvent(a1Button));
        a2Button.addActionListener(actionEvent -> keyEvent(a2Button));
        a3Button.addActionListener(actionEvent -> keyEvent(a3Button));
        a4Button.addActionListener(actionEvent -> keyEvent(a4Button));
        a5Button.addActionListener(actionEvent -> keyEvent(a5Button));
        a6Button.addActionListener(actionEvent -> keyEvent(a6Button));
        a7Button.addActionListener(actionEvent -> keyEvent(a7Button));
        a8Button.addActionListener(actionEvent -> keyEvent(a8Button));
        a9Button.addActionListener(actionEvent -> keyEvent(a9Button));
        a0Button.addActionListener(actionEvent -> keyEvent(a0Button));
        addButton.addActionListener(actionEvent -> Process("+"));
        subtractButton.addActionListener(actionEvent -> Process("-"));
        multiplyButton.addActionListener(actionEvent -> Process("*"));
        divideButton.addActionListener(actionEvent -> Process("/"));
        resultButton.addActionListener(actionEvent -> Process("="));
        resetButton.addActionListener(actionEvent -> Process("CE"));

        signButton.addActionListener(actionEvent -> {
            currentValue = currentValue.multiply(new BigDecimal("-1"));
            display.setText(currentValue.toString());
        });

        dotButton.addActionListener(actionEvent -> {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
                if (currentValue.equals(BigDecimal.ZERO)) {
                    display.setText("0.");
                }
            }
        });

    }

    private void keyEvent(JButton button) {
        if (currentValue.equals(BigDecimal.ZERO) && !display.getText().equals("0.")) {
            display.setText("");
        }
        display.setText(display.getText() + button.getText());
        currentValue = new BigDecimal(display.getText());
    }

    private void Process(String buttonValue) {
        currentValue = new BigDecimal(display.getText());

        if ("CE".equals(buttonValue)) {
            currentValue = BigDecimal.ZERO;
            savedValue = BigDecimal.ZERO;
            functionKey = '=';
            display.setText(currentValue.toString());

        } else if ("=".equals(buttonValue)) {
            savedValue = calcResult(currentValue);
            display.setText(savedValue.setScale(16, BigDecimal.ROUND_HALF_DOWN).toPlainString());
            functionKey = '=';

        } else if ("+".equals(buttonValue)) {
            saveCurrentValue();
            functionKey = '+';

        } else if ("-".equals(buttonValue)) {
            saveCurrentValue();
            functionKey = '-';

        } else if ("*".equals(buttonValue)) {
            saveCurrentValue();
            functionKey = '*';

        } else if ("/".equals(buttonValue)) {
            saveCurrentValue();
            functionKey = '/';
        }

    }

    private void saveCurrentValue() {
        savedValue = calcResult(currentValue);
        currentValue = BigDecimal.ZERO;
        display.setText(BigDecimal.ZERO.toString());
    }

    private BigDecimal calcResult(BigDecimal currentValue) {

        BigDecimal result = BigDecimal.ZERO;

        switch (functionKey) {
            case '+':
                result = savedValue.add(currentValue);
                break;
            case '-':
                result = savedValue.subtract(currentValue);
                break;
            case '*':
                result = savedValue.multiply(currentValue);
                break;
            case '/':
                try {
                    result = savedValue.divide(currentValue, 16, BigDecimal.ROUND_HALF_DOWN);
                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(panel, "You can't divide by zero", "Error!", JOptionPane.ERROR_MESSAGE);
                    return result;
                }
                break;
            case '=':
                result = currentValue;
                break;
            default:
                result = currentValue;
                break;

        }

        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

}





