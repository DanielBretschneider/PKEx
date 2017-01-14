/*******************************************************************************

 AUFGABENBLATT 8 - Allgemeine Informationen

 Achten Sie bei der Implementierung auf folgende Punkte:

 - Ihr Programm sollte den dazugehörenden Test (z.B. enthält Aufgabe1Test den
 Test zu Aufgabe1) bestehen.

 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich
 thematisch auf das erstellte Programm.  Sie müssen diese Zusatzfragen in der
 Übung beantworten können.

 - Verwenden Sie bei allen Ausgaben immer System.out.println().

 Abgabe: Die Abgabe erfolgt in TUWEL. Bitte laden Sie Ihr IntelliJ-Projekt
 bis spätestens Montag 16.01.2017 08:00 Uhr in TUWEL hoch. Zusätzlich
 müssen Sie in TUWEL ankreuzen welche Aufgaben Sie gelöst haben und während
 der Übung präsentieren können.

 ******************************************************************************/
/*
	Aufgabe 1) Exception-Handling

	Verwenden Sie zur Lösung der unten angegebenen Methoden nur
	Methoden der Java API (z.B. Integer.parseInt ist erlaubt).

	1. Implementieren Sie die Methode: int stringToInt(String str), die
	den gegebenen Parameter str als int Wert zurückgibt. Sollte es sich
	bei dem Text in str nicht um eine Zahl handeln, dann soll die Methode
	eine NumberFormatException werfen.

	2. Implementieren Sie die Methode: void printStringIfInt(String str),
	die den gegebenen Parameter str auf der Konsole ausgibt, wenn es sich
	dabei um eine ganzzahlige Zahl handelt. Sollte es sich bei dem Text in
	str nicht um eine ganze Zahl handeln, dann soll die Methode den Text: "Keine
	ganze Zahl" ausgeben.

	3. Implementieren Sie die Methode: boolean conditionalString(String str).
	Diese Methode gibt true zurück, wenn alle folgende Bedingungen
	erfüllt sind:
	A) Die Länge von str ist > 0 und < 10
	B) str enthält keine der folgenden Buchstaben: x, X, y, z
	C) Wenn str länger als 5 Zeichen ist, dann muss es genau eine Zahl in str
	  geben. Diese Zahl kann aus maximal zwei Ziffern bestehen, die aber direkt
	  hintereinander stehen müssen.
	  Beispielsweise wäre: halloDu1m2 nicht gültig!

	Ist eine dieser Bedingungen nicht erfüllt dann werfen die Methoden,
	abhängig von der nicht erfüllten Bedingung, eine Exception:
	- zu A) Wird die Bedingung der Länge von str nicht erfüllt, dann wird eine
	  InvalidStringLengthException geworfen. Diese Exception gibt als
	  Beschreibung die Länge des Textes aus.
	- zu B) Werden unzulässige Buchstaben (Bedingung B)) verwendet, dann wird
	  ein InvalidCharException geworfen. Diese Exception listet als Beschreibung
	  ALLE unzulässigen verwendeten Zeichen auf.
	- zu C) Wird keine Zahl angegeben, wenn str Länger als 5 Zeichen ist, dann
	  wird eine NoNumberException geworfen. Diese Exception gibt als
	  Beschreibung die Länge des Textes aus.
	- zu C) Werden mehrere Zahlen angegeben, wird eine MultipleNumbersException
	  geworfen. Diese Exception gibt als Beschreibung die Anzahl der Ziffern der
	  längsten Zahl in str aus.

    Sind mehrere Bedingungen unerfüllt, so soll die Exception der zuerst
    gelisteten Bedingung geworfen werden."
	
	Zusatzfragen:
	1. Wie unterscheiden sich Exceptions von Rückgabenwerten?
	2. Wann ist es sinnvoller Exceptions und wann
	   Rückgabewerte einzusetzen?
	3. Wie unterscheiden sich checked von unchecked Exceptions? Nennen Sie
	  jeweils drei Beispiele für diese beiden Exceptiontypen.
	4. Wie und warum fängt man Ausnahmen ab?
*/
public class Aufgabe1 {

    /**
     * int stringToInt(String str), die
     * den gegebenen Parameter str als int Wert zurückgibt. Sollte es sich
     * bei dem Text in str nicht um eine Zahl handeln, dann soll die Methode
     * eine NumberFormatException werfen.
     *
     * @param str, String containing a number.
     * @return
     */
    public static int stringToInt(String str) {
       int num = 0;

       try {
           num = Integer.parseInt(str);
       } catch (NoNumberException nne) {
           nne.printStackTrace();
       }

       return num;
    }

    /**
     * void printStringIfInt(String str),
     * die den gegebenen Parameter str auf der Konsole ausgibt, wenn es sich
     * dabei um eine ganzzahlige Zahl handelt. Sollte es sich bei dem Text in
     * str nicht um eine ganze Zahl handeln, dann soll die Methode den Text: "Keine
     * ganze Zahl" ausgeben.
     *
     * @param str
     */
    public static void printStringIfInt(String str) {
        int num = 0;

        try {
            num = Integer.parseInt(str);
            System.out.printf("printStringIfInt: %d\n", num);
        } catch (NoNumberException nne) {
            System.out.printf("Keine ganze Zahl\n");
        }
    }

