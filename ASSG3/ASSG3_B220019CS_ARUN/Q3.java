import java.util.*;

public class Q3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Queue queue = new Queue();

    String input = sc.nextLine();
    String[] operations = input.split(" ");

    for(int i = 0; i < operations.length; i++) {
      if (operations[i].equals("E")) {
        int num = Integer.parseInt(operations[i + 1]);
        queue.enqueue(num);
        i++;
      } else if (operations[i].equals("D")) {
        try {
          queue.dequeue();
        } catch (QueueException e) {
          System.out.println(e.getMessage());
        }
      }
    }

    sc.close();
  }
}

class Queue{
  private LinkedList<Integer> queue;

  public Queue() {
    this.queue = new LinkedList<>();
  }

  public void enqueue(int element) {
    queue.addLast(element); 
    System.out.print("Success ");
  }

  public void dequeue() throws QueueException {
    if (queue.isEmpty()) {
      throw new QueueException("EmptyQueue");
    }
    System.out.print(queue.removeFirst());
    System.out.print(" ");
  }
}

class QueueException extends Exception {
  public QueueException(String message) {
      super(message);
  }
}