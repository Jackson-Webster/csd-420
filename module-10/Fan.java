/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Jackson Webster
// 02/26/2026
// CSD 420 – Fan Database Assignment
// Purpose: This class represents a Fan object that stores fan information from the database.

package fanapp;

/**
 *
 * @author Jackson
 */

// Constructor to initialize a Fan object
public class Fan {
    
    public int id;
    public String firstName;
    public String lastName;
    public String favoriteTeam;

    public Fan(int id, String firstName, String lastName, String favoriteTeam) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteTeam = favoriteTeam;
    }
}

