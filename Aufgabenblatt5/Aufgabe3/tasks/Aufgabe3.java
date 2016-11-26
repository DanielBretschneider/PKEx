/*
    Aufgabe 3, 4, 5) Zweidimensionale Arrays -- Vier Gewinnt

    Fortsetzung des "Vier gewinnt" Spiels aus Aufgabenblatt 4. Kopieren Sie
    sich dazu die Methoden spielfeld(), spielstand(), zug(), und sieg() aus
    Aufgabenblatt 4, um die weiteren Funktionalitäten in diesem Aufgabenblatt
    zu lösen.

    Auch auf diese Aufgaben werden spätere Aufgabenblätter aufbauen, Sie sollten
    sie daher unbedingt lösen. In diesem Aufgabenblatt deckt das Spiel
    "Vier gewinnt" 3 Aufgaben ab. Bitte kreuzen Sie diese separat in TUWEL an.
    
    Hinweis: Sie können Hilfsmethoden implementieren.
    
    *****************************  Aufgabe 3  **********************************
    Für Aufgabe 3 schreiben Sie folgende statische Methoden:

    1) public static int wert1(int[][] f, int spieler)
    
    Diese Methode nimmt eine naive* Stellungsbewertung der Position von Spieler
    "spieler" vor: Es zählt die Zweier-Reihen, Dreier-Reihen, und Vierer-Reihen
    aus Steinen des Spielers "spieler". Der zurückgegebene Wert ist
    1*z+100*d+10000*v, wobei z die Zahl der Zweier-Reihen, d die Zahl der
    Dreier-Reihen, und v die Zahl der Vierer-Reihen ist.
    
    *) Eine einigermassen gute Stellungsbewertung würde den Rahmen der
    Übung sprengen.
    
    Für die Stellung
    
    |       |
    |       |
    |       |
    |  o    |
    |  xo   |
    |  oxoxx|
    +-------+
    
    ist die Bewertung für Spieler 1 (x) 1*2=2 und fuer Spieler 2 (o)
    1*3+100*1=103.  Eine Dreier-Reihe zählt also auch noch als
    zwei Zweier-Reihen.

    2) public static int wert(int[][] f, int spieler)
    
    Die Methode bezieht den wert1() des Gegners in die Bewertung mit ein: Vier
    gewinnt ist (wie die meisten Brettspiele) ein Null-Summen-Spiel
    (Spieler 1 gewinnt, wenn Spieler 2 verliert, und umgekehrt), daher
    soll wert() die Differenz von wert1() des Spielers und wert1() des
    Gegners zurückgeben, im obigen Beispiel also -101 für Spieler 1 (oder
    101 für Spieler 2).
    ****************************************************************************
    
    *****************************  Aufgabe 4  **********************************
    Für Aufgabe 4 schreiben Sie folgende statische Methoden:

    1) public static int negamax(int[][] f, int spieler, int tiefe)
    
    Eine bessere Stellungsbewertung kann man aus wert() ableiten, indem
    man einige Halbzüge vorausschaut. Bei einem Halbzug Vorausschau
    bewertet man die Stellung, die sich bei jedem der 7 möglichen Züge
    ergibt, wie folgt: Der Spieler, der am Zug ist, wird den für ihn
    besten Zug auswählen, der Wert der ursprünglichen Stellung ist also
    das Maximum der Werte der sieben möglichen Folgestellungen. Wenn man
    das für mehrere Halbzüge verallgemeinert, muss man nach jedem Halbzug
    die Seite wechseln, und für den Spieler, der dann am Zug ist, das
    Maximum berechnen. Um diesen Wert dann als Bewertung fuer den anderen
    (vorherigen) Spieler zu verwenden, muß man ihn negieren. Dieser
    Algorithmus heißt "Negamax".

    Diese rekursive Methode "negamax" führt eine Stellungsbewertung für Spieler
    "spieler" mit "tiefe" Zügen Vorausschau durch. Bei 0 Zügen Vorausschau soll
    die Bewertung wert() verwendet werden.
    
    Für diese Methode benötigen Sie eine Möglichkeit, Züge zu probieren,
    ohne sich darauf festzulegen, entweder indem Sie den alten Wert von f
    erhalten, oder indem Sie nach dem Probieren den Zug wieder
    zurücknehmen.  Wenn nötig, modifizieren Sie existierende Methoden
    und/oder implementieren Sie Hilfsmethoden, um das zu erreichen.

    2) public static int bester(int[][] f, int spieler, int tiefe)

    Diese Methode wählt den besten Zug aus. Alle 7 möglichen Züge
    werden durchprobiert, und die sich dadurch ergebende Stellung f1 wird mit
    Hilfe von negamax() bewertet (beachten Sie, welcher Spieler am Zug
    ist). Der Rückgabewert ist ein Zug mit maximaler Bewertung.
    
    Zusatzfragen:
    1. Was sind die Vor- und Nachteile der von Ihnen gewählten
       Art, nach dem Probieren wieder zum vorherigen Zug zu kommen?
    2. Ermitteln Sie durch Ausprobieren und ungefähre Zeitmessung, wie der
       Zeitaufwand von bester() mit der Tiefe zusammenhängt.
    3. Wieviele Aufrufe von wert() werden höchstens ausgeführt, wenn man
       bester() mit Tiefe 0, 1, 2, 8 und n aufruft?
    ****************************************************************************

    *****************************  Aufgabe 5  **********************************
    Für Aufgabe 5 schreiben Sie folgende statische Methode:

    1) public static void spiel1(int tiefe)

    Diese Methode führt ein Vier-Gewinnt-Spiel Spieler gegen Computer durch:
    Zunächst sucht sich der Spieler aus, ob er beginnt oder der Computer. Wenn
    der Computer am Zug ist ist, wählt er den nächsten Zug mit bester(...,
    tiefe) aus und führt ihn durch.  Abgesehen davon macht spiel1() das
    gleiche wie spiel(). Probieren Sie verschiedene Werte für tiefe aus,
    und wählen Sie einen, bei dem der Computer im Normalfall zwischen 0.1s
    und 1s zur Auswahl des besten Zugs braucht. Testen Sie die Methode,
    indem Sie gegen den Computer spielen.
    ****************************************************************************
*/
import java.util.Scanner;
public class Aufgabe3 {

    //***************************  Aufgabe 3  **********************************
    public static int wert1(int[][] f, int spieler){
        // TODO: Implementieren Sie hier die Angabe
        return -1; //diese Anweisung ändern oder löschen.
    }
    
    public static int wert(int[][] f, int spieler){
        // TODO: Implementieren Sie hier die Angabe
        return -1; //diese Anweisung ändern oder löschen.
    }
    //**************************************************************************
    
    
    //***************************  Aufgabe 4  **********************************
    public static int negamax(int[][] f, int spieler, int tiefe){
        // TODO: Implementieren Sie hier die Angabe
        return -1; //diese Anweisung ändern oder löschen.
    }
    
    
    public static int bester(int[][] f, int spieler, int tiefe){
        // TODO: Implementieren Sie hier die Angabe
        return -1; //diese Anweisung ändern oder löschen.
    }
    //**************************************************************************
    
    
    //***************************  Aufgabe 5  **********************************
    public static void spiel1(int tiefe){
        // TODO: Implementieren Sie hier die Angabe
    }
    //**************************************************************************
    
    public static void main(String[] args) {
    }
    
}

