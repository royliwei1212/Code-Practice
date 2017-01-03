/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.UUID;

/**
 * Description:
 *
 * @author hzhou
 */
public class Container {

	private Type type;
	private UUID id;
	private Container c;

	public Container(Type type) {
		this.type = type;
	}

	public Container(Type type, UUID id) {
		this.type = type;
		this.id = id;
	}

	protected Container(Container original, boolean deepCopy) {
		this.type = original.getType();
		this.id = original.getId();
		// for deep copy of id field, should I write as:
		// this.id = new UUID(original.getId().getMostSignificantBits(), original.getId().getLeastSignificantBits());
		if (original.getC() != null) {
			this.c = deepCopy ? original.getC().deepCopy() : original.getC();
		}
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Container getC() {
		return c;
	}

	public void setC(Container c) {
		this.c = c;
	}

	public Container deepCopy() {
		return new Container(this, true);
	}

	public Container copy() {
		return new Container(this, false);
	}
}