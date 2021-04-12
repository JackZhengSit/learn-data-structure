package com.jack.data_strature;

public class Sqrt {
  public static void main(String[] args) {
    System.out.println(sqrt(5));
  }

  static float sqrt(float n) {

    float low = 0f;
    float high = n;
    int count = 0;
    while (count < 10) {
      float val = (low + high) / 2;
      if (n < val * val) high = val;
      else if (n > val * val) low = val;
      else break;
      count++;
    }
    return high;
  }
}
