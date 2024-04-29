import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculating extends javax.swing.JFrame {

    private double total = 0.0;
    private double previousResult = 0.0;
    private String lastOperation = "";

    private JPanel MyCalculator;
    private JTextField output;
    private JButton CLEAR;
    private JButton btn9;
    private JButton btn7;
    private JButton btn8;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton multiply;
    private JButton plus;
    private JButton squareRoot;
    private JButton equall;
    private JButton minus;
    private JButton divide;
    private JButton square;
    private JButton cubeRoot;
    private JButton modButton;
    private JTextField input;
    private JButton percent;
    private JButton oneoverNButton;
    private JButton plusMinus;
    private JButton decimal;
    private JButton btn0;
    private JButton naturalLog;
    private JButton tanButton;
    private JButton cosButton;
    private JButton sinButton;
    private JButton a10NButton;
    private JButton logButton;
    private JButton EXITButton;
    private JButton absoluteValue;
    private JButton atanButton;
    private JButton acosButton;
    private JButton asinButton;
    private JButton tanhButton;
    private JButton coshButton;
    private JButton sinhButton;

    public Calculating() {
        MyCalculator.setPreferredSize(new Dimension(500,700));

        ActionListener numberListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = e.getActionCommand();
                input.setText(input.getText() + number);
                output.setText(input.getText());
            }
        };

        btn0.addActionListener(numberListener);
        btn1.addActionListener(numberListener);
        btn2.addActionListener(numberListener);
        btn3.addActionListener(numberListener);
        btn4.addActionListener(numberListener);
        btn5.addActionListener(numberListener);
        btn6.addActionListener(numberListener);
        btn7.addActionListener(numberListener);
        btn8.addActionListener(numberListener);
        btn9.addActionListener(numberListener);

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("+");
            }
        });

        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("-");
            }
        });

        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("*");
            }
        });

        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("/");
            }
        });

        equall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!lastOperation.isEmpty()) {
                    calculateResult();
                    lastOperation = "";
                }
            }
        });

        CLEAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total = 0.0;
                previousResult = 0.0;
                lastOperation = "";
                input.setText("");
                output.setText("");
            }
        });

        decimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().contains(".")) {
                    input.setText(input.getText() + ".");
                    output.setText(input.getText());
                }
            }
        });
        percent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("%");
            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("^");
            }
        });
        cubeRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("^^");
            }
        });
        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("sin");
            }
        });
        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("cos");
            }
        });
        tanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("tan");
            }
        });
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("log");
            }
        });
        sinhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("sinh");
            }
        });
        coshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("cosh");
            }
        });
        tanhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("tanh");
            }
        });
        modButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("%%");
            }
        });
        oneoverNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("one_n");

            }
        });
        squareRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("√");
            }
        });
        plusMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("±");

            }
        });
    }

    private void performOperation(String operation) {
        if (!input.getText().isEmpty()) {
            if (!lastOperation.isEmpty()) {
                calculateResult();
            } else {
                total = Double.parseDouble(input.getText());
                previousResult = total;
            }
            lastOperation = operation;
            input.setText("");
        } else {
            output.setText("Input is empty");
        }
    }




    private void calculateResult() {
        switch (lastOperation) {
            case "+":
                previousResult = total + Double.parseDouble(input.getText());
                break;
            case "-":
                previousResult = total - Double.parseDouble(input.getText());
                break;
            case "*":
                previousResult = total * Double.parseDouble(input.getText());
                break;
            case "/":
                double denominator = Double.parseDouble(input.getText());
                if (denominator != 0) {
                    previousResult = total / denominator;
                } else {
                    output.setText("Error cannot divide by 0");
                    return;
                }
                break;
            case "%%":
                previousResult = total % Double.parseDouble(input.getText());
                break;
            case "^":
                double numToSquare = Double.parseDouble(input.getText());
                previousResult = Math.pow(numToSquare, 2);
                output.setText(Double.toString(previousResult));
                total = previousResult;
                return;
            case "^^":
                double numToCube = Double.parseDouble(input.getText());
                previousResult = Math.pow(numToCube, 1.0 / 3.0);
                output.setText(Double.toString(previousResult));
                total = previousResult;
                input.setText("");
                break;
            case "sin":
                previousResult = Math.sin(Double.parseDouble(input.getText()));
                break;
            case "cos":
                previousResult = Math.cos(Double.parseDouble(input.getText()));
                break;
            case "tan":
                previousResult = Math.tan(Double.parseDouble(input.getText()));
                break;
            case "log":
                previousResult = Math.log(Double.parseDouble(input.getText()));
                break;
            case "asin":
                previousResult = Math.asin(Double.parseDouble(input.getText()));
                break;
            case "acos":
                previousResult = Math.acos(Double.parseDouble(input.getText()));
                break;
            case "atan":
                previousResult = Math.atan(Double.parseDouble(input.getText()));
                break;
            case "sinh":
                previousResult = Math.sinh(Double.parseDouble(input.getText()));
                break;
            case "cosh":
                previousResult = Math.cosh(Double.parseDouble(input.getText()));
                break;
            case "tanh":
                previousResult = Math.tanh(Double.parseDouble(input.getText()));
                break;
            case "%":
                String outputText = output.getText();
                previousResult = Double.parseDouble(outputText) * 100;
                break;
            case "one_n":
                if (!input.getText().isEmpty()) {
                    double number = Double.parseDouble(input.getText());
                    if (number != 0) {
                        double reciprocal = 1 / number;
                        output.setText(Double.toString(reciprocal));
                        input.setText("");
                    } else {
                        output.setText("Error: Cannot divide by zero");
                    }
                } else {
                    output.setText("Input is empty");
                }
                break;
            case "√":
                previousResult = Math.sqrt(Double.parseDouble(input.getText()));
                break;
            case "±":
                double value = Double.parseDouble(input.getText());
                value = -value;
                input.setText(Double.toString(value));
                output.setText(input.getText());
                break;
        }
        output.setText(Double.toString(previousResult));
        input.setText("");
        total = previousResult;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculating().MyCalculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
