public class Baum {

    /**public boolean insert(int key, int value, Node node){
     * Fügt eine neue Zahl key rekursiv in Ihre Datenstruktur ab dem Knoten node ein und
     * liefert true im Erfolgsfall und false sonst.
     * @param key
     * @param value
     * @param node
     * @return
     */

    public Node wurzel = null;

    public boolean insert(int key, int value, Node node){
        Node keyNode = new Node(key, value);
        if(node == null){ // ist die Wurzel leer
            System.out.println("No node");
            wurzel = keyNode;
            return true;
        }
            
        if (node.getKey() >= key) {
            //Wenn links noch kein Kind ist
            if (node.getleftChild()== null) {
                node.setleftChild(keyNode);
                keyNode.setParent(node);
                return true;
            }else{
                //linkemn Pfad folgen
                insert(key, value, node.getleftChild());
            }
        }else{
            //Wenn rechts noch kein Kind ist
            if (node.getrightChild() == null) {
                node.setrightChild(keyNode);
                keyNode.setParent(node);
                return true;
            }else{
                //rechtem Pfad folgen
                insert(key, value, node.getrightChild());
            }
        }

        return false;
    }


    /**
     * void PreOrder (node)
        void InOrder (node)
        void PostOrder(node)
        Gibt die Einträge des Suchbaumes ab dem 
        Knoten node in Pre-Order, In-Order und PostOrder-Reihenfolge aus.
     * @param pointer
     */

    public void print(Node pointer){
        System.out.println("( key : " + pointer.getKey() + ", value : " + pointer.getValue()+")\n");
    }

    public void PreOrder(Node pointer){

        if(pointer != null){
            print(pointer);
            PreOrder(pointer.getleftChild());
            PreOrder(pointer.getrightChild());
        }
    }

    public void InOrder(Node pointer){
        if(pointer != null){
            InOrder(pointer.getleftChild());
            print(pointer);
            InOrder(pointer.getrightChild());
        }
    }

    public void PostOrder(Node pointer){
        if(pointer != null){
            PostOrder(pointer.getleftChild());
            PostOrder(pointer.getrightChild());
            print(pointer);
        }
    }

    /**
     *  bool search(key, value, node)
        Sucht die Zahl key rekursiv in der Datenstruktur 
        ab dem Knoten node und liefert im Erfolgsfall true (und false sonst) 
        und in value die Nutzerdaten des Knotens.
     */

    public boolean search(int key, Rueckgabe value, Node node){
        if (node == null) return false;

        if (key < node.getKey()) {
            return search(key, value, node.getleftChild());
        }
        if (key > node.getKey()) {
            return search(key, value, node.getrightChild());
        }

        value.value = node.getValue();
        return true;
    }

    public Node searchMin(Node node){
        if (node.getleftChild() == null) return node;
        return searchMin(node.getleftChild());
    }

    public Node remove(Node node, int key) {
        if (node == null) return null;

        if (key < node.getKey()) {
            node.setleftChild(remove(node.getleftChild(), key));
        }
        else if (key > node.getKey()) {
            node.setrightChild(remove(node.getrightChild(), key));
        }
        else {
            // 0 oder 1 Kind
            if (node.getleftChild() == null) {
                return node.getrightChild();
            }
            else if (node.getrightChild() == null) {
                return node.getleftChild();
            }

            // 2 Kinder → Minimum aus rechtem Teilbaum
            Node min = searchMin(node.getrightChild());
            node.setKey(min.getKey());
            node.setValue(min.getValue());

            node.setrightChild(remove(node.getrightChild(), min.getKey()));
        }

        return node;
    }



}

class Rueckgabe{
    public int value;
    
}
