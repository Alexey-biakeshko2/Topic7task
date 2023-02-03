import java.util.ArrayList;
import java.util.List;

public class Topic7Task {

  public static void main(String[] args) {
    System.out.println(areCoprime(1, 2, 3)); // true
    System.out.println(areCoprime(7, 10, 11)); // true
    System.out.println(areCoprime(2, 4, 6)); // false

    System.out.println(sumsOfThrees(new int[]{1, 2, 3})); // 6
    System.out.println(sumsOfThrees(new int[]{1, 2, 3, 4})); // 15
    System.out.println(sumsOfThrees(new int[]{1, 2, 3, 4, 5})); // 27
    System.out.println(sumsOfThrees(new int[]{1, 2, 3, 4, 5, 6})); // 42

    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474]
    System.out.println(findAllArmstrongNumbers(10000));
  }

  private static boolean areCoprime(int a, int b, int c) {
    int gcd = Topic6Task.greatestCommonDivisor(Topic6Task.greatestCommonDivisor(a, b), c);

    return gcd == 1;
  }

  private static int sumsOfThrees(int[] array) {
    int subarrayLength = 3;
    int sum = 0;

    for (int i = 0; i <= array.length - subarrayLength; i++) {
      sum += subarraySum(array, i, subarrayLength);
    }

    return sum;
  }

  private static int subarraySum(int[] array, int start, int length) {
    int sum = 0;

    for (int i = start; i < start + length && i < array.length; i++) {
      sum += array[i];
    }

    return sum;
  }

  private static List<Integer> findAllArmstrongNumbers(int k) {
    List<Integer> result = new ArrayList<>();

    for (int i = 1; i <= k; i++) {
      if (isArmstrongNumber(i)) {
        result.add(i);
      }
    }

    return result;
  }

  private static boolean isArmstrongNumber(int n) {
    String nString = String.valueOf(n);
    int sum = 0;

    for (int i = 0; i < nString.length(); i++) {
      int digit = Character.digit(nString.charAt(i), 10);
      sum += Math.pow(digit, nString.length());
    }

    return sum == n;
  }

}
