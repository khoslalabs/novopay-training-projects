package in.novopay.platform.apis.test.getCorporateList;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	static String a;
	@Before("@Google")
	public void BeforeScenarioToRunForNullValue(){
		System.out.println(a);
		if(a==null) {
			a="AAA";
			System.out.println("Before Logging in");
		}
	}

	@After("@Google")
	public void AfterScenarioToRunForNullValue() {
		System.out.println("After logged in");
	}
		
}
