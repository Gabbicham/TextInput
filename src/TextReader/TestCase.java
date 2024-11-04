package TextReader;
import junit.TextStatistics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCase {

    @Test
    public void testAddLine_TomRad() {
        TextStatistics stats = new TextStatistics();
        boolean resultat = stats.addLine(""); // Lägger till en tom rad

        assertTrue(resultat, "Att lägga till en tom rad ska returnera true");

        assertEquals(1, stats.getLineCount(), "Antalet rader ska vara 1 efter att ha lagt till en tom rad");
        assertEquals(0, stats.getCharacterCount(), "Antalet tecken ska vara 0 för en tom rad");
        assertEquals(0, stats.getWordCount(), "Antalet ord ska vara 0 för en tom rad");
    }

    @Test
    public void testAddLine_WithSpecialCharacters() {
        TextStatistics stats = new TextStatistics();
        boolean resultat = stats.addLine("¤@#-£"); // Lägger till specialtecken

        assertTrue(resultat, "Att lägga till en rad med specialtecken ska returnera true");

        assertEquals(1, stats.getLineCount(), "Antalet rader ska vara 1 efter att ha lagt till en rad med specialtecken");
        assertEquals(5, stats.getCharacterCount(), "Antalet tecken ska vara 5 för raden '¤@#-£'");
        assertEquals(1, stats.getWordCount(), "Antalet ord ska vara 1 för raden med specialtecken");
        assertEquals("¤@#-£", stats.getLongestWord(), "Det längsta ordet ska vara '¤@#-£'");
    }

    @Test
    public void testAddLine_StopLine() {
        TextStatistics stats = new TextStatistics();
        boolean resultat = stats.addLine("stop"); // Lägger till stopp-raden

        assertFalse(resultat, "Att lägga till raden 'stop' ska returnera false");
        assertEquals(0, stats.getLineCount(), "Antalet rader ska vara 0 eftersom 'stop' inte räknas");
        assertEquals(0, stats.getCharacterCount(), "Antalet tecken ska vara 0 eftersom 'stop' inte räknas");
    }
    @Test
    public void testAddLine_SingleWord() {
        TextStatistics stats = new TextStatistics();
        boolean result = stats.addLine("hej"); // Lägg till ett enda ord

        assertTrue(result, "Att lägga till en rad med ett ord ska returnera false");
        assertEquals(1, stats.getLineCount(), "Antalet rader ska vara 1");
        assertEquals(3, stats.getCharacterCount(), "Antalet tecken ska vara 3");
        assertEquals(1, stats.getWordCount(), "Antalet ord ska vara 1");
        assertEquals("hej", stats.getLongestWord(), "Det längsta ordet ska vara 'hej'");

    }
    @Test
    public void testAddLine_MultipleWords() {
        TextStatistics stats = new TextStatistics();
        boolean result = stats.addLine("hej vännen"); // Lägg till flera ord

        assertTrue(result, "Att lägga till en rad med flera ord ska returnera true");
        assertEquals(1, stats.getLineCount(), "Antalet rader ska vara 1");
        assertEquals(10, stats.getCharacterCount(), "Antalet tecken ska vara 10");
        assertEquals(2, stats.getWordCount(), "Antalet ord ska vara 2");
        assertEquals("vännen", stats.getLongestWord(), "Det längsta ordet ska vara 'vännen'");

    }
    @Test
    public void testAddLine_MultipleSpacesBetweenWords() {
        TextStatistics stats = new TextStatistics();
        stats.addLine("hej   världen  igen"); // Flera mellanslag mellan ord

        assertEquals(1, stats.getLineCount(), "Antalet rader ska vara 1");
        assertEquals(17, stats.getCharacterCount(), "Antalet tecken ska vara 17");
        assertEquals(3, stats.getWordCount(), "Antalet ord ska vara 3");
        assertEquals("världen", stats.getLongestWord(), "Det längsta ordet ska vara 'världen'");
    }
}

