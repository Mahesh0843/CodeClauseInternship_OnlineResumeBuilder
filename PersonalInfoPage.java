import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


class PersonalInfoPage extends JFrame {
    private JTextField tfName;
    private JTextField tfEmail;
    private JTextField tfPhone;
    private JTextField tfAddress;
    private JTextArea taSkills;
    private JTextArea taWorkHistory;
    private JTextArea taLanguages;
    private JTextArea taEducation; 
    private List<String> skillsList = new ArrayList<>();
     private JFrame resumeFrame;

    public PersonalInfoPage() {
        initialize();
    }

    private void initialize() {
        setTitle("Personal Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(800, 600);
        setLocationRelativeTo(null);

       
        JPanel personalInfoPanel = new JPanel();
        personalInfoPanel.setLayout(new GridLayout(4, 2));
        personalInfoPanel.setBorder(BorderFactory.createTitledBorder("Personal Information"));

        JLabel lbName = new JLabel("Name:");
        tfName = new JTextField();
        JLabel lbEmail = new JLabel("Email:");
        tfEmail = new JTextField();
        JLabel lbPhone = new JLabel("Phone:");
        tfPhone = new JTextField();
        JLabel lbAddress = new JLabel("Address:");
        tfAddress = new JTextField();

        personalInfoPanel.add(lbName);
        personalInfoPanel.add(tfName);
        personalInfoPanel.add(lbEmail);
        personalInfoPanel.add(tfEmail);
        personalInfoPanel.add(lbPhone);
        personalInfoPanel.add(tfPhone);
        personalInfoPanel.add(lbAddress);
        personalInfoPanel.add(tfAddress);

    
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 4));

        taSkills = new JTextArea();
        JScrollPane skillsScrollPane = new JScrollPane(taSkills);
        JButton addSkillButton = new JButton("Add Skill");
        addSkillButton.setPreferredSize(new Dimension(30, 3));
        addSkillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSkill();
            }
        });
        
        taEducation = new JTextArea();
        JScrollPane educationScrollPane = new JScrollPane(taEducation);
        JButton addEducationButton = new JButton("Add Education");
        addEducationButton.setPreferredSize(new Dimension(30, 3)); 
        addEducationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEducation();
            }
        });


        taWorkHistory = new JTextArea();
        JScrollPane workHistoryScrollPane = new JScrollPane(taWorkHistory);
        JButton addWorkHistoryButton = new JButton("Add Work History");
        addWorkHistoryButton.setPreferredSize(new Dimension(30, 3));
        addWorkHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWorkHistory();
            }
        });

        taLanguages = new JTextArea();
        JScrollPane languagesScrollPane = new JScrollPane(taLanguages);
        JButton addLanguageButton = new JButton("Add Language");
        addLanguageButton.setPreferredSize(new Dimension(30, 3));
        addLanguageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLanguage();
            }
        });

        buttonsPanel.add(addSkillButton);
        buttonsPanel.add(addWorkHistoryButton);
        buttonsPanel.add(addEducationButton); 
        buttonsPanel.add(addLanguageButton);

        JButton generateResumeButton = new JButton("Generate Resume");
        generateResumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resume = generateResume();
                displayResume(resume);
            }
        });

      
        
        JPanel generateResumePanel = new JPanel();
        generateResumePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        generateResumePanel.add(generateResumeButton);


        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(personalInfoPanel, BorderLayout.NORTH);
        getContentPane().add(buttonsPanel, BorderLayout.CENTER);
        getContentPane().add(generateResumePanel, BorderLayout.SOUTH); 
    }

    private void addSkill() {
        String skill = JOptionPane.showInputDialog(this, "Enter Skill:");
        if (skill != null && !skill.isEmpty()) {
            skillsList.add(skill);
            updateSkillsTextArea();
        }
    }

    private void updateSkillsTextArea() {
        StringBuilder skillsText = new StringBuilder();
        for (String skill : skillsList) {
            skillsText.append(skill).append("\n");
        }
        taSkills.setText(skillsText.toString());
    }

    private void addWorkHistory() {
        String jobTitle = JOptionPane.showInputDialog(this, "Enter Job Title:");
        String location = JOptionPane.showInputDialog(this, "Enter Location:");
        String experience = JOptionPane.showInputDialog(this, "Enter Experience:");

        if (jobTitle != null && !jobTitle.isEmpty() &&
            location != null && !location.isEmpty() &&
            experience != null && !experience.isEmpty()) {
            taWorkHistory.append("Job Title: " + jobTitle + "\n");
            taWorkHistory.append("Location: " + location + "\n");
            taWorkHistory.append("Experience: " + experience + "\n\n");
        }
    }

    private void addLanguage() {
        String languageText = JOptionPane.showInputDialog(this, "Enter Language:");
        if (languageText != null && !languageText.isEmpty()) {
            taLanguages.append(languageText + "\n");
        }
    }

    private void addEducation() {
    String school = JOptionPane.showInputDialog(this, "Enter School:");
    String graduationYear = JOptionPane.showInputDialog(this, "Enter Graduation Year:");
    String college = JOptionPane.showInputDialog(this, "Enter College:");
    String collegeGraduationYear = JOptionPane.showInputDialog(this, "Enter College Graduation Year:");

    if (school != null && !school.isEmpty() &&
        graduationYear != null && !graduationYear.isEmpty() &&
        college != null && !college.isEmpty() &&
        collegeGraduationYear != null && !collegeGraduationYear.isEmpty()) {
        taEducation.append("School: " + school + "\n");
        taEducation.append("Graduation Year: " + graduationYear + "\n");
        taEducation.append("College: " + college + "\n");
        taEducation.append("College Graduation Year: " + collegeGraduationYear + "\n\n");
    }
}
        private String generateResume() {
        String name = tfName.getText();
        String email = tfEmail.getText();
        String phone = tfPhone.getText();
        String address = tfAddress.getText();

        String skills = taSkills.getText();
        String workHistory = taWorkHistory.getText();
        String languages = taLanguages.getText();

        StringBuilder resume = new StringBuilder();

        resume.append("Resume\n\n");
        resume.append("Personal Information:\n");
        resume.append("Name: " + name + "\n");
        resume.append("Email: " + email + "\n");
        resume.append("Phone: " + phone + "\n");
        resume.append("Address: " + address + "\n\n");

        resume.append("Skills:\n");
        resume.append(skills + "\n\n");

        resume.append("Work History:\n");
        resume.append(workHistory + "\n\n");

        resume.append("Languages:\n");
        resume.append(languages + "\n");

        return resume.toString();
    }

      private void displayResume(String resume) {
        JOptionPane.showMessageDialog(this, resume, "Resume", JOptionPane.INFORMATION_MESSAGE);
         resumeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JTextArea resumeTextArea = new JTextArea();
        resumeTextArea.setText(resume);
        resumeTextArea.setEditable(false);
       
        resumeFrame.add(new JScrollPane(resumeTextArea));
        resumeFrame.pack();
        resumeFrame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PersonalInfoPage().setVisible(true);
        });
    }
}
