package TestNgSessions;

import org.testng.annotations.Test;

public class InvocationCount {

	@Test(invocationCount = 10)
	public void createUserTest() {
		System.out.println("create user");
	}

	@Test(invocationCount = 10)
	public void getUserTest() {
		System.out.println("get user");
	}

}
