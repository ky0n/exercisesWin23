package org.example;

// Spiral Traversal

import java.util.ArrayList;
import java.util.List;

public class Exercise5 {

   public void run() {
      Integer[][] inputs = {{ 1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}};

      String[][] letterPairs = {{"AB", "BC", "CD", "DE"}, {"JK", "KL", "LM", "EF"}, {"IJ", "HI", "GH", "FG"}};

      var res1 = spiralTraversal(inputs);
      res1.forEach(System.out::println);
   }

   <T> List<T> spiralTraversal(T[][] twoDimArray) {
      var traversedList = new ArrayList<T>();
      for (int i = 0; i <= (twoDimArray.length - 1) / 2; i++) {
         // left to right upper row
         for (int j = 0; j <= twoDimArray[0].length - 1; j++) {
            traversedList.add(twoDimArray[i][j]);
         }

         // top to bottom right column
         for (int k = 1; k <= twoDimArray.length - 2; k ++) {
            traversedList.add(twoDimArray[k][twoDimArray.length - 1]);
         }

         // right to left bottom row
         for (int l = twoDimArray[0].length - 1; l >= 0; l--) {
            traversedList.add(twoDimArray[twoDimArray.length - 1][l]);
         }

         // bottom to top left column
         for (int m = twoDimArray.length - 2; m >= 1; m--) {
            traversedList.add(twoDimArray[m][0]);
         }

         break;
      }
      return traversedList;
   }
}