    /**
     * boolean conditionalString(String str).
     Diese Methode gibt true zurück, wenn alle folgende Bedingungen
     erfüllt sind:
     A) Die Länge von str ist > 0 und < 10
     B) str enthält keine der folgenden Buchstaben: x, X, y, z
     C) Wenn str länger als 5 Zeichen ist, dann muss es genau eine Zahl in str
     geben. Diese Zahl kann aus maximal zwei Ziffern bestehen, die aber direkt
     hintereinander stehen müssen.
     Beispielsweise wäre: halloDu1m2 nicht gültig!
     * @param str
     */
    public static boolean conditionalString(String str) throws InvalidStringLengthException, InvalidCharException, NoNumberException {
        int length = str.length();
        char[] forbiddenCharacter = {'x','X','y','z',};

        if (length > 0 && length < 10) {
            if (!containsCharacter(str, forbiddenCharacter)) {
                if (length >= 5) {
                    if (containsTwoDigitNumber(str)) {
                        return true;
                    } else {
                        throw new NoNumberException("String has to contain numbers with a length greater than 5!");
                    }
                } else if (length < 5) {
                    return true;
                }
            } else {
                char[] usedCharacter = getEvilCharacter(str);
                String evilString  = "";
                for (char currChar : usedCharacter) { evilString += currChar + ","; }
                throw new InvalidCharException(evilString);
            }
        } else {
            throw new InvalidStringLengthException(str.length());
        }

        return false;
    }

    /**
     * Checks if str contains characters from characterList.
     * If yes -> true, otherwise false.
     *
     * @param str, "Test"-String
     * @param characterList, List of Character. *surprise*
     * @return
     */
    public static boolean containsCharacter(String str, char[] characterList) {
        for (char currChar : str.toCharArray()) {
            for (char forbiddenChar : characterList) {
                if (currChar == forbiddenChar) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Wenn str länger als 5 Zeichen ist, dann muss es genau eine Zahl in str
     * geben. Diese Zahl kann aus maximal zwei Ziffern bestehen, die aber direkt
     * hintereinander stehen müssen.
     * Beispielsweise wäre: halloDu1m2 nicht gültig!
     *
     * @param str
     * @return
     */
    public static boolean containsTwoDigitNumber(String str) {
        if (str == null || str.isEmpty()) return false;

        try {
            char[] splitted = str.toCharArray();
            if (checkIfNumIsTwoDigit(splitted)) {
                for (int i = 0; i <= splitted.length; i++) {
                    if (Character.isDigit(splitted[i]) || (Character.isDigit(splitted[i]) && Character.isDigit(splitted[i++]))) {
                        return true;
                    } else {
                        continue;
                    }
                }
            }
        } catch (MultipleNumbersException mne) {
            mne.printStackTrace();
        }
        return false;
    }

    /**
     * ...Diese Zahl kann aus maximal zwei Ziffern bestehen...
     *
     * @param charArr
     * @return
     */
    private static boolean checkIfNumIsTwoDigit(char[] charArr) throws MultipleNumbersException {
        int numberCounter = 0;

        for (char currChar : charArr) {
            if (Character.isDigit(currChar)) {
                numberCounter++;
            }
        }

        if (numberCounter <= 2) {
            if (numberCounter == 1 || numberCounter == 0) {
                return true;
            } else if (numberCounter == 2) {
                for (int i = 0; i <= charArr.length; i++) {
                    if (Character.isDigit(charArr[i])) {
                        if (Character.isDigit(charArr[i++])) {
                            return true;
                        } else {
                            throw new MultipleNumbersException();
                        }
                    }
                }
            }
        } else {
            throw new MultipleNumbersException();
        }

        return false;
    }

    /**
     * Liefter alle unzulässig verwendeten Character in einem Array.
     *
     * @param str
     * @return
     */
    public static char[] getEvilCharacter(String str) {
        char[] evilCharacter = {};
        char[] splitted = str.toCharArray();
        for (int i = 0; i <= splitted.length; i++) {
            switch (splitted[i]) {
                case 'x':
                    evilCharacter = append(evilCharacter, 'x');
                    break;
                case 'X':
                    evilCharacter = append(evilCharacter, 'X');
                    break;
                case 'y':
                    evilCharacter = append(evilCharacter, 'y');
                    break;
                case 'z':
                    evilCharacter = append(evilCharacter, 'z');
                    break;
                default:
                    break;
            }
        }

        return evilCharacter;
    }

    /**
     * Append ch to list;
     *
     * @param list
     * @param ch
     * @return
     */
    public static char[] append(char[] list, char ch) {
        int len = list.length;

        if (len == 0) {
            list[0] = ch;
        } else if (len > 0) {
            list[len+1] = ch;
        }

        return list;
    }

    public static void main(String[] args) {
    }
}



