import java.util.*;

public class Q5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> inputList = new ArrayList<String>();

    // Sensor sensor1 = new Sensor("temperature");
    // Sensor sensor2 = new Sensor("humidity");

    for(int i = 0; i < 2; i++) {
      inputList.add(sc.nextLine());
    }

    Sensor sensor1 = new Sensor(inputList.get(0));
    Sensor sensor2 = new Sensor(inputList.get(1));    

    sensor1.display();
    sensor2.display();

    // sensor1.toggle();

    // sensor1.display();
    // sensor2.display();
  }
}

class Sensor {
  private String sensorId;
  private String sensorType;
  private boolean isActive;

  public Sensor(String sensorType) {
      this.sensorType = sensorType;
      this.isActive = true;
      this.sensorId = generateUniqueId();
  }

  private String generateUniqueId() {
      Random RANDOM = new Random();
      int id = RANDOM.nextInt((int) Math.pow(10, 10));
      return String.format("%0" + 10 + "d", id);
  }

  public void display() {
      System.out.println("sensorId: " + sensorId);
      System.out.println("sensorType: " + sensorType);
      System.out.println("isActive: " + isActive);
      System.out.println(); 
  }

  public void toggle() {
    this.isActive = !this.isActive;
  }
}