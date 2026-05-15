package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {

  private class Node {
    public Integer value;

    public Node left;
    public Node right;

    public Node(Integer value) {
      this.value = value;
    }
  }

  private Node root;

  public void insert(int value) {
    root = insert(root, value);
  }

  private Node insert(Node node, int value) {
    if (node == null) {
      return new Node(value);
    }

    if (value < node.value) {
      node.left = insert(node.left, value);
    } else if (value > node.value) {
      node.right = insert(node.right, value);
    }

    return node;
  }

  public void delete(int value){
    root = delete(root, value);
  }

  private Node delete(Node node, int value) {
    if(node.value < value){
      node.right = delete(node.right, value);
    }else if(root.value > value){
      node.left = delete(node.left, value);
    }else {
      node.right = node.right.right;
    }
    return node;
  }


  public void printTranversalPreorder() {
    ArrayList listOfvalue = new ArrayList<>();
    printTranversalPreorder(root, listOfvalue);

    listOfvalue.stream().map(String::valueOf).forEach(System.out::println);

  }


  private void printTranversalPreorder(Node node, ArrayList listOfvalue) {
    if  (node.value != null) {
      listOfvalue.add(node.value);
    }
    printTranversalPreorder(node.left,listOfvalue);
    printTranversalPreorder(node.right,listOfvalue);
  }

  public void printTranversalInOrder() {
    printTranversalInOrder(root);
    System.out.println();
  }

  private void printTranversalInOrder(Node node) {
    if (node == null) {
      return;
    }

    printTranversalInOrder(node.left);
    System.out.print(node.value + " ");
    printTranversalInOrder(node.right);
  }

  public void printTranversalPostOrder() {
  }

  public boolean searchDFS(int value ) {
    return searchDFS(root, value);
  }

  private boolean searchDFS(Node node, int value ) {
    if (node == null){
      return false;
    }
    if(node.value == value){
      return true;
    }
    return searchDFS(node.left, value) || searchDFS(node.right, value);
  }

  public boolean searchBFS(int value) {
    if (root == null){
      return false;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node current = queue.remove();

      if (current.value == value) {
        return true;
      }

      if (current.left != null) {
        queue.add(current.left);
      }

      if (current.right != null) {
        queue.add(current.right);
      }
    }

    return false;
  }

  public void invertBST(Node node){
    Node tempNode = node.left;
    node.left = node.right;
    node.right = tempNode;

    invertBST(node.left);
    invertBST(node.right);
  }

}
