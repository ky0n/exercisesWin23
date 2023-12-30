package org.example;

import java.util.ArrayList;
import java.util.Arrays;

// Mice and holes
public class Exercise1 {

   public static void run() {
      var mices = new Integer[][] {
            {1, 3, 6},
            {1, 2, 3},
            {7, 2, 1, 9},
            {1, 4, 11, 3},
      };
      var holes = new Integer[][] {
            {1, 2, 9},
            {3, 4, 2},
            {1, 2, 3, 4},
            {6, 7, 8, 9}
      };
      var expected = new Integer[]{3, 1, 3, 5};

      for (int i = 0; i < expected.length; i++) {
         var result = exercise1(mices[i], holes[i]);
         if (result == expected[i]) {
            System.out.println("Test " + i + " passed");
         } else {
            System.out.println("Test " + i + " failed");
            System.out.println("Expected: " + expected[i]);
            System.out.println("Got: " + result);
         }
      }
   }

   public static int exercise1(Integer[] mices, Integer[] holesa) {
      var holes = new ArrayList<>(Arrays.asList(holesa));
      int[] times = new int[mices.length];
      Integer[] pickedHoles = new Integer[holes.size()];
      for (int i = 0; i < mices.length; i++) {
         var mice = mices[i];
         int[] bestTimes = {Integer.MAX_VALUE, 0};
         for (int j = 0; j < holes.size(); j++) {
            var hole = holes.get(j);
            var time = Math.abs(mice - hole);
            if (time < bestTimes[0]) {
               bestTimes[0] = time;
               bestTimes[1] = hole;
            }
         }
         times[i] = bestTimes[0];
         pickedHoles[i] = bestTimes[1];
         holes.remove((Integer) bestTimes[1]);
      }
      return Arrays.stream(times).max().getAsInt();
   }
}
