package net.metrosystems.demo.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestNGExample {
	int nr;
	boolean param;

	@Test
	private void metoda1() {
		param = false;
		if (param == true) {
			System.out.println("metoda 1");
			nr = 1;
		}
		assertEquals(nr, 1);
	}

	@Test(dependsOnMethods = "metoda1", alwaysRun = true)
	public void metoda2() {
		if (nr == 1) {
			System.out.println("metoda 2");
			nr = 2;
		}
		assertEquals(nr, 2);

	}

	@Test(dependsOnMethods = "metoda2")
	public void metoda3() {
		if (nr == 2) {
			System.out.println("metoda 3");
			nr = 3;
		}
		assertEquals(nr, 3);
	}

	@Test(dependsOnMethods = "metoda3")
	public void metoda4() {
		if (nr == 3) {
			System.out.println("metoda 4");
			nr = 4;
		}
		assertEquals(nr, 4);
	}

}
