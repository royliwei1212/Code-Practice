/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.observer;

import java.util.Observer;

/**
 * Description:
 *
 * @author hzhou
 * @see java.util.Observable
 */
public interface Observable {

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObserver(Observer observer);
}