import java.util.Random;
import javax.swing.*;
// Jackson Webster
// 2/11/2026
// CSD-420
// This program uses three separate threads to generate and display random letters, numbers, and symbols in a text area. 
// Each thread outputs at least 10,000 characters, demonstrating how multiple threads can run at the same time to perform different tasks.


public class JacksonThreeThreads {

    private static JTextArea textArea = new JTextArea();

    public static void main(String[] args) {
        JFrame frame = new JFrame("JacksonThreeThreads");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);

        Thread lettersThread = new Thread(new LettersTask());
        Thread numbersThread = new Thread(new NumbersTask());
        Thread symbolsThread = new Thread(new SymbolsTask());

        lettersThread.start();
        numbersThread.start();
        symbolsThread.start();
    }

    private static synchronized void append(char c) {
        textArea.append(String.valueOf(c));
    }

    static class LettersTask implements Runnable {
        public void run() {
            Random rand = new Random();
            for (int i = 0; i < 10000; i++) {
                char c = (char) ('a' + rand.nextInt(26));
                append(c);
            }
        }
    }

    static class NumbersTask implements Runnable {
        public void run() {
            Random rand = new Random();
            for (int i = 0; i < 10000; i++) {
                char c = (char) ('0' + rand.nextInt(10));
                append(c);
            }
        }
    }

    static class SymbolsTask implements Runnable {
        public void run() {
            Random rand = new Random();
            char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
            for (int i = 0; i < 10000; i++) {
                char c = symbols[rand.nextInt(symbols.length)];
                append(c);
            }
        }
    }
}
