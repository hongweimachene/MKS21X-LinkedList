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
    private void setNext(Node next) {
      this.next = next;
    }
    private void setPrev(Node prev) {
      this.prev = prev;
    }
    public void set(int val) {
      this.data = val;
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

  private Node getNode(int index) {
    
  }
}
