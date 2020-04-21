package com.employee.util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class UtilityTest {
	private Utility utility=new Utility();

	@Test
	public void canTestAdditionOfTwoNumbers() {
		int result = utility.add(new int[] {20,30});
		Assert.assertEquals(50, result);
	}
	@Test
	public void canTestAddtionIfEmptyArray() {
		int result = utility.add(new int[] {});
		Assert.assertEquals(0, result);
	}
	@Test
	public void canTestAddtionIfInvalidData() {
		int result = utility.add(new int[2]);
		Assert.assertEquals(0, result);
	}
	@Test
	public void canTestAddtionWith4Numbers() {
		int result = utility.add(new int[] {1,2,3,4});
		Assert.assertEquals(10, result);
	}

}
