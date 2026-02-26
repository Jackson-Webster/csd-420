/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Jackson Webster
// 02/26/2026
// CSD 420 – Fan Database Assignment
// Purpose: Simple test code to verify database display/update methods work.


package fanapp;

/**
 *
 * @author Jackson
 */

public class FanTest {
    public static void main(String[] args) throws Exception {
        FanDAO dao = new FanDAO();

        // Test display
        Fan fan = dao.getFanById(1);
        System.out.println("Display test (ID 1): " + (fan == null ? "NOT FOUND" : fan.firstName));

        // Test update (only if record exists)
        if (fan != null) {
            String oldTeam = fan.favoriteTeam;
            fan.favoriteTeam = oldTeam + "_TEST";

            boolean updated = dao.updateFan(fan);
            System.out.println("Update test: " + updated);

            Fan verify = dao.getFanById(1);
            System.out.println("Verify team: " + (verify == null ? "NOT FOUND" : verify.favoriteTeam));
        }
    }
}
