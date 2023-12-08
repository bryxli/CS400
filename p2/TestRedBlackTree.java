import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit test suite for the RedBlackTree.java class
 */
public class TestRedBlackTree {

    /**
     * Tests the first case of the enforceRBTreePropertiesAfterInsert() method. Ensures that the node is inserted
     * properly when uncle of node being inserted is red.
     */
    @Test
    public void testCaseOne() {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(45);
        tree.insert(26);
        tree.insert(72);
        tree.insert(18);
        if (!tree.toString().equals("[45, 26, 72, 18"))
            fail();
    }

    /**
     * Tests the second case of the enforceRBTreePropertiesAfterInsert() method. Ensures that the node is inserted
     * properly when uncle of node being inserted is black, node is a right child, and uncle is a left child.
     */
    @Test
    public void testCaseTwoRightSide() {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        if (!tree.toString().equals("[2, 1, 3]"))
            fail();
    }

    /**
     * Tests the second case of the enforceRBTreePropertiesAfterInsert() method. Ensures that the node is inserted
     * properly when uncle of node being inserted is black, node is a left child, and uncle is a right child.
     */
    @Test
    public void TestCaseTwoLeftSide() {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        if (!tree.toString().equals("[2, 1, 3]"))
            fail();
    }

    /**
     * Tests the second case of the enforceRBTreePropertiesAfterInsert() method. Ensures that the node is inserted
     * properly when uncle of node being inserted is black and on the same side as the node.
     */
    @Test
    public void testCaseThree() {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);
        if (!tree.toString().equals("[3, 1, 5]"))
            fail();
    }
}
