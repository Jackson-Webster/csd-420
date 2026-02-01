// Jackson Webster
// 2/1/2026
// Advanced Java Programming
// This program implements two generic bubble sort methods in Java: one using the Comparable interface and one using the Comparator interface.
// The main method includes test cases that demonstrate and verify both sorting approaches.

import java.util.Comparator;


public class Bubble_Sort {

    // Main method used to test and sort.
    public static void main(String[] args) {

        // Test Comparable sort
        Integer[] numbers = {4, 8, 3, 7, 10};

        bubbleSort(numbers);

        System.out.println("Sorted using Comparable:");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println("\n");

        // Test Comparator sort
        String[] words = {"Computer", "Laptop", "Xbox", "Games"};

        bubbleSort(words, Comparator.naturalOrder());

        System.out.println("Sorted using Comparator:");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    //Bubble sort that uses comparable interface
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {

        boolean swapped;

        
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;

            
            for (int j = 0; j < array.length - 1 - i; j++) {

                
                if (array[j].compareTo(array[j + 1]) > 0) {

                    
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            
            if (!swapped) {
                break;
            }
        }
    }

    //Sort using comparator
    public static <T> void bubbleSort(T[] array, Comparator<T> comp) {

        boolean swapped;

        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < array.length - 1 - i; j++) {

                
                if (comp.compare(array[j], array[j + 1]) > 0) {

                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
