package mytreeset;

public class MyTreeSet {

    private Node root;

    public void add (Object object){

        Node node = new Node(object);
        add(node);

    }

    private void add (Node newNode){

        if (root==null){
            root = newNode;
        }
        add (root, newNode);

    }



    private void add (Node addTo, Node newNode){

        Object addToObject = addTo.getData();
        Object newNodeObject = newNode.getData();

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



    public boolean contains (Object o){

        return contains(root, o);

    }


    private boolean contains (Node node, Object o){

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



    private void toString (Node node, StringBuilder string) {

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


    public Object getMin(){
        return getMin(root);
    }


    private Object getMin(Node node){

        Node thisNode = node;

        while (thisNode.getLeft() != null){
            thisNode = thisNode.getLeft();
        }
        return thisNode.data;

    }


    public Object getMax(){
        return getMax(root);
    }



    private Object getMax(Node node){

        Node thisNode = node;

        while (thisNode.getRight() != null){
            thisNode = thisNode.getRight();
        }
        return thisNode.data;

    }


    public int size() {
        return size(this.root);
    }

    private int size (Node node) {

        if (node == null){
            return 0;
        }
        return (size(node.getLeft()) + 1 + size(node.getRight()));

    }


    public Object floor (Object o){
        return floor(root,null, o);
    }



    private Object floor (Node node, Object floor, Object o){

        if (node == null){
            return floor;
        }

        if(node.compareTo(o)>=0){
            return floor(node.getLeft(),floor,o);
        }
        return floor(node.getRight(), node.getData(), o);


    }


    public Object ceiling (Object o){
        return ceiling(root, null, o);
    }


    private Object ceiling (Node node, Object ceiling, Object o){

        if (node == null){
            return ceiling;
        }

        if(node.compareTo(o)>0){
            return ceiling(node.getLeft(), node.getData(), o);
        }
        return ceiling(node.getRight(), ceiling, o);

    }


    private static class Node implements Comparable {

        private Object data;
        private Node left;
        private Node right;

        public Node(Object data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }


        public Object getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
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
