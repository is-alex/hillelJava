package lesson07;


public class MyCollection {

    private Object [] collection;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object[] getCollection() {
        return collection;
    }

    public void setCollection(Object[] collection) {
        this.collection = collection;
    }



    public MyCollection() {
    }

    public MyCollection(int size) {
        this.size = size;
        if (size >= 0) {
            this.collection = new Object[size];
        } else {
            System.out.println("Incorrect entry: " + size);
            this.collection = new Object[0];
        }
    }


    public int size(){
        return this.size;
    }


    public boolean isEmpty(){
        return  (this.size == 0);
    }


    public boolean contains (Object o){

        if (o == null){
            for (int i=0;i<this.size;i++) {
                if (this.collection[i] == null){
                    return true;
                }
            }

        } else {
            for (int i=0;i<this.size;i++) {
                if (o.equals(this.collection[i])) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean add (Object o){

        Object[] newCollection = new Object[this.size+ 1];
        for (int i = 0; i < this.size; i++) {
            newCollection[i] = collection[i];
        }
        newCollection[this.size] = o;
        collection = newCollection;
        this.size++;
        return true;
    }


    public boolean remove (Object o){
        if (o == null){
            for (int i=0;i<this.size;i++) {
                if (this.collection[i] == null){
                    if((this.size-i-1)>0){
                        System.arraycopy(this.collection,i+1,this.collection,i,(this.size-i-1));
                    }
                    this.collection[this.size-1] = null;
                    this.size--;
                    return true;
                }
            }

        } else {
            for (int i=0;i<this.size;i++) {
                if (o.equals(this.collection[i])) {
                    if((this.size-i-1)>0){
                        System.arraycopy(this.collection,i+1,this.collection,i,(this.size-i-1));
                    }
                    this.collection[this.size-1] = null;
                    this.size--;
                    return true;
                }
            }
        }

        return false;

    }


    public void clear(){
        for (int i = 0; i<this.size;i++){
            this.collection[i] = null;
        }

    }


    public boolean addAll (MyCollection c) {
        for (int i = 0; i<c.size();i++) {
            add(this.collection[i]);
        }
        return true;
    }


//    public boolean removeAll(MyCollection c);
//    public boolean retainAll(MyCollection c);
//    public boolean containsAll(MyCollection c);


}
