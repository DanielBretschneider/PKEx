/*
    Aufagbe 2) Unittests

    Bei allen zukünftigen Übungsblättern, die Sie bearbeiten müssen, werden
    Tests mitgeliefert, die Ihnen dabei helfen sollen Ihr Programm
    zu testen und zu überprüfen. In dieser Aufgabe werden Sie den Umgang mit
    diesen Tests kennenlernen und üben.

    Implementieren Sie dazu an den vorgegebenen Stellen eine korrekte Anweisung,
    damit die Unittests nicht fehlschlagen und somit "richtig" zurückliefern.
*/
public class Aufgabe2{

    // Die Methode soll "true" zurückliefern wenn die Zahl "number" größer
    // gleich 10 ist, ansonsten "false".
    public static boolean retBoolean(int number) {
        if (number >= 10) {
            return true;
        } else {
            return false;
        }
    }

    // Die Methode soll 1 zurückliefern wenn die Zahl "number" größer gleich 100
    // ist, ansonsten -1.
    public static int retInteger(int number){
        if (number >= 100) {
            return 1;
        } else {
            return -1;
        }
    }

    // Die Methode soll "groß" zurückliefern wenn die Zahl "number" größer
    // gleich 100000 ist, ansonsten "klein".
    public static String retString(int number){
        if (number >= 100000) {
            return "groß";
        } else {
            return "klein";
        }
    }

    // Multiplizieren Sie die Variablen "var1" und "var2" miteinander und geben
    // Sie das Produkt mittels System.out.println() aus.
    public static void main(String[] args) {
        int var1 = 4;
        int var2 = 7;
        System.out.println(var1*var2);
    }
}

