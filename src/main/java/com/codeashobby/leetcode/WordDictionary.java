/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Description:
 * <p/>
 * Design a data structure that supports the following two operations:
 * <p/>
 * <pre>
 * void addWord(word)
 * bool search(word)
 * </pre>
 * search(word) can search a literal word or a regular expression string containing
 * <p/>
 * only letters a-z or .. A . means it can represent any one letter.
 * <p/>
 * For example:
 * <p/>
 * <pre>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * </pre>
 * Note: You may assume that all words are consist of lowercase letters a-z.
 *
 * @author hzhou
 */
public class WordDictionary {

	private WordLinkNode root = new WordLinkNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		if (word == null || word.isEmpty()) {
			return;
		}
		Map<Character, WordLinkNode> children = root.getChildren();

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			WordLinkNode tmp;

			if (children.containsKey(c)) {
				tmp = children.get(c);
			} else {
				tmp = new WordLinkNode(c);
				children.put(c, tmp);
			}

			children = tmp.getChildren();

			if (i == word.length() - 1) {
				tmp.setIsLeaf(true);
			}
		}
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return word == null || word.isEmpty() || searchHelper(0, word, root);

	}

	private boolean searchHelper(int start, String word, WordLinkNode root) {
		if (start == word.length()) {
			return root.isLeaf();
		}
		boolean result = false;
		char c = word.charAt(start);
		if (c == '.') {
			for (WordLinkNode w : root.getChildren().values()) {
				result |= searchHelper(start + 1, word, w);
			}
		} else {

			while (start < word.length()) {
				c = word.charAt(start);
				if (c == '.') {
					for (WordLinkNode w : root.getChildren().values()) {
						result |= searchHelper(start + 1, word, w);
					}
					return result;
				}
				if (!root.getChildren().containsKey(c)) {
					return false;
				}
				root = root.getChildren().get(c);
				start++;

			}

			return root.isLeaf();

		}
		return result;
	}

	@Test
	public void test() {

		addWord("bad");
		addWord("dad");
		addWord("mad");
		addWord("ran");
		addWord("rune");
		addWord("runner");
		addWord("runs");
		addWord("add");
		addWord("adds");
		addWord("adder");
		addWord("addee");

		addWord("a");
		addWord("a");

		assertEquals(false, search("a."));

		assertEquals(true, search("r.n"));
		assertEquals(false, search("pad"));
		assertEquals(true, search("bad"));
		assertEquals(true, search(".ad"));
		assertEquals(true, search("b.."));

	}

	static class WordLinkNode {

		private Map<Character, WordLinkNode> children;
		private Character value;
		private boolean isLeaf;

		// Initialize your data structure here.
		public WordLinkNode() {
			children = new HashMap<Character, WordLinkNode>();
			isLeaf = false;
		}

		public WordLinkNode(Character value) {
			this();
			this.value = value;
		}

		public Map<Character, WordLinkNode> getChildren() {
			return children;
		}

		public boolean isLeaf() {
			return isLeaf;
		}

		public void setIsLeaf(boolean isLeaf) {
			this.isLeaf = isLeaf;
		}
	}
}