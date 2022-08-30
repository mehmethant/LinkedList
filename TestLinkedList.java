package LinkedList;
import org.junit.*;

import static org.junit.Assert.*;

public class TestLinkedList {
    LinkedList linkedList;

    @Before
    public void setUp(){
        linkedList = new LinkedList();
    }

    @After
    public void tearDown(){
        linkedList.clear();
        linkedList = null;
    }

    @Test
    public void testAppend(){
        assertNull(linkedList.returnHead());

        linkedList.append(5);
        assertEquals(5,linkedList.getHead());
        assertEquals(5,linkedList.getTail());
        assertEquals(1,linkedList.size());

        linkedList.append(2);
        assertEquals(2,linkedList.getTail());
        assertEquals(5,linkedList.getHead());
        assertEquals(2,linkedList.size());


        linkedList.append(4);
        assertEquals(4,linkedList.getTail());
        assertEquals(5,linkedList.getHead());
        assertEquals(3,linkedList.size());

    }

    @Test
    public void testReturnHead(){
        assertNull(linkedList.returnHead());
        linkedList.append(5);
        assertNotNull(linkedList.returnHead());
    }

    @Test
    public void testGetHead(){
        assertEquals(Integer.MIN_VALUE,linkedList.getHead());
    }

    @Test
    public void testPrepend(){
        linkedList.clear();
        linkedList.prepend(5);
        assertEquals(5,linkedList.getHead());
        linkedList.prepend(4);
        assertEquals(4,linkedList.getHead());
        assertEquals(5,linkedList.getTail());
    }

    @Test
    public void testDelete(){
        linkedList.append(1);
        linkedList.append(2);

        assertTrue(linkedList.contains(2));
        linkedList.delete(2);
        assertFalse(linkedList.contains(2));
    }

    // junit // nunit

    @Test
    public void testContains(){

        assertFalse(linkedList.contains(2));
        linkedList.append(3);
        assertTrue(linkedList.contains(3));

    }

    @Test
    public void testClear(){
        linkedList.append(5);
        assertTrue(linkedList.contains(5));
        assertNotNull(linkedList.returnHead());
        linkedList.clear();
        assertNull(linkedList.returnHead());
        assertFalse(linkedList.contains(5));
    }

    @Test
    public void testGet(){
        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(6);
        linkedList.append(3);
        linkedList.append(21);

        try {
            linkedList.get(-5);
        } catch (InvalidIndexException ignored) {

        }

        try {
            assertEquals(6,linkedList.get(2));
        } catch (InvalidIndexException ignored) {
            fail("This call should not throw an exception!");
        }
    }
    @Test

    public void testMid(){
        linkedList.prepend(4);
        linkedList.prepend(2);
        linkedList.prepend(3);
        linkedList.prepend(7);
        linkedList.prepend(5);
        linkedList.prepend(6);
        linkedList.prepend(8);
        assertEquals(7,linkedList.getMid());
        linkedList.delete(7);
        assertEquals(3,linkedList.getMid());
        linkedList.delete(5);
        assertEquals(3,linkedList.getMid());

    }

    @Test
    public void testGetTail(){
        try{
           linkedList.getTail();
           fail();
        }catch (NullPointerException ignored){

        }
        linkedList.append(5);
        linkedList.append(5);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(4);

        try{
            assertEquals(4, linkedList.getTail());
        }catch (NullPointerException e){
            fail("You fucked up!");
        }
    }

    @Test
    public void getSize(){
        assertEquals(0,linkedList.size());
        linkedList.append(1);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(7);
        linkedList.append(10);
        linkedList.append(2);

        assertEquals(6,linkedList.size());
        linkedList.delete(1);
        assertEquals(5,linkedList.size());

        linkedList.delete(5);
        assertEquals(4,linkedList.size());
        linkedList.delete(2);
        assertEquals(3,linkedList.size());

    }
}
