import java.io.*;

public class FileSource {
    private final BufferedReader in;

    public FileSource(String fileName) throws FileNotFoundException {
        // :NOTE: * Текстовый ввод без указания кодировки
        this.in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
    }

    public int nextChar() throws IOException {
        return in.read();
    }
}
