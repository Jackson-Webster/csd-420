//Jackson Webster
//12/13/2025
//Advanced Java Programming
//This file reads the .dat file that has the integers and doubles save to it.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadDatFile {
    
    //Reads the .dat file.
    public static void main(String[] args) {
        
        File file = new File ("Jacksondatafile.dat");
        
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            
            scanner.close();
        }catch (FileNotFoundException e) {
            System.out.println("The file could not be found.");
        }
    }
}