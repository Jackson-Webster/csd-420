/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Jackson Webster
// 02/26/2026
// CSD 420 – Fan Database Assignment
// Purpose: This class handles database operations for retrieving and updating fan records.


package fanapp;
import java.sql.*;
/**
 *
 * @author Jackson
 */
public class FanDAO {
    private static final String URL =
        "jdbc:mysql://localhost:3306/databasedb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "student1";
    private static final String PASS = "pass";

    // Retrieves a fan record from the database based on the provided ID
    public Fan getFanById(int id) throws SQLException {
        String sql = "SELECT ID, firstname, lastname, favoriteteam FROM fans WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                return new Fan(
                        rs.getInt("ID"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("favoriteteam")
                );
            }
        }
    }

    // Updates an existing fan record in the database
    public boolean updateFan(Fan fan) throws SQLException {
        String sql = "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fan.firstName);
            ps.setString(2, fan.lastName);
            ps.setString(3, fan.favoriteTeam);
            ps.setInt(4, fan.id);

            return ps.executeUpdate() == 1;
        }
    }
}

