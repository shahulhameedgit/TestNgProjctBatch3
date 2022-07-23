package org.adacitin.scenario;

import org.testng.annotations.Test;

public class Priority {
	
	
	@Test(priority = -10)
	public void test4() {
		System.out.println("test1");
	}

	@Test(priority = 0)
	public void test1() {
		System.out.println("test1");
	}

	@Test(priority = -1)
	public void test2() {
		System.out.println("test2");
	}

	@Test(priority = 1)
	public void noPriority() {
		System.out.println("no priority");
	}

}
