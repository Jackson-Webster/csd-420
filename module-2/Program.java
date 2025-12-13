//Jackson Webster
//12/13/2025
//Advanced Java Programming
//This program writes 5 random integers and 5 random doubles to a file and saves them there.

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        writeIntegers();
        writeDoubles();
    }    
    //Writes the integers  
    public static void writeIntegers() {
        Random random = new Random();
        int[] integers = new int[5];
        
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("Jacksondatafile.dat"));

            for (int i = 0; i < integers.length; i++) {
                integers[i] = random.nextInt(100);
                
            }

            for (int i = 0; i < integers.length; i ++) {
                writer.println(integers[i]);
            }
            
            writer.close();
            System.out.println("5 random Integers saved to Jacksondatafile.dat");
        
        }catch (IOException e) {
            System.out.println("An error occured.");
        }
    
    
    }
    //Writes the doubles
    public static void writeDoubles() {
        Random random = new Random();
        double[] doubles = new double[5];
        
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("Jacksondatafile.dat", true));

            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = random.nextDouble() * 100;
                }

            for (int i = 0; i < doubles.length; i ++) {
                writer.println(doubles[i]);
            }
            
            writer.close();
            System.out.println("5 random Doubles saved to Jacksondatafile.dat");
        
        }catch (IOException e) {
            System.out.println("An error occured.");
        }
    
    
    }
}