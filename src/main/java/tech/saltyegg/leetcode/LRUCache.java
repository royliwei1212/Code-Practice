package tech.saltyegg.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hzhou on 5/4/15. codeashobby@gmail.com
 */
public class LRUCache {

	private LinkedHashMap<Integer, Integer> map;

	public LRUCache(int capacity) {
		final int c = capacity;
		this.map = new LinkedHashMap<Integer, Integer>(c) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return this.size() > c;
			}
		};
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			int value = map.get(key);
			map.remove(key);
			map.put(key, value);
			return value;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			map.remove(key);
		}
		map.put(key, value);
	}
}
