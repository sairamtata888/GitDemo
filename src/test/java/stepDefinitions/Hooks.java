package stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@test1")
	public void abc() {
		System.out.print("===========================");
	}
}
