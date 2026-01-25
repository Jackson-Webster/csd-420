//Jackson Webster
//1/25/2026
//Advanced Java Programming 
//This program reads words from a text file, removes any duplicate words, and stores them in alphabetical order. 
//It then displays the words in both ascending and descending order to make sure the program works correctly.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class File_Reader {

    public static Set<String> readWords() throws FileNotFoundException {
        Set<String> words = new TreeSet<>();
        File file = new File("collection_of_words.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        scanner.close();
        return words;
    }

    public static void main(String[] args) {
        try {
            Set<String> words = readWords();

            // Ascending order
            System.out.println("Ascending Order:");
            for (String word : words) {
                System.out.println(word);
            }

            // Descending order
            System.out.println("\nDescending Order:");
            for (String word : ((TreeSet<String>) words).descendingSet()) {
                System.out.println(word);
            }

            // Test code
            if (!words.isEmpty()) {
                System.out.println("\nTest Passed");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Test Failed: File not found");
        }
    }
}
