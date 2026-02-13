package grouping;

import org.testng.annotations.Test;

public class GroupigTest {

	@Test(groups = {"smoke"})
	public void Test1() {
		
	}
	
	@Test(groups = {"smoke","sanity"})
	public void Test2() {
		
	}
	
	@Test(groups = {"sanity"})
	public void Test3() {
		
	}
	
	@Test(groups = {"regression"})
	public void Test4() {
		
	}
	
	@Test(groups = {"smoke","regression"})
	public void Test5() {
		
	}
}
