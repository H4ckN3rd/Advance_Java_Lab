import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculator {
    private JFrame frame;
    private JTextField num1Field;
    private JTextField num2Field;
    private JTextField resultField;
    private JLabel operationStatusLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                BasicCalculator calculator = new BasicCalculator();
                calculator.initialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void initialize() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel num1Label = new JLabel("First Number:");
        num1Field = new JTextField(10);
        inputPanel.add(num1Label);
        inputPanel.add(num1Field);

        JLabel num2Label = new JLabel("Second Number:");
        num2Field = new JTextField(10);
        inputPanel.add(num2Label);
        inputPanel.add(num2Field);

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(10);
        resultField.setEditable(false);
        inputPanel.add(resultLabel);
        inputPanel.add(resultField);

        frame.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("×");
        JButton divideButton = new JButton("÷");

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        operationStatusLabel = new JLabel("Ready for calculation");
        operationStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(operationStatusLabel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> performOperation('+'));
        subtractButton.addActionListener(e -> performOperation('-'));
        multiplyButton.addActionListener(e -> performOperation('*'));
        divideButton.addActionListener(e -> performOperation('/'));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void performOperation(char operation) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            String operationName = "";

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    operationName = "Addition";
                    break;
                case '-':
                    result = num1 - num2;
                    operationName = "Subtraction";
                    break;
                case '*':
                    result = num1 * num2;
                    operationName = "Multiplication";
                    break;
                case '/':
                    if (num2 == 0) {
                        operationStatusLabel.setText("Error: Division by zero");
                        return;
                    }
                    result = num1 / num2;
                    operationName = "Division";
                    break;
            }

            String formattedResult;
            if (result == (int) result) {
                formattedResult = String.valueOf((int) result);
            } else {
                formattedResult = String.valueOf(result);
            }

            resultField.setText(formattedResult);
            operationStatusLabel.setText(operationName + " completed successfully");

        } catch (NumberFormatException e) {
            operationStatusLabel.setText("Error: Please enter valid numbers");
            resultField.setText("");
        }
    }
}