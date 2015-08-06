package lesson08;

import java.util.*;


public class MyLinkedList <T> implements Collection <T> {

    private int size;
    private Element <T> first;
    private Element <T> last;

    private T head;

    public MyLinkedList() {
        this.size = 0;
    }

    public T getHead() {
        head = first.item;
        return head;
    }

    public MyLinkedList getTail() {

        this.unlink(first);
        return this;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.first == null);
    }

    public boolean add (T o) {
        Element before = this.last;
        Element after = new Element(before, o, null);
        this.last = after;

        if(before == null) {
            this.first = after;
        } else {
            before.next = after;
        }

        this.size++;
        return true;
    }

    @Override
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


    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size];
        int size = 0;

        for(Element element = this.first; element != null; element = element.next) {
            arr[size++] = element.item;
        }

        return arr;
    }


    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];                   //TODO
    }

    public T unlink (Element <T> element){

        T object = element.item;
        Element next = element.next;
        Element prev = element.prev;

        if(prev == null) {
            this.first = next;
        } else {
            prev.next = next;
            element.prev = null;
        }

        if(next == null) {
            this.last = prev;
        } else {
            next.prev = prev;
            element.next = null;
        }

        element.item = null;
        this.size--;
        return object;
    }

    @Override
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

    @Override
    public boolean equals(Object o) {
        return (this == o);
    }


    public void print (){
        Element element;
        for(element = this.first; element != null; element = element.next)   {
            if (element.item==null){
                System.out.print("null; ");
            } else {
                System.out.print(element.item.toString() + "; ");
            }
        }
        System.out.println();


    }

        @Override
        public boolean addAll(Collection c) {

        Object[] o = c.toArray();
        int objectLength = o.length;
        if((objectLength == 0)) {
            return false;
        } else {
            Element prev;
            prev = this.last;

            Object[] temp1 = o;

            for(int i = 0; i < o.length; i++) {
                Object newObject = temp1[i];
                Element el = new Element(prev, newObject, null);
                if(prev == null) {
                    this.first = el;
                } else {
                    prev.next = el;
                }

                prev = el;
            }

            this.last = prev;

            this.size += objectLength;

            return true;
        }
    }


    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean removed = false;
        for (Object o:c){
            if (remove(o)){
                removed = true;
            }
        }
        return removed;
    }

    @Override
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

    public void printBackwards (){
        Element element;
        for(element = this.last; element != null; element = element.prev) {if (element.item==null){System.out.print("null; ");
            } else { System.out.print(element.item.toString() + "; ");
            }
        }
    }


    @Override
    public Iterator iterator() {
        return new MyLinkedListIterator(first);
    }


    private static class MyLinkedListIterator implements Iterator<Object> {
        private Element currentElement;

        public MyLinkedListIterator(Element element) {
            this.currentElement = element;
        }

        @Override
        public boolean hasNext() {
            return currentElement != null;
        }

        @Override
        public Object next() {
            Object toReturn = currentElement.item;
            currentElement = currentElement.next;
            return toReturn;
        }

    }


    private static class Element <T> {
        T item;
        Element <T> prev;
        Element <T> next;

        public Element(Element <T> prev, T item, Element<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }

}
