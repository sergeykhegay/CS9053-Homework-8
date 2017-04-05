package edu.nyu.cs9053.homework8;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(
                          LambdaSchedulerTest.class,
                          LambdaWeightedSchedulerTest.class
                      );

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }

      System.out.println(result.wasSuccessful());
   }

}
