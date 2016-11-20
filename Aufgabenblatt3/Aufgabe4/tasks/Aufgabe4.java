/*
    Aufgabe 4) Verständnis Rekursion (Summenbildung)

    Vervollständigen Sie alle mit TODO
    gekennzeichneten Stellen schrittweise von oben nach unten.

*/
public class Aufgabe4{
    
    // liefert die Summe der Zahlen von 0 bis n
    // Annahme: n = 9
    public static int sum1(int n) {
        return 45;
    }
    
    // liefert die Summe der Zahlen von 0 bis n
    // Annahme: n = 10
    public static int sum2(int n) {
        if (n <= 0) return 0;
        return n + sum2(n-1);
    }
    
    // liefert die Summe der Zahlen von 0 bis n-1
    // Annahme: n >= 0
    public static int sumNMinusOne(int n) {
        return n * (n-1)/2;
    }
    
    // liefert die Summe der Zahlen von 0 bis n
    // Annahme: n >= 0
    public static int sum3(int n) {
        return sumNMinusOne(n+1);
    }
    
    // liefert für n >= 0 die Summe der Zahlen von 0 bis n;
    // für negative n soll 0 geliefert werden.
    public static int sum4(int n) {
        return (n < 0) ? 0 : sumNMinusOne(n+1);
    }
    
    // liefert für n >= 0 die Summe der Zahlen von 0 bis n;
    // für negative n soll 0 geliefert werden.
    public static int sum5(int n) {
        return (n < 0) ? 0 : n + sum5(n-1);
    }
    
    public static void main(String[] args) {
    }
}





