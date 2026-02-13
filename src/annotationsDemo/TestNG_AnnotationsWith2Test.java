package annotationsDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_AnnotationsWith2Test {

	@BeforeSuite
	public static void beforeSuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public static void afterSuite() {
		System.out.println("After Suite");
	}

	@BeforeTest
	public static void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	public static void afterTest() {
		System.out.println("After Test");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}

	@BeforeMethod
	public static void beforeMethod() {
		System.out.println("Before method");
	}

	@AfterMethod
	public static void afterMethod() {
		System.out.println("After method");
	}

	@Test
	public static void test1() {
		System.out.println("Test 1");
	}
	
	@Test
	public static void test2() {
		System.out.println("Test 2");
	}

}
