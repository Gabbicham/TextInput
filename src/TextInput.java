import java.util.Scanner;

public class TextInput {
    public final TextStatistics stats;
    public final Scanner scanner;

    public TextInput() {
        stats = new TextStatistics();
        scanner = new Scanner(System.in);
    }

    // Starta inläsning av text
    public void startReading() {
        System.out.println("Skriv text rad för rad. Skriv 'stop' för att avsluta:");

        while (true) {
            String line = scanner.nextLine();
            if (!stats.addLine(line)) {  // Input slutas när man anger "stop"
                break;
            }
        }

        // Utskrift av resultat
        System.out.println("Antal rader (exklusive 'stop'): " + stats.getLineCount());
        System.out.println("Antal tecken: " + stats.getCharacterCount());
        System.out.println("Antal ord: " + stats.getWordCount());
        System.out.println("Längsta ordet: " + stats.getLongestWord());
    }

    // Main-metod för att starta programmet
    public static void main(String[] args) {
        TextInput reader = new TextInput();
        reader.startReading();
        System.out.println("Programmet har avslutats.");
    }
}

// Klassen för hantera textstatisik
class TextStatistics {
    public int lineCount = 0;
    public int characterCount = 0;
    public int wordCount = 0;
    public String longestWord = "";

    public boolean addLine(String line) {
        if ("stop".equalsIgnoreCase(line)) {
            return false; // Stop input
        }
        lineCount++;
        characterCount += line.length(); // räknar tecken inklusive spaces


        updateWordCountAndLongestWord(line);
        return true;
    }

    private void updateWordCountAndLongestWord(String line) {
        // Delar upp raden ord med hjälp av spaces som avgränsare
        String[] words = line.trim().split("\\s+");


        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;

                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
                else if  (word.length() == longestWord.length()) {
                    longestWord = word+ longestWord;  }
            }
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public String getLongestWord() {
        return longestWord.isEmpty() ? "Inga ord angivna" : longestWord;
    }
}



