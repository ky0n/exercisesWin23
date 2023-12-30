package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

// Sort huge amount of numbers in O(n) time
public class Exercise3 {

   public void run() {
      // generate elements
      var nums_of_nums = 50_000_000;
      var random = new Random();
      var nums = new ArrayList<Integer>();
      for (int i = 0; i < nums_of_nums; i++) {
         var newNum = random.nextInt(100) + 1;
         nums.add(newNum);
      }
      System.out.println("Generated " + nums_of_nums + " numbers");
      System.out.println("Sort with bucketsort:");
      var time = System.currentTimeMillis();
      exercise2(nums);
      var timeAfter = System.currentTimeMillis();
      System.out.println("Time: " + (timeAfter - time) + " ms");

      var numsArray = nums.toArray();
      System.out.println("Sort with arrays.sort:");
      time = System.currentTimeMillis();
      Arrays.sort(numsArray);
      timeAfter = System.currentTimeMillis();
      System.out.println("Time: " + (timeAfter - time) + " ms");
   }

   private List<Integer> exercise2(ArrayList<Integer> nums) {
      var buckets = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < 100; i++) {
         buckets.add(new ArrayList<>());
      }
      for (var num : nums) {
         buckets.get(num - 1).add(num);
      }
      return buckets.stream().flatMap(ArrayList::stream).collect(Collectors.toList());
   }
}