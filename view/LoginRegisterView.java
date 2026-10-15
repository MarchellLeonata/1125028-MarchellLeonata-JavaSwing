
package view;

import java.awt.*;
import javax.swing.*;

public class LoginRegisterView extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    private JTextField loginUsername;
    private JPasswordField loginPassword;

    private JTextField registerUsername;
    private JPasswordField registerPassword;

    private JLabel helloLabel;

    private JButton loginButton;
    private JButton goRegisterButton;
    private JButton registerButton;
    private JButton backLoginButton;
    private JButton logoutButton;

    public LoginRegisterView() {
        setTitle("Login & Register");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createLoginPage(), "LOGIN");
        mainPanel.add(createRegisterPage(), "REGISTER");
        mainPanel.add(createHelloPage(), "HELLO");

        add(mainPanel);
        showPage("LOGIN");
    }

    private JPanel createBasePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(
            BorderFactory.createEmptyBorder(35, 50, 35, 50)
        );
        return panel;
    }

    private JPanel createLoginPage() {
        JPanel panel = createBasePanel();

        JLabel title = new JLabel("LOGIN");
        title.setFont(new Font("Arial", Font.BOLD, 26));

        loginUsername = new JTextField(18);
        loginPassword = new JPasswordField(18);

        loginButton = new JButton("Login");
        goRegisterButton = new JButton("Register");

        panel.add(title);
        panel.add(Box.createVerticalStrut(15));
        panel.add(new JLabel("Username"));
        panel.add(loginUsername);
        panel.add(Box.createVerticalStrut(8));
        panel.add(new JLabel("Password"));
        panel.add(loginPassword);
        panel.add(Box.createVerticalStrut(15));
        panel.add(loginButton);
        panel.add(goRegisterButton);

        return panel;
    }

    private JPanel createRegisterPage() {
        JPanel panel = createBasePanel();

        JLabel title = new JLabel("REGISTER");
        title.setFont(new Font("Arial", Font.BOLD, 26));

        registerUsername = new JTextField(18);
        registerPassword = new JPasswordField(18);

        registerButton = new JButton("Register");
        backLoginButton = new JButton("Kembali ke Login");

        panel.add(title);
        panel.add(Box.createVerticalStrut(15));
        panel.add(new JLabel("Username"));
        panel.add(registerUsername);
        panel.add(Box.createVerticalStrut(8));
        panel.add(new JLabel("Password"));
        panel.add(registerPassword);
        panel.add(Box.createVerticalStrut(15));
        panel.add(registerButton);
        panel.add(backLoginButton);

        return panel;
    }

    private JPanel createHelloPage() {
        JPanel panel = createBasePanel();

        helloLabel = new JLabel("Hello, User!");
        helloLabel.setFont(new Font("Arial", Font.BOLD, 26));

        logoutButton = new JButton("Logout");

        panel.add(helloLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(logoutButton);

        return panel;
    }

    // Mengatur halaman yang ditampilkan
    public void showPage(String page) {
        cardLayout.show(mainPanel, page);
    }

    // Mengubah teks sambutan
    public void setHello(String username) {
        helloLabel.setText("Hello, " + username + "!");
    }

    // Mengambil isi input
    public String getLoginUsername() {
        return loginUsername.getText().trim();
    }

    public String getLoginPassword() {
        return new String(loginPassword.getPassword());
    }

    public String getRegisterUsername() {
        return registerUsername.getText().trim();
    }

    public String getRegisterPassword() {
        return new String(registerPassword.getPassword());
    }

    // Mengosongkan input
    public void clearLoginFields() {
        loginUsername.setText("");
        loginPassword.setText("");
    }

    public void clearRegisterFields() {
        registerUsername.setText("");
        registerPassword.setText("");
    }

    // Menampilkan pesan
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // Getter tombol untuk digunakan Controller
    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getGoRegisterButton() {
        return goRegisterButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JButton getBackLoginButton() {
        return backLoginButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }
}
