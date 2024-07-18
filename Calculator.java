import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    // Define components
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subButton, mulButton, divButton, clrButton;
    private JLabel firstNumberLabel, secondNumberLabel, resultLabel;

    public Calculator() {
        // Set up the JFrame
        setTitle("Simple Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Initialize components
        firstNumberLabel = new JLabel("First Number:");
        firstNumberField = new JTextField();

        secondNumberLabel = new JLabel("Second Number:");
        secondNumberField = new JTextField();

        resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clrButton = new JButton("Clear");

        // Add action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        clrButton.addActionListener(this);

        // Add components to the frame
        add(firstNumberLabel);
        add(firstNumberField);
        add(secondNumberLabel);
        add(secondNumberField);
        add(resultLabel);
        add(resultField);
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);
        add(clrButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            } else if (e.getSource() == mulButton) {
                result = num1 * num2;
            } else if (e.getSource() == divButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else if (e.getSource() == clrButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
