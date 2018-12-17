public class MyLinkedList{
  //class node with methods
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
    public Integer getData() {
      return data;
    }
    private void setNext(Node other) {
      next = other;
    }
    private void setPrev(Node other) {
      prev = other;
    }
    public Integer setData(int val) {
      Integer original = data;
      data = val;
      return original;
    }
  }
  private int length;
  private Node start,end;

  //default linked list is empty
  public MyLinkedList(){
    length = 0;
  }

  public int size(){
    return length;
  }

  public boolean add(int value){
    //node being added
    Node t = new Node(value);
    //special case if list is empty
    if (size() == 0) {
      start = t;
      end = t;
    //links the list with new input
    } else {
      //changes the added value into end variable
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
      s+=current.getData()+", ";
      current = current.next();
    }
    if (s.length() > 1) {
      return s.substring(0,s.length()-2)+"]";
    } else {
      return s+"]";
    }
  }

  //helper method to get node at index, private since no one should be able to see nodes
  private Node getNthNode(int index) {
    //placeholder index value
    int pos = 0;
    Node current = start;
    //the end will be null once it reaches the end
    if (current != null) {
      //checks up to the correct index
      while (pos < index) {
        current = current.next();
        pos++;
      }
    }
    return current;
  }

  public Integer get(int index) {
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    return getNthNode(index).getData();
  }

  public Integer set(int index, Integer value){
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }
    //returns original value
    Integer origin = getNthNode(index).getData();
    getNthNode(index).setData(value);
    return origin;
  }

  public boolean contains(Integer value) {
    Node current = start;
    //checks by value to end of the list
    while (current != null){
      if (current.getData() == value) {
        return true;
      }
      current = current.next();
    }
    return false;
  }

  public int indexOf(Integer value) {
    Node current = start;
    int index = 0;
    //checks by value to end of the list
    while (current != null) {
      if (current.getData() == value){
        return index;
      }
      current = current.next();
      index++;
    }
    //returns -1 if not found
    return -1;
  }

  public void add(int index, Integer value) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException();
    }
    //if add to end of list just use add(value) function
    if (index == size()) {
      add(value);
    } else {
      //node that is being shifted
      Node t = getNthNode(index);
      //node previous that has to change its next node to add the new value
      Node u = getNthNode(index).prev();
      //new node being added
      Node v = new Node(value);
      //case for adding to first index
      if (index == 0){
        //added value will be the start
        start = v;
        v.setNext(t);
        t.setPrev(v);
      } else {
        //when you add into a list you must set the previous and next to the new value
        u.setNext(v);
        v.setPrev(u);
        v.setNext(t);
        t.setPrev(v);
      }
      length++;
    }
  }

  public Integer remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }
    //node being removed
    Node t = getNthNode(index);
    //store data being removed
    Integer value = t.getData();
    //special case if removed is the first in the list and its the only value
    if(index == 0 && size() == 1) {
      start = null;
      end = null;
    //special case if first value is removed
    } else if (index == 0) {
      start = t.next();
      t.next().setPrev(null);
    //special case if removed is last in the list
    } else if (index == size() - 1) {
      end = t.prev();
      t.prev().setNext(null);
    } else {
      //value is removed by resetting the next and prev of its next and prev nodes
      t.next().setPrev(t.prev());
      t.prev().setNext(t.next());
    }
    length--;
    return value;
  }

  public boolean remove(Integer value) {
    //if the list contains the value then it will remove
    if (contains(value)) {
      //finds the index of the value and uses remove(int index)
      remove(indexOf(value));
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    MyLinkedList a = new MyLinkedList();
    System.out.println(a);
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
    a.add(0,4);
    System.out.println(a);
    System.out.println(a.set(0,5));
    System.out.println(a);
    System.out.println(a.set(7,1));
    System.out.println(a);
    a.add(7,8);
    System.out.println(a);
    System.out.println(a.remove((Integer) 1));
    System.out.println(a);
    a.add(8,10);
    System.out.println(a);
    System.out.println(a.size());
    System.out.println(a.remove(0));
    System.out.println(a);
    MyLinkedList b = new MyLinkedList();
    b.add(1);
    System.out.println(b.remove(0));
    System.out.println(b);
  }

}
