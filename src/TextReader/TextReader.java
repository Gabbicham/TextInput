package TextReader;

import org.w3c.dom.Text;

import java.util.Scanner;


public class TextReader{
    public TextStatistics stats;
    public Scanner scanner;

    public TextReader() {
        stats = new TextStatistics();
        scanner = new Scanner(System.in);
    }

    // Starta med att mata in och avslutar på "stop"
    public void startReading() {
        System.out.println("Skriv text rad för rad. Skriv 'stop' för att avsluta:");

        while (true) {
            String line = scanner.nextLine();
            if (!stats.addLine(line)) {  // Avslutar om raden är "stop"
                break;
            }
        }

        // Utskrift av resultatet
        System.out.println("Antal rader (exklusive 'stop'): " + stats.getLineCount());
        System.out.println("Antal tecken: " + stats.getCharacterCount());
    }

    public TextStatistics getStats() {
        return stats;
    }

    public Scanner getScanner() {
        return scanner;
    }

    // Main-metod för att starta programmet
    public static void main(String[] args) {
        TextReader reader = new TextReader();
        reader.startReading();
        System.out.println("Programmet har avslutats.");
    }
}

// klassen för statistik
class TextStatistics {
    private int lineCount = 0;
    private int characterCount = 0;

    public boolean addLine(String line) {
        if ("stop".equalsIgnoreCase(line)) {
            return false;
        }
        lineCount++;
        characterCount += line.length();
        return true;
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }
}
