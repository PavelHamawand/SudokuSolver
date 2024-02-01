package bst;


import static org.junit.jupiter.api.Assertions.assertEquals; 

import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class BstTest {
    private BinarySearchTree<Integer> intBST;
    private BinarySearchTree<String> stringBST; 

    @BeforeEach
    void setUp(){
        intBST = new BinarySearchTree<Integer>();
        stringBST = new BinarySearchTree<String>();
    }

    @AfterEach
    void tearDown(){
        intBST = null; 
        stringBST = null; 
    }

    @Test
    void testHeight(){
        for (int i = 0; i < 10; i++){
            intBST.add(i);
            stringBST.add(String.valueOf(i));
        }
        assertEquals(10, stringBST.height(), "Fel längd!");
        assertEquals(10, intBST.height(), "fel längd!");
    }

    @Test
    void testAdd(){
            intBST.add(30);
            stringBST.add("20");
            assertEquals(false, intBST.add(30), "Fel, la till en dubblett");
            assertEquals(false, stringBST.add("20"), "Fel, la till en dubblett");
            assertEquals(true, intBST.add(10), "returnar inte true vid tillägg");
            assertEquals(true, stringBST.add("10"), "returnar inte true vid tillägg");
    }

    @Test
    void testSize(){
        assertEquals(0, intBST.size(), "Storleken är inte 0");
        assertEquals(0, stringBST.size(), "Storleken är inte 0");
        for(int i = 0; i < 5; i++){
            intBST.add(i);
            stringBST.add(String.valueOf(i));
        }
        assertEquals(5, intBST.size(), "Storleken är inte 5");
        assertEquals(5, stringBST.size(), "Storleken är inte 5");

    }

    @Test
    void testClear(){
        for(int i = 0; i < 5; i++){
            intBST.add(i);
            stringBST.add(String.valueOf(i));
        }
        intBST.clear();
        stringBST.clear();
        assertEquals(0, intBST.size(), "Storleken är inte 0");
        assertEquals(0, stringBST.size(), "Storleken är inte 0");
        assertEquals(null, intBST.root, "roten är inte null");
        assertEquals(null, stringBST.root, "roten är inte null");
    }
}