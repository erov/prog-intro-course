public class Substring {
    private final String word;
    private final boolean ignoreCase;

    public Substring(String word, boolean ignoreCase) {
        this.word = word;
        this.ignoreCase = ignoreCase;
    }

    public String getWord() {
        return word;
    }

    public boolean isIgnoreCase() {
        return ignoreCase;
    }
}
