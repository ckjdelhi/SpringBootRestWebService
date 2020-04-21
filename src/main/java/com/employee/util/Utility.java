package com.employee.util;

public class Utility {
	public int add(int[] values) {
		int sum = 0;
		if (values.length == 0) {
			return sum;
		} else {
			for (int i : values) {
				sum = sum + i;
			}
			return sum;
		}
	}
}
