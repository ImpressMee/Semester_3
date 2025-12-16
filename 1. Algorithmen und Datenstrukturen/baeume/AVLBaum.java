/**
 * AVL-Baum – balancierter binärer Suchbaum
 * Aufgabe 7.5
 */
public class AVLBaum {

    public Node wurzel = null;

    // -------------------------------------------------
    // HILFSFUNKTIONEN
    // -------------------------------------------------

    private int getHeight(Node p) {
        if (p == null) {
            return -1;
        } else {
            return p.getHeight();
        }
    }

    private void updateHeight(Node p) {
        int leftHeight = getHeight(p.getLeft());
        int rightHeight = getHeight(p.getRight());

        if (leftHeight > rightHeight) {
            p.setHeight(leftHeight + 1);
        } else {
            p.setHeight(rightHeight + 1);
        }
    }

    private int getBalance(Node p) {
        return getHeight(p.getRight()) - getHeight(p.getLeft());
    }

    // -------------------------------------------------
    // ROTATIONEN
    // -------------------------------------------------

    private void rotateRight(Node p) {
        Node q = p.getLeft();
        Node parent = p.getDad();

        p.setLeft(q.getRight());
        if (q.getRight() != null) {
            q.getRight().setDad(p);
        }

        q.setRight(p);
        p.setDad(q);

        q.setDad(parent);
        if (parent == null) {
            wurzel = q;
        } else if (parent.getLeft() == p) {
            parent.setLeft(q);
        } else {
            parent.setRight(q);
        }

        updateHeight(p);
        updateHeight(q);
    }


    private void rotateLeft(Node p) {
        Node q = p.getRight();
        Node parent = p.getDad();

        p.setRight(q.getLeft());
        if (q.getLeft() != null) {
            q.getLeft().setDad(p);
        }

        q.setLeft(p);
        p.setDad(q);

        q.setDad(parent);
        if (parent == null) {
            wurzel = q;
        } else if (parent.getLeft() == p) {
            parent.setLeft(q);
        } else {
            parent.setRight(q);
        }

        updateHeight(p);
        updateHeight(q);
    }

    private void rotateLeftRight(Node p) {
        rotateLeft(p.getLeft());
        rotateRight(p);
    }

    private void rotateRightLeft(Node p) {
        rotateRight(p.getRight());
        rotateLeft(p);
    }

    private void balanceNode(Node p) {

        updateHeight(p);
        int bf = getBalance(p);

        if (bf == -2) {     // linkslastig
            if (getBalance(p.getLeft()) <= 0) { //A1
                rotateRight(p);
            } else {                            //A2
                rotateLeftRight(p);      
            }
        }

        if (bf == 2) {      //rechtslastig
            if (getBalance(p.getRight()) >= 0) {    //B1
                rotateLeft(p);
            } else {                                //B2
                rotateRightLeft(p);
            }
        }
    }

    // -------------------------------------------------
    // INSERT
    // -------------------------------------------------

    public boolean insert(int key, int value, Node p)
    {
        boolean result;

        if (p == null) {
            wurzel = new Node(key, value, null);
            wurzel.setHeight(0);   // Blatt hat Höhe 0
            return true;
        }

        if (key < p.getKey()) {

            if (p.getLeft() == null) {
                p.setLeft(new Node(key, value, p));
                p.getLeft().setHeight(0);
                result = true;
            } else {
                result = insert(key, value, p.getLeft());
            }

        }
        else if (key > p.getKey()) {

            if (p.getRight() == null) {
                p.setRight(new Node(key, value, p));
                p.getRight().setHeight(0);
                result = true;
            } else {
                result = insert(key, value, p.getRight());
            }

        }
        else {
            result = false;   // key existiert
        }

        if (result) {
            balanceNode(p);  // NUR bei Erfolg balancieren
        }

        return result;
    }


    // -------------------------------------------------
    // SEARCH
    // -------------------------------------------------

    public boolean search(int key, Rueckgabe rueckgabe) {
        return searchRec(wurzel, key, rueckgabe);
    }

    private boolean searchRec(Node p, int key, Rueckgabe rueckgabe) {

        if (p == null) {
            return false;
        }

        if (key < p.getKey()) {
            return searchRec(p.getLeft(), key, rueckgabe);
        }

        if (key > p.getKey()) {
            return searchRec(p.getRight(), key, rueckgabe);
        }

        rueckgabe.value = p.getValue();
        return true;
    }

    // -------------------------------------------------
    // REMOVE
    // -------------------------------------------------
    public boolean remove(int key, Node p) {

        boolean result;

        if (p == null) {
            return false;
        }

        if (key < p.getKey()) {
            result = remove(key, p.getLeft());
            if (result) {
                balanceNode(p);
            }
            return result;
        }

        if (key > p.getKey()) {
            result = remove(key, p.getRight());
            if (result) {
                balanceNode(p);
            }
            return result;
        }

        // -------- Knoten gefunden --------

        if (p.getRight() == null && p.getLeft()==null) {
            Node parent = p.getDad();
            
            if (parent.getLeft() == p) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            return true;
        }

        // Fall: kein linkes Kind
        if (p.getLeft() == null) {
            copyNode(p, p.getRight());
            balanceNode(p);
            return true;
        }

        // Fall: kein rechtes Kind
        if (p.getRight() == null) {
            copyNode(p, p.getLeft());
            balanceNode(p);
            return true;
        }

        // Fall: zwei Kinder
        Node min = searchMin(p.getRight());
        p.setKey(min.getKey());
        p.setValue(min.getValue());

        remove(min.getKey(), p.getRight());
        balanceNode(p);

        return true;
    }


    private void copyNode(Node target, Node source) {

        if (source == null) {
            target.setKey(0);
            target.setValue(0);
            target.setLeft(null);
            target.setRight(null);
            target.setHeight(0);
            return;
        }

        target.setKey(source.getKey());
        target.setValue(source.getValue());
        target.setLeft(source.getLeft());
        target.setRight(source.getRight());
        target.setHeight(source.getHeight());
    }



    // -------------------------------------------------
    // MINIMUM
    // -------------------------------------------------

    public Node searchMin(Node p) {
        if (p.getLeft() == null) {
            return p;
        } else {
            return searchMin(p.getLeft());
        }
    }

    // -------------------------------------------------
    // TRAVERSIERUNGEN
    // -------------------------------------------------

    public void PreOrder(Node p) {
        if (p == null) return;
        bearbeite(p);
        PreOrder(p.getLeft());
        PreOrder(p.getRight());
    }

    public void InOrder(Node p) {
        if (p == null) return;
        InOrder(p.getLeft());
        bearbeite(p);
        InOrder(p.getRight());
    }

    public void PostOrder(Node p) {
        if (p == null) return;
        PostOrder(p.getLeft());
        PostOrder(p.getRight());
        bearbeite(p);
    }

    private void bearbeite(Node p) {
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
