package org.adacitin.scenario;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class PArallelTest {
	
	@Test(groups = {"smoke"})
	public void me0() {
		System.out.println("test1");
	}

	@Test(dependsOnGroups = {"sanity","regress"}, groups = {"smoke"} )
	public void me1() {
		System.out.println("test2");
	}
	
	@Test(groups = {"regress"})
	public void meee() {
		System.out.println("meee");
	}
	
	@Test(groups = {"smoke","sanity"})
	public void me2() {
		System.out.println("test3");
		assertTrue(true);
	}

	
}
