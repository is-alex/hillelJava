package mytreeset;

public class MyTreeSet <T> {

    private Node <T> root;

    public void add (T object){

        Node <T> node = new Node(object);
        add(node);

    }

    private void add (Node <T> newNode){

        if (root==null){
            root = newNode;
        }
        add (root, newNode);

    }



    private void add (Node <T> addTo, Node <T> newNode){

        T addToObject = addTo.getData();
        T newNodeObject = newNode.getData();

        Comparable addToComparable = (Comparable)addToObject;
        Comparable newNodeComparable = (Comparable)newNodeObject;


        if(addToComparable.compareTo(newNodeComparable)>0){

            if(addTo.getLeft()==null){
                addTo.setLeft(newNode);
            } else {
                add(addTo.getLeft(), newNode);
            }

        } else if (addToComparable.compareTo(newNodeComparable)<0){

            if(addTo.getRight()==null){
                addTo.setRight(newNode);
            } else {
                add(addTo.getRight(), newNode);

            }


        }


    }



    public boolean contains (T o){

        return contains(root, o);

    }


    private boolean contains (Node <T> node, T o){

        if (node==null){
            return false;
        }

        if (o==node.getData()){
            return true;
        } else if(node.compareTo(o)>0){
            return contains(node.getLeft(), o);
        } else {
            return contains(node.getRight(), o);
        }


    }



    @Override
    public String toString() {

        StringBuilder string = new StringBuilder("MyTreeSet: ");
        toString(root, string);
        string.append(".");
        return string.toString();

    }



    private void toString (Node <T> node, StringBuilder string) {

        if (node == null){
            string.append("");
        }

        if (node.getLeft()!=null){
            toString(node.getLeft(), string);
            string.append("; ");
        }

        string.append(node.data);
        if (node.getRight()!=null){
            string.append("; ");
            toString(node.getRight(), string);

        }

    }


    public T getMin(){
        return getMin(root);
    }


    private T getMin(Node <T> node){

        Node <T> thisNode = node;

        while (thisNode.getLeft() != null){
            thisNode = thisNode.getLeft();
        }
        return thisNode.data;

    }


    public T getMax(){
        return getMax(root);
    }



    private T getMax(Node <T> node){

        Node <T> thisNode = node;

        while (thisNode.getRight() != null){
            thisNode = thisNode.getRight();
        }
        return thisNode.data;

    }


    public int size() {
        return size(this.root);
    }

    private int size (Node <T> node) {

        if (node == null){
            return 0;
        }
        return (size(node.getLeft()) + 1 + size(node.getRight()));

    }


    public T floor (T o){
        return floor(root,null, o);
    }



    private T floor (Node <T> node, T floor, T o){

        if (node == null){
            return floor;
        }

        if(node.compareTo(o)>=0){
            return floor(node.getLeft(),floor,o);
        }
        return floor(node.getRight(), node.getData(), o);


    }


    public T ceiling (T o){
        return ceiling(root, null, o);
    }


    private T ceiling (Node <T> node, T ceiling, T o){

        if (node == null){
            return ceiling;
        }

        if(node.compareTo(o)>0){
            return ceiling(node.getLeft(), node.getData(), o);
        }
        return ceiling(node.getRight(), ceiling, o);

    }


    private static class Node <T> implements Comparable {

        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node (T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }


        public T getData() {
            return data;
        }

        public Node <T> getLeft() {
            return left;
        }

        public void setLeft(Node <T> left) {
            this.left = left;
        }

        public Node <T> getRight() {
            return right;
        }

        public void setRight(Node <T> right) {
            this.right = right;
        }


        @Override
        public int compareTo(Object o) {
            Comparable comparableObject;
            Comparable thisDataComparable = (Comparable)this.getData();

            try {
                comparableObject = (Comparable)o;

                if (thisDataComparable.compareTo(comparableObject)<0){
                    return -1;
                } else if (thisDataComparable.compareTo(comparableObject)>0){
                    return 1;
                }

            } catch (ClassCastException e){
                System.err.println("Exception " + e + ". Unable to compare.");
                System.exit(1);
            }

            return 0;

        }


    }


}
