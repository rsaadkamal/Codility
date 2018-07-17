package com.codility.Project_Euler;/*
 * Solution to Project Euler problem 125
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */

import java.util.HashSet;
import java.util.Set;


public final class p125 implements EulerSolution {
	
	public static void main(String[] args) {
		System.out.println(new p125().run());
	}
	
	
	public String run() {
		Set<Integer> nums = new HashSet<>();
		for (int i = 1; i <= 10000; i++) {
			int sum = i * i;
			for (int j = i + 1; ; j++) {
				sum += j * j;
				if (sum >= 100000000)
					break;
				if (Library.isPalindrome(sum))
					nums.add(sum);
			}
		}
		
		long sum = 0;
		for (int x : nums)
			sum += x;
		return Long.toString(sum);
	}
	
}