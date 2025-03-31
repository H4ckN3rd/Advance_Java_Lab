import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSwingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JLabel helloLabel = new JLabel("Hello, Swing!");
        frame.add(helloLabel);

        JButton messageButton = new JButton("Click Me");
        messageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "Button clicked!", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        frame.add(messageButton);

        JTextField textField = new JTextField(15);
        JLabel dynamicLabel = new JLabel("Enter text above");

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLabel();
            }

            private void updateLabel() {
                String text = textField.getText();
                dynamicLabel.setText("You typed: " + text);
            }
        });

        textField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateLabel();
            }

            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateLabel();
            }

            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateLabel();
            }

            private void updateLabel() {
                String text = textField.getText();
                dynamicLabel.setText("You typed: " + text);
            }
        });

        frame.add(textField);
        frame.add(dynamicLabel);

        JButton closeButton = new JButton("Close Window");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.add(closeButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}