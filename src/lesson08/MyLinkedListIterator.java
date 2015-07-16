//package lesson08;
//
//
//import java.util.Iterator;
//
//public class MyLinkedListIterator implements Iterator<Object> {
//    private MyLinkedList.Element currentElement;
//
//    public MyLinkedListIterator(MyLinkedList.Element element) {
//        this.currentElement = element;
//    }
//
//    @Override
//    public boolean hasNext() {
//        return currentElement != null;
//    }
//
//    @Override
//    public Object next() {
//        Object o = currentElement.item;
//        currentElement = currentElement.next;
//        return o;
//    }
//
//    public Object prev() {
//        Object o = currentElement.item;
//        currentElement = currentElement.prev;
//        return o;
//    }
//}
