package china.p146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created on 10/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> cache;

    static class LRUCacheImpl extends LinkedHashMap<Integer, Integer> {

        private int maxSize;

        public LRUCacheImpl(int capacity) {
            super(capacity * 2, 0.75f, true);
            maxSize = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > maxSize;
        }
    }

    public LRUCache(int capacity) {
        cache = new LRUCacheImpl(capacity);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

}
