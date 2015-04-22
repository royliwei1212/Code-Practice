package com.codeashobby.leetcode;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by hzhou on 4/21/15. codeashobby@gmail.com
 */
public class CompareVersionNumbers {

	private static final Logger log = Logger.getLogger(CompareVersionNumbers.class);

	public int compareVersion(String version1, String version2) {
		assert version1 != null;
		assert version2 != null;

		String[] splits1 = version1.split("\\.");
		String[] splits2 = version2.split("\\.");
		int len1 = splits1.length;
		int len2 = splits2.length;
		int result = 0;
		for (int i = 0; i < Math.min(len1, len2); i++) {
			int val1 = Integer.valueOf(splits1[i]);
			int val2 = Integer.valueOf(splits2[i]);
			if (val1 > val2) {
				result = 1;
				break;
			} else if (val1 < val2) {
				result = -1;
				break;
			}
		}

		if (result == 0 && len1 != len2) {
			if (len1 > len2) {
				for (int i = len2; i < len1; i++) {
					if (Integer.valueOf(splits1[i]) != 0) {
						result = 1;
						break;
					}
				}
			} else {
				for (int i = len1; i < len2; i++) {
					if (Integer.valueOf(splits2[i]) != 0) {
						result = -1;
						break;
					}
				}
			}
		}
		return result;
	}

	@Test
	public void test() {
		String[] strs = "22.33".split("\\.");
		for (String str : strs) {
			log.info(str);
		}
	}
}
