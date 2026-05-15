package test;

import static org.junit.Assert.assertTrue;

import model.Tree;
import org.junit.Test;

public class TreeTest {

  @Test
  public void insertAddsValueToTree() {
    Tree tree = new Tree();

    tree.insert(10);
    tree.insert(5);
    tree.insert(15);

    assertTrue(tree.searchDFS(10));
    assertTrue(tree.searchDFS(5));
    assertTrue(tree.searchDFS(15));
  }
}
