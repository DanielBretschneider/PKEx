import java.util.Queue;

/**
 * Created by me on 28.11.16.
 */
public class Adhoc6 {

    private void setup() {
        Disco1 u4 = new Disco1("U4", 4);
        u4.enter("Falco");
        u4.enter("Herbert");
        u4.enter("Kurt");
        u4.enter("Fiona");

        u4.enter("Fiona");

        u4.leave("Herbert");
        u4.leave("Kurt");
        u4.leave("Fiona");
        u4.leave("Hausmeister");


        Disco1 flex = new Disco1("Flex", 50);
        flex.enter("Falco");
        flex.enter("Herbert");

        flex.leave("Falco");
        flex.leave("Herbert");
        flex.leave("Kurt");
        flex.leave("Fiona");
        flex.leave("Hausmeister");
    }

    public static void main(String[] args) {
        new Adhoc6().setup();
    }
}

class Disco1 {
    private String name;
    private int capacity;
    private int numOfGuests = 0;
    private Queue<String> warteschlange;

    public Disco1(String name, int capactity) {
        this.name = name;
        this.capacity = capactity;
    }

    public boolean enter(String guest) {
        if (numOfGuests < capacity) {
            numOfGuests++;
            System.out.printf("[enter]: Gast <%s> wurde ins %s reingelasssen.\n", guest, name);
            return true;
        } else {
            checkCapacity(guest);
            System.out.printf("[enter]: Gast <%s> wurde vom %s abgewiesen.\n", guest, name);
            warteschlange.add(guest);
            return false;
        }
    }

    public void leave(String guest) {
        if (numOfGuests != 0) {
            numOfGuests--;
            System.out.printf("[leave]: Gast <%s> hat %s verlassen.\n", guest, name);
        } else {
            System.out.printf("[leave]: %s ist leer.\n", name);
        }
    }

    private void checkCapacity(String guest) {
        if (numOfGuests < capacity) {
            enter(guest);
            warteschlange.poll();
            System.out.printf("[checkCapacity]: Gast <%s> wurde reingelassen.", guest);
        } else {
            System.out.printf("[checkCapacity]: Gast <%s> muss noch warten.", guest);
        }
    }
}
