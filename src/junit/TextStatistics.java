package junit;

public record TextStatistics() {
    public boolean addLine(String s) {
        return false;
    }

    public int getLineCount() {
        return 0;
    }

    public int getCharacterCount() {
        return 0;
    }

    public int getWordCount() {
        return 0;
    }

    public String getLongestWord() {
        return null;
    }
}
