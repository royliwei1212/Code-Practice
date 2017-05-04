/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.factory.simple;

import tech.saltyegg.dp.factory.Human;
import org.apache.log4j.Logger;

/**
 * Description:
 *
 * @author hzhou
 */
public class StaticHumanFactory {

	private static final Logger log = Logger.getLogger(StaticHumanFactory.class);

	@SuppressWarnings("unchecked")
	public static <T extends Human> T createHuman(Class<T> clz) {
		T human = null;
		try {
			human = (T) Class.forName(clz.getName()).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			log.error(e);
		}
		return human;
	}
}