/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode.parent;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author hzhou
 */
public class UndirectedGraphNode {

	public int label;
	public List<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}