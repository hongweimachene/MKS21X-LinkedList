public class MyLinkedList{
  private class Node{
    private Integer data;
    private Node next,prev;
    public Node(int val) {
      data = val;
    }
    public Node next() {
      return next;
    }
    public Node prev() {
      return prev;
    }
    public Integer value() {
      return data;
    }
    public void setNext(Node next) {
      this.next = next;
    }
    public void setPrev(Node prev) {
      this.prev = prev;
    }
    public void set(int val) {
      this.data = val;
    }

  }
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
  }
  public int size(){
    return size;
  }

  public boolean add(int value){
    Node t = new Node(value);
    if (size == 0) {
      start = t;
    }
    if (size == 1) {
      end = t;
      start.setNext(end);
      end.setPrev(start);
    } else {
      end.setNext(t);
      t.setPrev(end);
      end = t;
    }
    size++;
  }
  public String toString(){
    Node current = start;
    String s = "";
    while(current!=null){
      s+=current.value()+", ";
      current = current.next();
    }
    return s;
  }
}
