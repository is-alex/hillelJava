package lesson08;

import java.util.Collection;
import java.util.Iterator;


public class MyLinkedList { // implements Iterable<Object>  {
    private int size;
    private Element first;
    private Element last;

    public MyLinkedList() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.first == null);
    }

    public boolean add (Object o) {
        Element before = this.last;
        Element after = new Element(before,o,null);
        this.last = after;
        if(before == null) {
            this.first = after;
        } else {
            before.next = after;
        }

        ++this.size;
        return true;
    }

    public boolean contains(Object o) {

        int index = 0;
        Element element;

        if(o == null) {
            for(element = this.first; element != null; element = element.next) {
                if(element.item == null) {
                    return true;
                }

                index++;
            }

        } else {
            for(element = this.first; element != null; element = element.next) {
                if(o.equals(element.item)) {
                    return true;
                }

                index++;
            }
        }

        return false;
    }
    
    
    public Object unlink (Element element){

        Object object = element.item;
        Element before = element.next;
        Element after = element.prev;

        if(after == null) {
            this.first = before;
        } else {
            after.next = before;
            element.prev = null;
        }

        if(before == null) {
            this.last = after;
        } else {
            before.prev = after;
            element.next = null;
        }

        element.item = null;
        this.size--;
        return object;
    }

    public boolean remove (Object o) {
        Element element;
        if(o == null) {
            for(element = this.first; element != null; element = element.next) {
                if(element.item == null) {
                    this.unlink(element);
                    return true;
                }
            }
        } else {
            for(element = this.first; element != null; element = element.next) {
                if(o.equals(element.item)) {
                    this.unlink(element);
                    return true;
                }
            }
        }

        return false;
    }


    public void clear() {
        Element after;
        for(Element before = this.first; before != null; before = after) {
            after = before.next;
            before.item = null;
            before.next = null;
            before.prev = null;
        }
        this.first = this.last = null;
        this.size = 0;
    }


    public void print (){
        Element element;
        System.out.print("MyLinkedList: ");

        for(element = this.first; element != null; element = element.next)   { //FIXME, NullPointerException
            System.out.print(element.item.toString() + "; ");
        }
        System.out.println();
        System.out.println("Empty:  " + isEmpty());
        System.out.println("Size is: " + size() + "\n");

    }

    public boolean addAll(Collection c) {
        for (Object o : c){
            add(o);
        }
        return true;
    }

    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    public boolean removeAll(Collection c) {
        boolean removed = false;
        for (Object o:c){
            if (remove(o)){
                removed = true;
            }
        }
        return removed;
    }

    public boolean retainAll(Collection c) {
        boolean result = false;
        MyLinkedList temp = new MyLinkedList();
        Element element = this.first;

        while (element != null) {
            if (c.contains(element.item)) {
                temp.add(element.item);
            } else {
                result = true;
            }
            element = element.next;
        }
        this.first = temp.first;
        this.size = temp.size;
        return result;
    }


    private static class Element {
        Object item;
        Element prev;
        Element next;

        public Element(Element prev, Object item, Element next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }


//    @Override
//    public Iterator<Object> iterator() {
//        return new MyLinkedListIterator(this.first);
//    }


}
