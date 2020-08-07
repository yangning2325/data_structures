package zhan;

//使用单链表模拟栈
class Stack2{
  public static void main(String[] args){
      singleList list=new singleList(5);
      list.push(1);
      list.push(2);
      list.push(3);
      list.push(4);
      list.showlist();
      list.pop();
      list.pop();
      System.out.println("..............");
      list.showlist();
  }
}
class singleList{
  Node head=new Node(0);
  int maxSize;
  public singleList(int maxSize) {
      this.maxSize = maxSize;
  }
  void push(int n){
      Node temp=head;
      int i=0;
      while (true){
          if(temp.getNext()==null)break;
          temp=temp.getNext();
          i++;
      }
      if(i<maxSize){
      Node newnode=new Node(n);
      temp.setNext(newnode);
      }else{
          System.out.println("栈满!无法添加");
      }
  }
  void pop(){
      Node temp=head;
      if(temp.getNext()==null){
          System.out.println("栈空,无法抛出");
          return;
      }
      while (true){
          if(temp.getNext().getNext()==null)break;
          temp=temp.getNext();
      }
      temp.setNext(null);
  }
  void showlist(){
      Node temp=head.getNext();
      if(temp==null){
          System.out.println("栈空没有数据");
          return;
      }
      while (true){
          System.out.println(temp);
          temp=temp.getNext();
          if(temp==null)break;
      }

  }
}
class Node{
  private int no;
  private Node next;

  public Node(int no) {
      this.no=no;
  }

  public int getNo() {
      return no;
  }

  public void setNo(int no) {
      this.no = no;
  }

  public Node getNext() {
      return next;
  }

  public void setNext(Node next) {
      this.next = next;
  }

  @Override
  public String toString() {
      return "Node{" +
              "no=" + no +
              '}';
  }
}
