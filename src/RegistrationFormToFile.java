import javax.swing.*;
import javax.swing.text.Position;
import java.io.*;

public class RegistrationFormToFile {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Form with File Save");
        frame.setSize(500, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tittle
        JLabel tittleLabel1 = new JLabel("Fill up your personal information...");
        tittleLabel1.setBounds(120, 20, 300, 25);
        frame.add(tittleLabel1);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 60, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 60, 250, 25);
        frame.add(nameLabel);
        frame.add(nameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 100, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 100, 250, 25);
        frame.add(emailLabel);
        frame.add(emailField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 140, 100, 25);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 140, 250, 25);
        frame.add(phoneLabel);
        frame.add(phoneField);

        // Address
        // Experience
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 180, 100, 40);

        JTextArea addressArea = new JTextArea();
        addressArea.setBounds(150, 190, 250, 50);
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);

        JScrollPane scrollPane0 = new JScrollPane(addressArea);
        scrollPane0.setBounds(150, 190, 250, 50);

        frame.add(addressLabel);
        frame.add(scrollPane0);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 260, 100, 25);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(150, 260, 70, 25);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(230, 260, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);

        // DOB
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 300, 150, 25);
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++)
            days[i - 1] = String.valueOf(i);
        String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        String[] years = new String[100];
        for (int i = 0; i < 100; i++)
            years[i] = String.valueOf(2025 - i);

        JComboBox<String> dayBox = new JComboBox<>(days);
        JComboBox<String> monthBox = new JComboBox<>(months);
        JComboBox<String> yearBox = new JComboBox<>(years);
        dayBox.setBounds(150, 300, 50, 25);
        monthBox.setBounds(210, 300, 70, 25);
        yearBox.setBounds(290, 300, 70, 25);
        frame.add(dobLabel);
        frame.add(dayBox);
        frame.add(monthBox);
        frame.add(yearBox);

        // Degree
        JLabel degreeLabel = new JLabel("Degree:");
        degreeLabel.setBounds(30, 345, 150, 25);
        String[] degrees = { "BSSE", "MSSE", "MIT" };

        JComboBox<String> degreeBox = new JComboBox<>(degrees);
        degreeBox.setBounds(150, 345, 70, 25);
        frame.add(degreeLabel);
        frame.add(degreeBox);

        // File Upload
        JLabel fileLabel = new JLabel("Picture:");
        fileLabel.setBounds(30, 390, 100, 25);
        JButton fileButton = new JButton("Choose File");
        fileButton.setBounds(150, 390, 120, 25);
        JLabel filePathLabel = new JLabel();
        filePathLabel.setBounds(280, 390, 180, 25);
        frame.add(fileLabel);
        frame.add(fileButton);
        frame.add(filePathLabel);

        final String[] selectedFilePath = { "" };
        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                selectedFilePath[0] = file.getAbsolutePath();
                filePathLabel.setText(file.getName());
            }
        });

        // Tittle
        JLabel tittleLabel2 = new JLabel("Fill up game related information...");
        tittleLabel2.setBounds(120, 450, 300, 25);
        frame.add(tittleLabel2);

        // Position
        JLabel positionLabel = new JLabel("Position:");
        positionLabel.setBounds(30, 510, 150, 25);
        String[] position = { "GK", "CB", "LB", "RB", "LM", "CMD", "RM", "LW", "CAM", "RW", "ST", "CF" };

        JComboBox<String> positionBox = new JComboBox<>(position);
        positionBox.setBounds(150, 510, 70, 25);
        frame.add(positionLabel);
        frame.add(positionBox);

        // Competition
        JLabel competitionLabel = new JLabel("<html>Played in <br>Inter-dept:</html>");
        competitionLabel.setBounds(30, 550, 100, 35);

        JRadioButton yes = new JRadioButton("Yes");
        yes.setBounds(150, 550, 70, 35);
        JRadioButton no = new JRadioButton("No");
        no.setBounds(230, 550, 80, 35);

        ButtonGroup ansGroup = new ButtonGroup();
        ansGroup.add(yes);
        ansGroup.add(no);

        frame.add(competitionLabel);
        frame.add(yes);
        frame.add(no);

        // Experience
        JLabel experienceLabel = new JLabel("Experience:");
        experienceLabel.setBounds(30, 590, 100, 40);

        JTextArea experienceArea = new JTextArea();
        experienceArea.setBounds(150, 600, 250, 50);
        experienceArea.setLineWrap(true);
        experienceArea.setWrapStyleWord(true);

        JScrollPane scrollPane1 = new JScrollPane(experienceArea);
        scrollPane1.setBounds(150, 600, 250, 50);

        frame.add(experienceLabel);
        frame.add(scrollPane1);

        // Register Button
        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(180, 680, 90, 30);
        frame.add(registerBtn);

        registerBtn.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String address = addressArea.getText();
            String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Not selected");
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String degree = (String) degreeBox.getSelectedItem();
            String photo = selectedFilePath[0].isEmpty() ? "Not uploaded" : selectedFilePath[0];
            String positions = (String) positionBox.getSelectedItem();
            String answer = yes.isSelected() ? "Yes" : (no.isSelected() ? "No" : "Not selected");
            String experience = experienceArea.getText();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()
                    || gender.equals("Not selected") || photo.equals("Not uploaded") || answer.equals("Not selected")
                    || experience.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    String fileName = name + ".txt";
                    FileWriter writer = new FileWriter(fileName, true);
                    writer.write("----------------------------------\n");
                    writer.write("Personal information...\n\n");
                    writer.write("Name: " + name + "\n");
                    writer.write("Email: " + email + "\n");
                    writer.write("Phone: " + phone + "\n");
                    writer.write("Address: " + address + "\n");
                    writer.write("Gender: " + gender + "\n");
                    writer.write("DOB: " + dob + "\n");
                    writer.write("Degree: " + degree + "\n");
                    writer.write("Photo: " + photo + "\n\n");
                    writer.write("Game related Information...\n\n");
                    writer.write("Positions: " + positions + "\n");
                    writer.write("Plays in Inter-Dept: " + answer + "\n");
                    writer.write("Experience: " + experience + "\n");
                    writer.write("----------------------------------\n");
                    writer.close();

                    JOptionPane.showMessageDialog(frame, "Registration Saved Successfully!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    nameField.setText("");
                    emailField.setText("");
                    phoneField.setText("");
                    addressArea.setText("");
                    genderGroup.clearSelection();
                    dayBox.setSelectedIndex(0);
                    monthBox.setSelectedIndex(0);
                    yearBox.setSelectedIndex(0);
                    degreeBox.setSelectedIndex(0);
                    filePathLabel.setText("");
                    selectedFilePath[0] = "";
                    positionBox.setSelectedIndex(0);
                    ansGroup.clearSelection();
                    experienceArea.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error writing to file!", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }
}
