package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Leaders in an array
public class Exercise4 {

   public void run() {
      var inputs = new Integer[][]{
            {23, 22, 24, 9, 10},
            {10, 90, 30, 70, 50},
            {40, 41, 42, 21, 22, 23}
      };
      var expected = new Integer[][]{
            {10, 24},
            {50, 70, 90},
            {23, 42}
      };

      for (int i = 0; i < expected.length; i++) {
         var input = inputs[i];
         var inputList = new ArrayList<>(Arrays.asList(input));
         var result = exercise4(inputList);
         if (result.equals(Arrays.asList(expected[i]))) {
            System.out.println("Test " + i + " passed");
         } else {
            System.out.println("Test " + i + " failed");
            System.out.println("Expected: " + Arrays.toString(expected[i]));
            System.out.println("Got: " + result);
         }
      }

   }

   private List<Integer> exercise4(ArrayList<Integer> nums) {
      int biggest = Integer.MIN_VALUE;
      var leaders = new ArrayList<Integer>();
      for (int i = nums.size() - 1; i >= 0; i--) {
         var el = nums.get(i);
         if (el > biggest) {
            leaders.add(el);
            biggest = el;
         }
      }
      return leaders;
   }
}
