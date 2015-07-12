package lesson07;


public class MyCollection {

    public Object [] collection;

    public MyCollection(int i) {
        if (i >= 0) {
            this.collection = new Object[i];
        } else {
            System.out.println("Incorrect entry: " + i);
            this.collection = new Object[0];
        }
    }


    public int size(){
        return collection.length;
    }


    public boolean isEmpty(){
        return  (collection.length == 0);
    }


    public boolean contains (Object o){

        if (o == null){
            for (int i=0;i<collection.length;i++) {
                if (this.collection[i] == null){
                    return true;
                }
            }

        } else {
            for (int i=0;i<collection.length;i++) {
                if (o.equals(this.collection[i])) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean add (Object o){

        Object[] newCollection = new Object[collection.length + 1];
        System.arraycopy(collection,0,newCollection,0,collection.length);
//        for (int i = 0; i < collection.length; i++) {
//            newCollection[i] = collection[i];
//        }
        newCollection[collection.length] = o;
        collection = newCollection;
        return true;
    }


    public boolean remove (Object o){
        if (o == null){
            for (int i=0;i<collection.length;i++) {
                if (this.collection[i] == null){
                    if((collection.length-i-1)>0){
                        System.arraycopy(collection,i+1,collection,i,(collection.length-i-1));
                    }
                    collection[collection.length-1] = null;
                    return true;
                }
            }

        } else {
            for (int i=0;i<collection.length;i++) {
                if (o.equals(this.collection[i])) {
                    if((collection.length-i-1)>0){
                        System.arraycopy(collection,i+1,collection,i,(collection.length-i-1));
                    }
                    collection[collection.length-1] = null;
                    return true;
                }
            }
        }
        return false;

    }


    public void clear(){
        for (int i = 0; i<collection.length;i++){
            collection[i] = null;
        }

    }

//    public boolean addAll(MyCollection c);
//    public boolean retainAll(MyCollection c);
//    public boolean removeAll(MyCollection c);
//    public boolean containsAll(MyCollection c);

}
