public class MyLinkedList{
  private class Node{
    private Integer data;
    private Node next,prev;
    public Node(int val) {
      data = val;
    }
    private Node next() {
      return next;
    }
    private Node prev() {
      return prev;
    }
    public Integer value() {
      return data;
    }
    private void setNext(Node other) {
      next = other;
    }
    private void setPrev(Node other) {
      prev = other;
    }
    public void set(int val) {
      data = val;
    }
  }
  private int length;
  private Node start,end;

  public MyLinkedList(){
    length = 0;
  }
  public int size(){
    return length;
  }

  public boolean add(int value){
    Node t = new Node(value);
    if (size() == 0) {
      start = t;
      end = t;
    } else {
      end.setNext(t);
      t.setPrev(end);
      end = t;
    }
    length++;
    return true;
  }

  public String toString(){
    Node current = start;
    String s = "";
    while(current!=null){
      s+=current.value()+", ";
      current = current.next();
    }
    return s.substring(0,s.length()-2);
  }

  private Node getNthNode(int index) {
    int pos = 0;
    Node current = start;
    if (current != null) {
      while (pos < index) {
        current = current.next();
        pos++;
      }
    }
    return current;
  }

  public Integer get(int index) {
    return getNthNode(index).value();
  }

  public Integer set(int index, Integer value){
    getNthNode(index).set(value);
    return value;
  }

  //private Node getNode(int index) {

  //}
}
