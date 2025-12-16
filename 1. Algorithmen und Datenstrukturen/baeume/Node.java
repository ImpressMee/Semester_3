/**
 * Knoten eines binären Suchbaums
 * mit In-Order-Vorgänger- und Nachfolgerzeigern.
 *
 * Vorlesung:
 * §4.3 Binäre Suchbäume – Optimierung mit pred/succ
 */
public class Node {

    // Schlüssel und Nutzdaten
    private int key;
    private int value;
    private int height;

    // Baumstruktur
    private Node left;
    private Node right;
    private Node dad;

    /**
     * Konstruktor
     * Initialisiert alle Zeiger mit null
     */
    public Node(int key, int value, Node dad) {
        this.key = key;
        this.value = value;

        this.left = null;
        this.right = null;
        this.dad =dad;
    }

    // -------- Getter / Setter --------

    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }

    public Node getLeft() { return left; }
    public void setLeft(Node left) { this.left = left; }

    public Node getRight() { return right; }
    public void setRight(Node right) { this.right = right; }

    public int getHeight() {return height;}
    public void setHeight(int height) { this.height = height; }

    public Node getDad() {
    return dad;
    }

    public void setDad(Node dad) {
        this.dad = dad;
    }


}
