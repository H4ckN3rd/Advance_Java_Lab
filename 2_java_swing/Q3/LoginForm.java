import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "1234";

    public LoginForm() {
        super("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateLogin();
            }
        });
        buttonPanel.add(loginButton);

        add(buttonPanel, BorderLayout.SOUTH);

        statusLabel = new JLabel("Please enter your credentials");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(statusLabel, BorderLayout.NORTH);

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    validateLogin();
                }
            }
        });
    }

    private void validateLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Error: Username and password cannot be empty");
            statusLabel.setForeground(Color.RED);
        } else if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            statusLabel.setText("Login successful!");
            statusLabel.setForeground(new Color(0, 150, 0)); // Dark green

            JOptionPane.showMessageDialog(this,
                    "Welcome, " + username + "!",
                    "Login Successful",
                    JOptionPane.INFORMATION_MESSAGE);

        } else {
            statusLabel.setText("Error: Invalid username or password");
            statusLabel.setForeground(Color.RED);

            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginForm form = new LoginForm();
                form.setVisible(true);
            }
        });
    }
}