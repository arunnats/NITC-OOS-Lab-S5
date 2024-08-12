import java.util.Scanner;

public class Q2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int coords = sc.nextInt();
    int y = coords % 10;
    int x = coords / 10;

    int n = sc.nextInt();
    sc.nextLine();
    String[] movements = sc.nextLine().split(" ");

    Solution S = new Solution();
    int[] result = S.traverse(x, y, n, movements);

    System.out.println("["+result[0] + "," + result[1]+"]");
    sc.close();
  }
}

class Solution {
  public int[] traverse(int x, int y, int n, String[] movements) {
    for (int i = 0; i < 2 * n; i += 2){
      String direction = movements[i];
      int steps = Integer.parseInt(movements[i + 1]);

      switch (direction) {
        case "Up":
          x -= steps;
          break;
        case "Down":
          x += steps;
          break;
        case "Left":
          y -= steps;
          break;
        case "Right":
          y += steps;
          break;
        default:
          break;
      }

      if (x < 1 || x > 8 || y < 1 || y > 8) {
        throw new ArrayIndexOutOfBoundsException("Overflow");
      }
    }
    return new int[] {x, y};
  }
}
