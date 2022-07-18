package cache.缓存算法;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 和LRUCache 实现基本一致，只是把accessOrder 设置为false
 */
public class FIFOCache extends LinkedHashMap<Integer,Integer> {

    private int initialCapacity;

    public FIFOCache(int initialCapacity){
        super(initialCapacity);
        this.initialCapacity=initialCapacity;
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>initialCapacity;
    }
}
