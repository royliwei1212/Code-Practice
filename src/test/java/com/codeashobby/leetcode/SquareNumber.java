/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * Description:
 *
 * @author hzhou
 */
public class SquareNumber {

	public void process(String fileName) {
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		int testCaseCount = -1;
		int currentCount = 0;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));
			String s;
			while ((s = bufferedReader.readLine()) != null) {
				bufferedWriter.write(s);
				bufferedWriter.newLine();
				if (testCaseCount == -1) {
					testCaseCount = Integer.valueOf(s);
					continue;
				}

				String[] values = s.split(" ");
				if (values.length >= 2) {
					int a = Integer.valueOf(values[0].trim());
					int b = Integer.valueOf(values[1].trim());
					String result = helper(a, b);
					if (result != null) {
						bufferedWriter.write(result);
						bufferedWriter.newLine();
					}
				}
				// flush
				bufferedWriter.flush();
				currentCount++;
				if (currentCount >= testCaseCount) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String helper(int a, int b) {
		if (a < b) {
			StringBuilder sb = new StringBuilder();
			sb.append("-> ");
			for (int i = a; i <= b; i++) {
				int r = (int) (Math.sqrt(i));
				if (r * r == i) {
					sb.append(i).append(',');
				}
			}
			return sb.toString();
		} else {
			return null;
		}
	}

	@Test
	public void test() {
		process("input.txt");
	}
}