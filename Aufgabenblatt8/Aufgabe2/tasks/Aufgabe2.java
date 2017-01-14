
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
/*
    Aufgabe 2) Eingabe und Ausgabe mit Dateien

    Es soll ein Textfile "Geschichte.txt" geöffnet und eingelesen werden.
    Durchsuchen Sie das File nach sogenannten Palindromen (z.b. Hannah, Otto,
    etc.), also Wörtern die von vorn und von hinten gelesen dasselbe ergeben.
    Implementieren Sie dazu eine statische Methode "searchPalindrome(...)", die
    als Argumente die Filenamen für die Ein- und Ausgabe übergeben bekommt.
    Schreiben Sie alle gefundenen Palindrome in die Datei "Palindrome.txt".
    Zusätzlich geben Sie alle Palindrome mit System.out.println(...) aus (in der
    Reihenfolge in der diese im File auftreten).

    Erstellen Sie zusätzlich (unabhängig von Palindromen) eine Statistik über
    alle vorkommenden Buchstaben (auch Umlaute bzw. ein scharfes ß sollen, falls
    vorhanden, aufgelistet werden).
    Groß- und Kleinbuchstaben werden nicht unterschieden. Implementieren Sie
    dazu eine statische Methode "generateStatistic(...)" und geben Sie die
    Ergebnisse in folgender Form aus:
    Buchstabe - Gesamt (Wie oft kommt Buchstabe vor)
    z.B.:   a - 17
            b - 3
            c - 2
            ...

    Zusatzfragen:
    1. Was ist der Unterschied zwischen ungepufferten und gepufferten
       Datenströmen?
    2. Was ist der Unterschied zwischen FileInputStream und FileReader?
*/
public class Aufgabe2 {

    /**
     * Es soll ein Textfile "Geschichte.txt" geöffnet und eingelesen werden.
     * Durchsuchen Sie das File nach sogenannten Palindromen (z.b. Hannah, Otto,
     * etc.), also Wörtern die von vorn und von hinten gelesen dasselbe ergeben.
     * Implementieren Sie dazu eine statische Methode "searchPalindrome(...)", die
     * als Argumente die Filenamen für die Ein- und Ausgabe übergeben bekommt.
     * Schreiben Sie alle gefundenen Palindrome in die Datei "Palindrome.txt".
     * Zusätzlich geben Sie alle Palindrome mit System.out.println(...) aus (in der
     * Reihenfolge in der diese im File auftreten).
     *
     * @param inFileName
     * @param outFileName
     */
    public static void searchPalindrome(String inFileName, String outFileName){
        String fileContent = getFileContent(inFileName);
        String palindroms = "";

        String[] words = fileContent.split(" ");
        for (String word : words) {
            word = word.trim();
            if (isPalindrom(word)) {
                palindroms += word + ";";
                System.out.println(word);
            }
        }

        writeToFile(palindroms, outFileName);
    }

    /**
     * Liefter den Inhalt einer Datei (str: filename).
     *
     * @param filename
     * @return
     */
    public static String getFileContent(String filename) {
        String content = null;
        File file = new File("Aufgabe2/tasks/" + filename);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return content;
    }

    /**
     * Erkennt Palindrome.
     *
     * @param str
     * @return
     */
    public static boolean isPalindrom(String str) {
        int n = str.length();
        for( int i = 0; i < n/2; i++ )
            if (str.charAt(i) != str.charAt(n-i-1)) return false;
        return true;
    }

    /**
     * Schreibt die Palindrome in die "Output"-Datei.
     *
     * @param palindroms
     * @param filename
     */
    public static void writeToFile(String palindroms, String filename) {
        try{
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            String[] words = palindroms.split(";");
            for (String palindrom : words) {
                writer.println(palindrom);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Erstellen Sie zusätzlich (unabhängig von Palindromen) eine Statistik über
     * alle vorkommenden Buchstaben (auch Umlaute bzw. ein scharfes ß sollen, falls
     * vorhanden, aufgelistet werden).
     * Groß- und Kleinbuchstaben werden nicht unterschieden. Implementieren Sie
     * dazu eine statische Methode "generateStatistic(...)" und geben Sie die
     * Ergebnisse in folgender Form aus:
     * Buchstabe - Gesamt (Wie oft kommt Buchstabe vor)
     * z.B.:   a - 17
     * b - 3
     * c - 2
     *...
     *
     * @param inFileName
     */
    public static void generateStatistic(String inFileName){
        String letters = "abcdefghijklmnopqrstuvwxyzäöüß";
        char[] charList = letters.toCharArray();
        String fileContent = getFileContent(inFileName);
        fileContent = fileContent.replaceAll("\\s+","").toLowerCase();
        char[] contentAsCharArray = fileContent.toCharArray();

        for (char searchCharacter : charList) {
            System.out.println(searchCharacter + " - " + countCharacter(searchCharacter, contentAsCharArray));
        }
    }

    /**
     * Liefert das vorkommen eines bestimmten Zeichen...
     *
     * @param ch
     * @param content
     * @return
     */
    public static int countCharacter(char ch, char[] content) {
        int occurrenceOfCharacter = 0;

        for (char currChar : content) {
            if (currChar == ch) {
                occurrenceOfCharacter++;
            }
        }

        return occurrenceOfCharacter;
    }
    
    public static void main(String[] args) {
    }
}

