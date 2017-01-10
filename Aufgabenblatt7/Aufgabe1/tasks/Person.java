import java.util.ArrayList;

public class Person {
    private String vorname;
    private String nachname;
    private String geschlecht;
    private int alter;
    private int svnr;
    private ArrayList<Person> kinder = new ArrayList<Person>();

    /**
     * Constructor.
     *
     * @param vorname
     * @param nachname
     * @param geschlecht
     * @param alter
     * @param svnr
     * @param kinder
     */
    public Person(String vorname, String nachname, String geschlecht, int alter, int svnr, ArrayList<Person> kinder) {
            this.vorname = vorname;
            this.nachname = nachname;
            this.geschlecht = geschlecht;
            this.alter = alter;
            this.svnr = svnr;
            this.kinder = kinder;
    }

    /**
     * hashcode
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;

        hash = hash + 12 * alter;
        hash = hash + 11 * svnr;
        hash = hash + 10 * vorname.hashCode();
        hash = hash +  9 * nachname.hashCode();

        return hash;
    }

    /**
     * Add an entry to "kinder"-list.
     *
     * @param p, somebody's child
     */
    public void neuesKind(Person p) {
        if (equals(p)) {
            System.err.printf("Person %s %s mit SVNr. %d existiert bereits.\n",
                    p.vorname, p.nachname, p.svnr);
        } else {
            kinder.add(p);
        }
    }

    /**
     * Checks if person already exists.
     *
     * @param p
     * @return
     */
    public boolean equals(Person p) {
        String vn = p.vorname;
        String nn = p.nachname;
        int   svn = p.svnr;

        for (Person children : kinder) {
            if (children.vorname.equals(vn) && children.nachname.equals(nn) && children.svnr == svn) {
                return true;
            } else if (children.hashCode() == p.hashCode()) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    /**
     * Outup of persons information.
     *
     * @return # <Vorname> <Nachname>, <Geschlecht>, <Alter> Jahre, Svnr: <Sozialversicherungsnummer>
     */
    @Override
    public String toString() {
        if (hasKids()) {
            System.out.println(String.format("# %s %s, %s, %d Jahre, Svnr.: %4d", vorname, nachname, geschlecht, alter, svnr));
            outputKids();
            return "";
        } else {
            return String.format("# %s %s, %s, %d Jahre, Svnr.: %4d", vorname, nachname, geschlecht, alter, svnr);
        }
    }

    /**
     * Outputs child elements recursively.
     */
    private void outputKids() {
        System.out.print(" ");
        /* load last element */
        Person p = kinder.get(kinder.size()-1);

        /* print it out */
        System.out.println(" " + p.toString());

        /* delete last element */
        kinder.remove(kinder.size()-1);

        /* if list size > 0, do it again */
        if (kinder.size() > 0) {
            outputKids();
        }
    }

    /**
     * True, when p has kids, false if not.
     *
     * @return
     */
    private boolean hasKids() {
        if (kinder.size() >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
