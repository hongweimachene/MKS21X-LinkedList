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

  public boolean contains(Integer value) {
    Node current = start;
    while (current != null){
      if (current.value() == value) {
        return true;
      }
      current = current.next();
    }
    return false;
  }
  public int indexOf(Integer value) {
    Node current = start;
    int index = 0;
    while (current != null) {
      if (current.value() == value){
        return index;
      }
      current = current.next();
      index++;
    }
    return -1;
  }
  public void add(int index, Integer value) {
    Node t = getNthNode(index);
    Node u = getNthNode(index).prev();
    Node v = new Node(value);
    u.setNext(v);
    v.setPrev(u);
    v.setNext(t);
    t.setPrev(v);
  }

  public boolean remove(int index) {
    Node t = getNthNode(index);
    t.next().setPrev(t.prev());
    t.prev().setNext(t.next());
    return true;
  }

}
