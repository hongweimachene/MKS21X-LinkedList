public class Node{
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
