public class Node{
  private int data;
  private Node next,prev;
  public Node(int val) {
    data = val;
  }
  public void getNext() {
    return next;
  }
  public void getPrev() {
    return prev;
  }
  public void getData() {
    return data;
  }
  public void setNext(Node next) {
    this.next = next;
  }
  public void setPrev(Node prev) {
    this.prev = prev;
  }
  public void setData(int val) {
    this.data = val;
  }

}
