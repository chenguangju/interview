package collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 1、LinkedHashMap 继承自 HashMap，所以它的底层是基于数组和链表+红黑树，在此基础上LinkedHashMap 增加了一条双向链表，保持其顺序性
 * 2、LinkedHashMap 有两种顺序一种按插入顺序，另一种是按访问顺序，通过accessOrder控制。默认构造为false为插入顺序，为true时是访问顺序
 * 3、accessOrder和afterNodeAccess配合使用，当accessOrder为true时表示按访问顺序排序，当调用get方法，最后会调用afterNodeAccess方法调整链表顺序，把访问node调整到链表尾部
 * 4、LinkedHashMap 重写了get方法 ，调用父类HashMap的获取node，然后根据accessOrder的值，调整链表节点顺序
 * 5、LinkedHashMap 的afterNodeInsertion 插入后，afterNodeAccess 访问后，afterNodeRemoval删除后，重写HashMap的三个方法，在put,get,remove都会调用上面的方法
 *    afterNodeAccess配合accessOrder完成按访问顺序排序
 *    afterNodeRemoval提供LinkedHashMap删除节点时，把链表断开
 *    afterNodeInsertion配合removeEldestEntry 可以实现对固定的大小的LinkedHashMap 删除最老的数据即删除头结点
 * 6、以上特性可以通过集成LinkedHashMap实现LRU 缓存算法 {@link cache.缓存算法.LRUCache}
 *
 */
public class LinkedHashMapCode {

    public static void main(String[] args) {
        /*LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>(10,0.75f,true);
        map.put(11,22);
        map.put(22,33);
        map.put(33,44);
        map.forEach((k,v)->{
            System.out.println(k+""+v);
        });
        map.get(22);
        map.forEach((k,v)->{
            System.out.println(k+""+v);
        });*/

        HashMap<String, String> map = new HashMap<>(4, 0.8f);
        map.put("1","2");
        map.put("2","3");
        map.put("3","4");
    }
}
