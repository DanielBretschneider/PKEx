import java.util.Stack;

/*
    Aufgabe 2) Deque - Klammerung

    Implementieren Sie in Aufgabe2 eine statische Methode check, die einen
    String als Parameter hat und genau dann true zurückgibt, wenn der String
    einen korrekt geklammerten Ausdruck enthält. Ein Ausdruck ist dann korrekt
    geklammert, wenn es zu jeder öffnenden Klammer '(', '[' oder '{' eine
    entsprechende schließende Klammer ')', ']' oder '}' gibt. Zwischen diesen
    Zeichen können beliebige andere Zeichen vorkommen.

    Beispiele für korrekt geklammerte Ausdrücke:
    "", "a*[a+12]", "a+(b)-c", "a+{b+8+(b+c)}/a"
    Beispiele für nicht korrekt geklammerte Ausdrücke:
    "[", "(}", "a)[]", "([)]", "]["

    Verwenden Sie einen Stack zur Überprüfung der Klammerung: Durchlaufen Sie
    die Zeichen im String von vorne nach hinten und legen Sie jede öffnende
    Klammer, die Sie dabei finden, auf den Stack. Wenn Sie auf eine schließende
    Klammer stoßen, nehmen Sie das oberste Element vom Stack; bei korrekter
    Klammerung muss die schließende Klammer mit der Klammer vom Stack
    zusammenpassen. Andere Zeichen werden einfach ignoriert. Bei korrekter
    Klammerung muss der Stack am Ende leer sein.

    Hinweis: Sie können als Stack z.B. ein Objekt des Typs Deque<String>
    verwenden.

    Zusatzfragen:
    1. Was unterscheidet Queue von Map?
    1. Was ist der Unteschied zwischen LIFO und FIFO Prinzip?
    2. Wie könnte man diese Aufgabe auch mit einem Array statt einem Stack
       lösen? Welche Nachteile würden sich daraus ergeben?
*/
public class Aufgabe2 {

    /**
     *
     * @param expression
     * @return
     */
    public static boolean check(String expression) {
        Stack<Character> stack = new Stack<Character>();
        char currCharacter;

        for (int i = 0; i < expression.length(); i++) {
            currCharacter = expression.charAt(i);

            if (currCharacter == '[' || currCharacter == '{' ||currCharacter == '(') {
                stack.push(currCharacter);
            } else if (currCharacter == ']' || currCharacter == '}' ||currCharacter == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    switch (currCharacter) {
                        case ']':
                            if (stack.pop() != '[') {
                                return false;
                            }
                            break;

                        case '}':
                            if (stack.pop() != '{') {
                                return false;
                            }
                            break;

                        case ')':
                            if (stack.pop() != '(') {
                                return false;
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(check("a*[a+12]"));
        System.out.println(check("(a)*[a+12]"));
        System.out.println(check("(}"));
        System.out.println(check(""));
    }
}

