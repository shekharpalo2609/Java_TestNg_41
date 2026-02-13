package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Basic {

	@DataProvider(name = "test in string")
	public Object[][] stringMethod(){
		return new Object[][] {{"Akshay"},{"Babu"},{"Chandu"},{"Deepak"}};
	}
	
	@Test(dataProvider = "test in string")
	public void stringTestData(String data) {
		System.out.println(("name is: ").concat(data));
	}
	
	@DataProvider(name ="test in int")
	public Object[][] intMethod(){
		return new Object[][] {{21},{21},{33},{14},{62},{47}};
	}
	
	@Test(dataProvider = "test in int")
	public void intTestData(int age) {
		System.out.println("age is: " + age);
	}
	
}
