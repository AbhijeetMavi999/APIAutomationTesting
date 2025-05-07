package annotations;

import org.testng.annotations.*;

public class AnnotationsInTestNg {

    @Test
    void testMethod1() {
        System.out.println("Test Method 1");
    }

    @BeforeSuite
    void beforeSuiteMethod() {
        System.out.println("Before Suite Method");
    }

    @AfterSuite
    void afterSuiteMethod() {
        System.out.println("After Suite Method");
    }

    @BeforeClass
    void beforeClassMethod() {
        System.out.println("Before Class Method");
    }

    @BeforeMethod
    void beforeMethodTest() {
        System.out.println("Before Method");
    }

    @BeforeTest
    void testMethod2() {
        System.out.println("Before Test Method");
    }
}
