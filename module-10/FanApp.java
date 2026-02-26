/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
// Jackson Webster
// 02/26/2026
// CSD 420 – Fan Database Assignment
// Purpose: This program provides a GUI that allows users to display and update fan records in a MySQL database.

package fanapp;

/**
 *
 * @author Jackson
 */
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class FanApp extends JFrame {
    private final JTextField idField = new JTextField(10);
    private final JTextField firstField = new JTextField(20);
    private final JTextField lastField = new JTextField(20);
    private final JTextField teamField = new JTextField(20);

    private final JButton displayBtn = new JButton("Display");
    private final JButton updateBtn = new JButton("Update");

    private final FanDAO dao = new FanDAO();

    // Sets up the graphical user interface and button actions
    public FanApp() {
        super("Fans");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 220);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("ID:"));
        panel.add(idField);

        panel.add(new JLabel("First Name:"));
        panel.add(firstField);

        panel.add(new JLabel("Last Name:"));
        panel.add(lastField);

        panel.add(new JLabel("Favorite Team:"));
        panel.add(teamField);

        panel.add(displayBtn);
        panel.add(updateBtn);

        add(panel);

        displayBtn.addActionListener(e -> displayFan());
        updateBtn.addActionListener(e -> updateFan());
    }

    // Displays fan information in the GUI based on entered ID
    private void displayFan() {
        int id;
        try {
            id = Integer.parseInt(idField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid integer ID.");
            return;
        }

        try {
            Fan fan = dao.getFanById(id);
            if (fan == null) {
                JOptionPane.showMessageDialog(this, "No record found for ID " + id);
                firstField.setText("");
                lastField.setText("");
                teamField.setText("");
                return;
            }

            firstField.setText(fan.firstName);
            lastField.setText(fan.lastName);
            teamField.setText(fan.favoriteTeam);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    // Updates the selected fan record in the database with edited values
    private void updateFan() {
        int id;
        try {
            id = Integer.parseInt(idField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid integer ID.");
            return;
        }

        Fan fan = new Fan(
                id,
                firstField.getText().trim(),
                lastField.getText().trim(),
                teamField.getText().trim()
        );

        try {
            boolean ok = dao.updateFan(fan);
            JOptionPane.showMessageDialog(this,
                    ok ? "Record updated!" : "Update failed (ID not found).");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FanApp().setVisible(true));
    }
}
