package digifiatsim;

public class RandomInt {
  public static int getRandomInt(int min, int max) {
    return (int)(((Math.random() * ((max - min) + 1)) + min));
  }
  public static int getRandomInt(int max) {
    return (int)((Math.random() * (max + 1)));
  }

  public static void main(String s[]) {
    System.out.println("Between 10 and 20: " + RandomInt.getRandomInt(10,20));
    System.out.println("Below 100: " + RandomInt.getRandomInt(100));
  }
}
