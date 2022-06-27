package techproed;
/*
What is the difference between assertion and verification?
Assertion means hard assertion. Verification means soft assertion. Verification is similar to if else statement.
If hard assertion fails, rest of the test case stops.
What is the difference between soft assert and hard assert?
Hard assertion stops execution, after assertion failure. Soft assert continues to execute even after failure
We need to create a soft assert object to do soft assertion
assertAll() need to be used in soft assert to make the actual result
Which assertion do you prefer? Why?
I used both. Both assertion are useful. But I used hard assertion the most, because I need to fix the issue
the moment it shows up. It usually doesn’t make sense to wait for other tests if there is a failure.
If there are  lots of test cases , I prefer to use hard assert to find the wrong test case quickly to fix it.
If I use soft assertion, It will run all the tests every time even there are wrong cases in them.
I usually use soft assertion when I write new test cases to see if all good or some fails.

 */

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day15_Assertions {
    @Test
    public void hardAssert(){
//        When an assertion fails, then that test case stops execution
//        And rest of the test case will not execute
        System.out.println("Line 11");//runs
        System.out.println("Line 12");//runs
        Assert.assertEquals(3,4);//runs. FAILS AND STOPS EXECUTION THE REST OF THE CODE IN THIS TEST CASE
        System.out.println("Line 15");//no runs
        Assert.assertEquals("apple","samsung");//no
        System.out.println("Line 16");//no runs
    }
    @Test
    public void testCase(){
        System.out.println("line 23");//runs
        System.out.println("line 24");//runs
    }
    //    By default, all methods are independent
//    We can make the methods dependent using dependsOnMethods
//    What is the connection between, dependentMethodDemo and hardAssert??????
//    dependentMethodDemo DEPENDS ON hardAssert
//    IF hardAssert fails, then dependentMethodDemo WILL NOW RUN
//   REMEMBER!!! Best Practice is to make the tests independent,
//   but we can make test cases dependent using depends no methods or depends on groups
    @Test(dependsOnMethods = "hardAssert")
    public void dependentMethodDemo(){
        System.out.println("line 29");//runs
        System.out.println("line 30");//runs
    }
    @Test
    public void softAssert(){
//        Soft assertion : Verification. Tests continue to execute even after failure
//        1. Create soft assert object
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Line 46");//runs

//        2. use soft assert to logs test as pass or fail
        softAssert.assertEquals(2,3);//expected [3] but found [2],
        System.out.println("Line 47");//runs
        softAssert.assertEquals(2,2);
        System.out.println("Line 51");//runs
        softAssert.assertEquals(2,4);//expected [4] but found [2]
        System.out.println("Line 53");//runs
//        3. use assertAll() to make the result. This should eb used at the end
//        if any case that fails, then the test will be marked as fails
        softAssert.assertAll();
    }
}
