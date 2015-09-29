package testMyArrayList;

        import lesson07.MyCollection;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestMyArrayList {
    MyCollection myArrayList;

    @Before
    public void init(){
        myArrayList = new MyCollection(5);
    }

    @Test
    public void sizeTest(){
        assertEquals(5, myArrayList.size());
        assertNotEquals(1, myArrayList.size());
    }
    @Test
    public void isEmptyTest(){
        myArrayList.add(555);
        assertFalse(myArrayList.isEmpty());
    }

    @Test
    public void addTest(){
        assertEquals(5, myArrayList.size());
        myArrayList.add(55);
        assertEquals(6, myArrayList.size());
    }

    @Test
    public void containsTest(){
        myArrayList.add(2);
        assertFalse(myArrayList.contains(3));
        assertTrue(myArrayList.contains(2));
        assertTrue(myArrayList.contains(null));
    }

    @Test
    public void removeTest(){
        myArrayList.remove(2);
        assertFalse(myArrayList.contains(2));
    }

}