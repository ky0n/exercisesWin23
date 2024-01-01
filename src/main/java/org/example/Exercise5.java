package org.example;

// Spiral Traversal

import java.util.ArrayList;
import java.util.List;

public class Exercise5 {

   public void run() {
      Integer[][] inputs = {
            { 1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
      };

      String[][] letterPairs = {
            {"AB", "BC", "CD", "DE"},
            {"JK", "KL", "LM", "EF"},
            {"IJ", "HI", "GH", "FG"}
      };

//      var res1 = spiralTraversal(inputs);
//      res1.forEach(System.out::println);
//      System.out.println();
      var res2 = spiralTraversal(letterPairs);
      res2.forEach(System.out::println);
   }

   <T> List<T> spiralTraversal(T[][] twoDimArray) {
      var traversedList = new ArrayList<T>();
      var inc = 0;
      for (int i = 0; i <= (twoDimArray.length - 1) / 2; i++) {
         var k = 1;
         var l = twoDimArray[0].length - 1;
         var m = twoDimArray.length - 2;

         // left to right upper row
         for (int j = 0 + inc; j <= twoDimArray[0].length - 1 - inc; j++) {
            traversedList.add(twoDimArray[i][j]);
         }

         // top to bottom right column
         for (; k + inc <= twoDimArray.length - 2 - inc; k ++) {
            traversedList.add(twoDimArray[k + inc][twoDimArray[0].length - 1 - inc]);
         }

         // right to left bottom row
         for (; l - inc >= 0 + inc; l--) {
            if (twoDimArray.length % 2 == 1 && inc == twoDimArray.length / 2) {
               break;
            }
            traversedList.add(twoDimArray[twoDimArray.length - 1 - inc][l - inc]);
         }

         // bottom to top left column
         for (; m - inc >= 1 + inc; m--) {
            traversedList.add(twoDimArray[m - inc][i]);
         }

         inc++;
      }
      return traversedList;
   }
}
