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
    public Integer set(int val) {
      Integer original = data;
      data = val;
      return original;
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
    String s = "[";
    while(current!=null){
      s+=current.value()+", ";
      current = current.next();
    }
    return s.substring(0,s.length()-2)+"]";
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
    Integer origin = getNthNode(index).value();
    getNthNode(index).set(value);
    return origin;
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

  public Integer remove(int index) {
    Node t = getNthNode(index);
    Integer value = t.value();
    if(size() == 1) {
      start = null;
      end = null;
    }
    if (size() == 2) {
      t.prev().setNext(null);
    } else {
      t.next().setPrev(t.prev());
      t.prev().setNext(t.next());
    }
    length--;
    return value;
  }

  public boolean remove(Integer value) {
    Node t = getNthNode(indexOf(value));
    if(size() == 1) {
      start = null;
      end = null;
    }
    if (size() == 2) {
      t.prev().setNext(null);
    }
    if (t == end) {
      end = t.prev();
      
    } else {
      t.next().setPrev(t.prev());
      t.prev().setNext(t.next());
    }
    return true;
  }

  public static void main(String[] args) {
    MyLinkedList a = new MyLinkedList();
    System.out.println();
    a.add(1);
    System.out.println(a);
    a.add(13);
    System.out.println(a);
    System.out.println(a.size());
    System.out.println(a.indexOf(13));
    a.add(15);
    a.add(5);
    a.add(7);
    a.add(9);
    a.add(6);
    System.out.println(a);
    System.out.println(a.remove(1));
    System.out.println(a);
    a.add(2);
    System.out.println(a);
    a.add(1,4);
    System.out.println(a);
    System.out.println(a.contains(15));
    System.out.println(a.contains(86));
    System.out.println(a.indexOf(17));
    System.out.println(a.indexOf(2));
    System.out.println(a.remove((Integer) 5));
    System.out.println(a);
    System.out.println(a.size());
    System.out.println(a.get(0));
    System.out.println(a.set(0,3));
    System.out.println(a);
  }

}
