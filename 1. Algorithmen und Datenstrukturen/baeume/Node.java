public class Node {
    private Node leftChild;
    private Node rightChild;
    private Node parent;
    private int key;
    private int value;
    
    public Node(int key, int value){
        this.value=value;
        this.key=key;
    }




    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value=value;
    }

    public int getKey(){
        return key;
    }

    public void setKey(int key){
        this.key=key;
    }

    public Node getleftChild(){
        return leftChild;
    }

    public void setleftChild(Node node){
        this.leftChild = node;
    }

    public Node getrightChild(){
        return rightChild;
    }

    public void setrightChild(Node node){
        this.rightChild = node;
    }

     public Node getParent(){
        return parent;
    }

    public void setParent(Node node){
        this.parent = node;
    }




}
