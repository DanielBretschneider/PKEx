/*
    Aufgabe 3, 4, 5,) Zweidimensionale Arrays -- Vier Gewinnt

    Beim Spiel "Vier gewinnt" gewinnt der Spieler, der als erstes vier Steine
    in eine Reihe bringt (horizontal, vertikal, oder diagonal). Das Spielfeld
    steht senkrecht und ist 7 Spalten breit und 6 Reihen hoch. Steine können nur
    im untersten Feld einer Spalte platziert werden, das noch nicht von einem
    anderen Stein besetzt ist.

    "Vier gewinnt" wird in mehreren, aufeinander aufbauenden Aufgaben in
    mehreren Aufgabenblättern verwendet, Sie sollten daher diese Aufgaben
    unbedingt lösen. In diesem Aufgabenblatt deckt das Spiel "Vier gewinnt"
    3 Aufgaben ab. Bitte kreuzen Sie diese separat in TUWEL an.

    Hinweis: Sie können Hilfsmethoden implementieren, dürfen aber vorgegebene
             Methoden und deren Signaturen nicht verändern.

    *****************************  Aufgabe 3  **********************************
    Für Aufgabe 3 schreiben Sie folgende statische Methoden:

    1) public static int[][] spielfeld()

    Diese Methode erzeugt ein leeres Vier-Gewinnt-Spielfeld. Das Spielfeld soll
    als zweidimensionales Array von int-Werten dargestellt werden, wobei auf
    ein Feld in Reihe r und Spalte s im Feld f mit f[r][s] zugegriffen werden
    soll. Ein leeres Feld wird mit 0 repraesentiert, ein Stein auf einem Feld
    durch 1 für einen Stein des Spielers 1 bzw. 2 für einen Stein des
    Spielers 2.

    2) public static void spielstand(int[][] f)

    Diese Methode gibt den Spielstand f in folgender Form aus:

    |       |
    |       |
    |       |   Definition: Die linke unterste Ecke ist als Koordinate [0][0]
    |       |               definiert und stellt den Ausgangspunkt des
    |  xo   |               Spielbrettes dar.
    |  ox   |
    +-------+

    wobei für ein leeres Feld ein Leerzeichen ausgegeben wird, für einen Stein
    von Spieler 1 ein x, und für einen Stein von Spieler 2 ein o.

    Zusatzfragen:
    1. Welche anderen Möglichkeiten neben der von Ihnen gewählten gibt es, um
    von der Spielernummer auf x bzw. o zu kommen?
    ****************************************************************************

    *****************************  Aufgabe 4  **********************************
    Für Aufgabe 4 schreiben Sie folgende statische Methoden:

    1) public static int[][] zug(int[][] f, int spieler, int spalte)

    Diese Methode führt einen Zug des Spielers "spieler" in Spalte
    "spalte" (0-6 für legale Züge) durch und gibt die neue Stellung
    (das Spielfeld nach dem Zug) zurück.  Wenn in Spalte "spalte" kein
    Zug möglich ist (weil die Spalte voll ist oder nicht im erlaubten
    Bereich), soll zug() null zurückgeben.  Das vom Parameter f
    referenzierte Feld darf verändert werden oder unverändert bleiben.

    2) public static boolean sieg(int[][] f, int spieler)

    Diese Methode liefert true, wenn "spieler" vier Steine in einer Reihe hat,
    sonst false.

    Zusatzfragen:
    1. Welche Vor- und Nachteile hat es für dieses Beispiel und in
    Hinblick auf Aufgabe 5, den Parameter f von zug() zu verändern.
    ****************************************************************************

    *****************************  Aufgabe 5  **********************************
    Für Aufgabe 5 schreiben Sie folgende statische Methode:

    1) public static void spiel()

    Diese Methode führt ein Vier-Gewinnt-Spiel zwischen zwei Spielern durch:
    Beginnend mit einem leeren Spielfeld werden abwechselnd Spieler 1 und
    Spieler 2 zur Eingabe eines Spielzuges aufgefordert, der Spielzug
    durchgeführt, und der aktuelle Spielstand ausgegeben, solange bis ein
    Spieler gewonnen hat oder das Spielfeld voll ist. Überlegen Sie sich
    eine sinnvolle Behandlung von ungültigen Eingaben. In "main" wird am Ende
    nur noch die Methode spiel() aufgerufen. Testen Sie spiel() selbst, auch
    den Fall, dass das Spielfeld voll wird, ohne dass ein Spieler gewonnen hat.

    Zusatzfragen:
    1. Was machen Sie bei ungültigen Eingaben?
    ****************************************************************************
*/
import java.util.Scanner;
public class Aufgabe3 {

    //***************************  Aufgabe 3  **********************************
    public static int[][] spielfeld(){
        int field[][] = new int[6][7];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = 0;
            }
        }

        return field;
    }

    public static void spielstand(int[][] f){
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                if (j == 0) System.out.print("|");
                switch (f[i][j]) {
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("x");
                        break;
                    case 2:
                        System.out.print("o");
                        break;
                }
                if (j == f[0].length-1) System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("+-------+");
    }

    //**************************************************************************


    //***************************  Aufgabe 4  **********************************
    public static int[][] zug(int[][] f, int spieler, int spalte) {
        for (int i = f.length-1; i > 0; i--) {
            for (int j = f[0].length-1; j > 0; j--) {
                if (f[i][spalte] == 0) {
                    f[i][spalte] = spieler;
                    return f;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public static boolean sieg(int[][] f, int spieler) {
        return (checkHorizontal(f, spieler) ? true : checkVertical(f, spieler) ? true : false);
    }

    public static boolean checkHorizontal(int[][] f, int spieler) {
        for (int i = f.length-1; i > 0; i--) {
            for (int j = f[0].length-1; j > 0; j--) {
                if (f[i][j] == spieler) {
                    for (int k = j; j < f[0].length-j; k++) {
                        int sum = 1;
                        if (f[i][k] == spieler && f[i][k-1] == spieler) {
                            if (sum == 4) return true;
                            sum++;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkVertical(int[][] f, int spieler) {
        int sum = 1;

        for (int i = f.length-1; i > 0; i--) {
            for (int j = f[0].length-1; j > 0; j--) {
                if (f[i][j] == spieler) {
                    for (int k = j; j < f.length-j; k++) {
                        if (f[k][j] == spieler && f[k-1][j] == spieler) {
                            System.out.println(sum);
                            if (sum == 4) return true;
                            sum++;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    //**************************************************************************


    //***************************  Aufgabe 5  **********************************
    public static void spiel(){
        /* initialisze playing field */
        int[][] field = spielfeld();
        int input = 0;


        while (sieg(field, 1) == false && sieg(field, 2) == false) {
            input = getUserInput(1);
            field = zug(field, 1, input);
            spielstand(field);
            if (sieg(field,1) == true || sieg(field, 2) == true) return;
            input = getUserInput(2);
            field = zug(field, 2, input);
            spielstand(field);
        }

    }

    public static int getUserInput(int spieler) {
        Scanner scanner = new Scanner(System.in);
        int uInput = 0;
        System.out.printf("[P%d] Enter column number [0-6]: ", spieler);
        uInput = scanner.nextInt();
        System.out.println();
        return uInput;
    }

    //**************************************************************************

    public static void main(String[] args) {
        spiel();
    }
}
