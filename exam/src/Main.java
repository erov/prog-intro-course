import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
            Information about input:
            - 1st argument of command line - name of file with text
            - 2nd argument of command line - name of file with substrings for search

            Asymptotic:
                O(n*m), n - size of text, m - max word's length
                because of using Trie
         */

        SubstringList substr;

        try {
            substr = new Parser(args[1]).parseSubstrings();
        } catch (FileNotFoundException e) {
            System.out.println("error - file not found: " + e.getMessage());
            return;
        } catch (UnknownStringFormatException e) {
            System.out.println(e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("input error: " + e.getMessage());
            return;
        }

        Trie library = new Trie();
        Trie ignoredCaselibrary = new Trie();

        int maxLenght = 0;
        // :NOTE: - Явный перебор списка по индексу
        for (int i = 0; i < substr.size(); i++) {
            String current = substr.get(i).getWord();
            if (substr.get(i).isIgnoreCase()) {
                ignoredCaselibrary.addString(current.toLowerCase(), i);
            } else {
                library.addString(current, i);
            }
            if (current.length() > maxLenght) {
                maxLenght = current.length();
            }
        }

//        library.print();

        // :NOTE: * Массив списков
        List<Integer>[] ans = new ArrayList[substr.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new ArrayList<>();
        }

        try {
            FileSource text = new FileSource(args[0]);
            int[] buffer = new int[maxLenght];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = (char) text.nextChar();
            }
            int charId = 1;
            while (buffer[0] != -1) {
                check(buffer, library, ans, charId, false);
                check(buffer, ignoredCaselibrary, ans, charId, true);
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = i + 1 < buffer.length ? buffer[i + 1] : text.nextChar();
                }
                charId++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("error - file not found: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("input error: " + e.getMessage());
            return;
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.printf("substring number %d - '%s' (%s --ignore-case) ",
                    i + 1, substr.get(i).getWord(), substr.get(i).isIgnoreCase() ? "with" : "without");
            if (ans[i].size() == 0) {
                System.out.print("wasn't found in text");
            } else {
                System.out.printf("found at %d position(-s): ", ans[i].size());
            }
            for (Integer pos : ans[i]) {
                System.out.printf("%d ", pos);
            }
            System.out.print(System.lineSeparator());
        }
    }

    public static void check(int[] buffer, Trie library, List<Integer>[] ans, Integer charId, boolean ignored) {
        int pos = 0;
        for (int ch : buffer) {
            char current = ignored ? Character.toLowerCase((char) ch) : (char) ch;
            pos = library.go(pos, current);
            if (pos == -1) {
                break;
            }
            int id = library.getId(pos);
            if (id != -1) {
                ans[id].add(charId);
            }
        }
    }
}
