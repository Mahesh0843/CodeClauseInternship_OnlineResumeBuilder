import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class Resume extends JFrame {
    private JTextField tfEmail;
    private JPasswordField pfPassword;

    public Resume() {
        initialize();
    }

    public void initialize() {
        JLabel lbTitle = new JLabel("Login Form", SwingConstants.CENTER);
        lbTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel lbEmail = new JLabel("Email:");
        JLabel lbPassword = new JLabel("Password:");

        tfEmail = new JTextField();
        pfPassword = new JPasswordField();

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());
                if (authenticateUser(email, password)) {
                    openPersonalInfoPage();
                } else {
                    JOptionPane.showMessageDialog(Resume.this,
                            "Email or Password Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        inputPanel.add(lbEmail);
        inputPanel.add(tfEmail);
        inputPanel.add(lbPassword);
        inputPanel.add(pfPassword);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnLogin);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(lbTitle, BorderLayout.NORTH);
        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean authenticateUser(String email, String password) {
        return true; 
    }

    private void openPersonalInfoPage() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Resume();
        });
    }
}
