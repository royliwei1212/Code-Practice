/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.prototype;

/**
 * Description:
 *
 * @author hzhou
 */
public class PrototypeClass implements Cloneable {

	@Override
	public PrototypeClass clone() {
		PrototypeClass cloned = null;
		try {
			cloned = (PrototypeClass) super.clone();
		} catch (CloneNotSupportedException e) {
			//e.printStackTrace();
		}
		return cloned;
	}
}