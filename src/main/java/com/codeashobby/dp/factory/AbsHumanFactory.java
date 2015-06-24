/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.factory;

/**
 * Description:
 *
 * @author hzhou
 */
public abstract class AbsHumanFactory {

	public abstract <T extends Human> T createHuman(Class<T> clz);
}