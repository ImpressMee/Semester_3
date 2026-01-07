/**
 * Unbalancierter binärer Suchbaum.
 * Entspricht exakt der Vorlesung §4.3.
 */
public class Baum {

    public Node wurzel = null;

    // -------------------------------------------------
    // INSERT
    // -------------------------------------------------

    /**
     * Aufgabe 7.1
     */
    public boolean insert(int key, int value, Node p) {

        if (p == null) {
            wurzel = new Node(key, value, null);
            return true;
        }

        if (key < p.getKey()) {
            if (p.getLeft() == null) {
                p.setLeft(new Node(key, value, p));
                return true;
            }
            return insert(key, value, p.getLeft());
        }

        if (key > p.getKey()) {
            if (p.getRight() == null) {
                p.setRight(new Node(key, value, p));
                return true;
            }
            return insert(key, value, p.getRight());
        }

        return false;
    }


    // -------------------------------------------------
    // SEARCH
    // -------------------------------------------------

    /**
     * Aufgabe 7.3
     * Rekursive Suche nach key.
     */

    public boolean search(Node p, int key, Rueckgabe rueckgabe) {

        if (p == null) return false;

        if (key < p.getKey())
            return search(p.getLeft(), key, rueckgabe);

        if (key > p.getKey())
            return search(p.getRight(), key, rueckgabe);

        rueckgabe.value = p.getValue();
        return true;
    }

    // -------------------------------------------------
    // REMOVE
    // -------------------------------------------------

    /**
     * Aufgabe 7.4
     * Rekursives Löschen eines Knotens.
     */
    public Node remove(int key, Node p) {

        if (p == null) return null;

        if (key < p.getKey()) {
            p.setLeft(remove(key, p.getLeft()));
        }
        else if (key > p.getKey()) {
            p.setRight(remove(key, p.getRight()));
        }
        else {
            // Knoten gefunden

            // Fall: 0 oder 1 Kind
            if (p.getLeft() == null&&p.getRight() == null) return p=null;
            if (p.getLeft() == null) return p.getRight();
            if (p.getRight() == null) return p.getLeft();

            // Fall: 2 Kinder → ersetze durch Minimum rechts
            Node min = searchMin(p.getRight());
            p.setKey(min.getKey());
            p.setValue(min.getValue());
            p.setRight(remove(min.getKey(), p.getRight()));
        }
        // Wenn knoten nicht gefunden nächstes child
        return p;
    }

    // -------------------------------------------------
    // MINIMUM
    // -------------------------------------------------

    /**
     * Hilfsfunktion: Suche nach minimalem Schlüssel.
     */
    private Node searchMin(Node p) {
        if (p.getLeft() == null) {
            return p;
        } else {
            return searchMin(p.getLeft());
        }
    }

    // -------------------------------------------------
    // TRAVERSIERUNG
    // -------------------------------------------------

    /**
     * Aufgabe 7.2
     */
    public void PreOrder(Node p) {
        if (p == null) return;
        bearbeite(p);
        PreOrder(p.getLeft());
        PreOrder(p.getRight());
    }

    /**
     * Aufgabe 7.2 
     */
    public void InOrder(Node p) {
        if (p == null) return;
        InOrder(p.getLeft());
        bearbeite(p);
        InOrder(p.getRight());
    }

    /**
     * Aufgabe 7.2
     */
    public void PostOrder(Node p) {
        if (p == null) return;
        PostOrder(p.getLeft());
        PostOrder(p.getRight());
        bearbeite(p);
    }

    public void bearbeite(Node p){
        System.out.println("(" + p.getKey() + ", " + p.getValue() + ")");
    }


    // -------------------------------------------------
    // CLEAR ALL
    // -------------------------------------------------

    public void clear() {
    clearRec(wurzel);
    wurzel = null;
    }

    private void clearRec(Node p) {
        if (p == null) return;

        clearRec(p.getLeft());
        clearRec(p.getRight());

        p.setLeft(null);
        p.setRight(null);
        p.setDad(null);
    }


}
