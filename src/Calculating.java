/*
Author: Kirsten Hefney
Class: COMP167.001
Date: May 1st, 2024
Description: This Java code defines a simple calculator GUI application using Swing.
It consists of various components such as buttons for digits, arithmetic operations, trigonometric functions, and other mathematical operations.
The calculator performs basic arithmetic calculations as well as advanced operations like square root, cube root, trigonometric functions, logarithms, and more.
It utilizes event listeners to handle user interactions and updates the display accordingly. Overall,
it provides a functional and interactive interface for performing mathematical calculations.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculating extends javax.swing.JFrame {
    // GUI components

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

        // ActionListener for number buttons to handle digit input
        ActionListener numberListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = e.getActionCommand();
                input.setText(input.getText() + number);
                output.setText(input.getText());
            }
        };
        // Assigning numberListener to digit buttons
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

        // ActionListener for addition operation
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("+");
            }
        });

        // ActionListener for subtraction operation
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("-");
            }
        });

        // ActionListener for multiplication operation
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("*");
            }
        });

        // ActionListener for division operation
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("/");
            }
        });

        // ActionListener for equal operation to calculate result
        equall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!lastOperation.isEmpty()) {
                    calculateResult();
                    lastOperation = "";
                }
            }
        });

        // ActionListener for clear button to reset calculator
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

        // ActionListener for decimal button to handle decimal input
        decimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().contains(".")) {
                    input.setText(input.getText() + ".");
                    output.setText(input.getText());
                }
            }
        });

        // ActionListener for percentage button to calculate percentage
        percent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double num = Double.parseDouble(input.getText());
                    previousResult = num / 100;
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText(""); // Clear input field
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener to exit the application
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // ActionListener to calculate square of a number
        square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double numToSquare = Double.parseDouble(input.getText());
                previousResult = Math.pow(numToSquare, 2);
                output.setText(Double.toString(previousResult));
                total = previousResult;
            }
        });

        // ActionListener to calculate cube root of a number
        cubeRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double numTopower = Double.parseDouble(input.getText());
                previousResult = Math.pow(numTopower, 3);
                output.setText(Double.toString(previousResult));
                total = previousResult;
            }
        });

        // ActionListener for sine function
        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double numSin = Double.parseDouble(input.getText());
                    previousResult = Math.sin(numSin);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText(""); // Clear input field
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener for cosine function
        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double numCos = Double.parseDouble(input.getText());
                    previousResult = Math.cos(numCos);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText("");
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener for tangent function
        tanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double numTan = Double.parseDouble(input.getText());
                    previousResult = Math.tan(numTan);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText("");
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener for logarithm function
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double numLog = Double.parseDouble(input.getText());
                    previousResult = Math.log10(numLog);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText(""); // Clear input field
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener for hyperbolic sine function
        sinhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double numSinH = Double.parseDouble(input.getText());
                    previousResult = Math.sinh(numSinH);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText(""); // Clear input field
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener for hyperbolic cosine function
        coshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double numCosH = Double.parseDouble(input.getText());
                    previousResult = Math.cosh(numCosH);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText(""); // Clear input field
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener for hyperbolic tangent function
        tanhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double numTanH = Double.parseDouble(input.getText());
                    previousResult = Math.tanh(numTanH);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText(""); // Clear input field
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener for modulo operation
        modButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("%%");
            }
        });

        // ActionListener to calculate reciprocal
        oneoverNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double denom = Double.parseDouble(input.getText());
                    if (denom != 0) {
                        previousResult = 1 / denom;
                        output.setText(Double.toString(previousResult));
                        total = previousResult;
                        input.setText(""); // Clear input field
                    } else {
                        output.setText("Error: Division by zero");
                    }
                } else {
                    output.setText("Input is empty");
                }

            }
        });

        // ActionListener to calculate square root
        squareRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double numSqrt = Double.parseDouble(input.getText());
                    previousResult = Math.sqrt(numSqrt);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText("");
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener to toggle sign
        plusMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double value = Double.parseDouble(input.getText());
                    value *= -1;
                    input.setText(Double.toString(value));
                    output.setText(input.getText());
                }

            }
        });

        // ActionListener to calculate absolute value
        absoluteValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double num = Double.parseDouble(input.getText());
                    previousResult = Math.abs(num);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText(""); // Clear input field
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener to calculate natural logarithm
        naturalLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double num = Double.parseDouble(input.getText());
                    if (num > 0) {
                        previousResult = Math.log(num);
                        output.setText(Double.toString(previousResult));
                        total = previousResult;
                        input.setText(""); // Clear input field
                    } else {
                        output.setText("Error: Input must be greater than 0");
                    }
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener to calculate power of 10
        a10NButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double power = Double.parseDouble(input.getText());
                    previousResult = Math.pow(10, power);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText("");
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener to calculate arctangent
        atanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double numTanA = Double.parseDouble(input.getText());
                    previousResult = Math.atan(numTanA);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText(""); // Clear input field
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener to calculate arccosine
        acosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double numCosA = Double.parseDouble(input.getText());
                    previousResult = Math.acos(numCosA);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText(""); // Clear input field
                } else {
                    output.setText("Input is empty");
                }
            }
        });

        // ActionListener to calculate arcsine
        asinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    double numSinA = Double.parseDouble(input.getText());
                    previousResult = Math.asin(numSinA);
                    output.setText(Double.toString(previousResult));
                    total = previousResult;
                    input.setText(""); // Clear input field
                } else {
                    output.setText("Input is empty");
                }
            }
        });
    }

    // Method to perform arithmetic operations
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

    // Method to calculate the result based on the selected operation
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
        }
        output.setText(Double.toString(previousResult));
        total = previousResult;
        input.setText("");
    }

    // Main method to make the panel visible
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculating().MyCalculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
