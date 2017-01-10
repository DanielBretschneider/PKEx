/*
    Aufgabe 3) Datenrepräsentation -- Vier Gewinnt

    Fortsetzung des "Vier gewinnt" Spiels aus Aufgabenblatt 6.
     
    Auch auf diese Aufgaben werden spätere Aufgabenblätter aufbauen, Sie sollten
    sie daher unbedingt lösen.
    
    Hinweis: Sie können Hilfsmethoden implementieren.
    
    Kopieren Sie die Klassen Spielfeld und Viergewinnt, und ersetzen Sie die
    Repräsentation des Spielfeldes in der Klasse Spielfeld durch folgende:
    Das Spielfeld wird durch zwei longs repräsentiert: Im ersten long sind die
    Bits gesetzt, die den Steinen des ersten Spielers entsprechen, im zweiten
    die, die den Steinen des zweiten Spielers entsprechen. Die Nummerierung der
    Bits im Spielfeld ist wie folgt:
    
    |40 41 42 43 44 45 46|47
    |32 33 34 35 36 37 38|39
    |24 25 26 27 28 29 30|31
    |16 17 18 19 20 21 22|23
    | 8  9 10 11 12 13 14|15
    | 0  1  2  3  4  5  6| 7
    +--------------------+
    
    Wobei die bits 7, 15, 23, 31, 39, 47 keinen Feldern des Spielfelds
    entsprechen und immer auf 0 bleiben müssen.
    
    Durch diese Repräsentation kann die Überprüfung für sieg() und wert1()
    wesentlich schneller durchgeführt werden: Beachten Sie, dass der rechte
    Nachbar eine um 1 höhere Nummer hat, der Nachbar links oben eine um 7 höhere
    Nummer, der Nachbar oben eine um 8 höhere Nummer, und der Nachbar rechts
    oben eine um 9 höhere Nummer.  Wenn wir also z.B.
    
    (x>>(0*9)) & (x>>(1*9)) & (x>>(2*9)) & (x>>(3*9))
    
    berechnen, und im Resultat z.B. an Stelle 3 ein Bit gesetzt ist, heisst das,
    dass in x an Stelle 3, 12, 21, 30 ein Bit gesetzt ist und damit vier in
    einer Diagonale nach rechts oben gesetzt sind. Allgemeiner, wenn irgendein
    Bit im Resultat gesetzt ist (das Resultat also ungleich 0 ist), hat man
    irgendwo vier in einer Diagonale nach rechts oben; die achte, leere Spalte,
    sorgt dafuer, dass horizontal und diagonal keine Reihen jenseits des Randes
    fortgesetzt werden. Durch Verwenden von shifts um n*1, n*7, und n*8
    überprüfen Sie entsprechend auch horizontale Reihen, Reihen nach links oben,
    und Reihen nach oben.
    
    Für wert1() verwendet man entsprechend Ausdrücke auch mit drei und nur zwei
    Termen. Um dann für die Berechnung des Wertes die Anzahl der Reihen
    (also bits) zu zählen, kann man die Methode java.lang.Long.bitCount()
    verwenden.

    Probieren Sie für den Aufruf von spiel1() verschiedene Werte für
    tiefe aus, und wählen Sie einen, bei dem der Computer im
    Normalfall zwischen 0.1s und 1s zur Auswahl des besten Zugs
    braucht.

    Zusatzfragen:

    1) Ist spiel1() bei gleicher Tiefe durch diese Änderung schneller
    oder langsamer geworden? Um wieviel?

    2) Welche Methoden mussten Sie für diese Änderung ändern und
    welche sind gleichgeblieben?  Hätten Sie einige der geänderten
    Methoden anders schreiben können, um die Notwendigkeit von
    Änderungen zu vermeiden?  Gibt es neben den Kosten der Veränderung
    bei manchen Methoden auch Vorteile durch die Änderung?  Welche?
*/
public class Aufgabe3 {
    
    public static void main(String[] args) {
    }
}


