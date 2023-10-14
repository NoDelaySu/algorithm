package shenxinfu;

import java.util.*;
//3 7
//s 1 2
//s 2 3
//s 3 4
//g 1
//g 4
//s 4 5
//g 2

/**
 * @ClassName: Shenxinfu01
 * @Package: Shenxinfu
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/16 14:35
 * @Version: 1.0
 */
class Cache{
    public int key;
    public int value;
    public int useTimes;
    public int index;
    public Cache(int key, int value, int useTimes, int index) {
        this.key = key;
        this.value = value;
        this.useTimes = useTimes;
        this.index = index;
    }
}
class LRU{
    public HashMap<Integer, Cache> map = new HashMap<>();
    public int capacity;

    public boolean set(int key, int val){
        if(map.size() < capacity){
            map.put(key, new Cache(key, val, 0, map.size()));
        }else{
            Collection<Cache> values = map.values();
            List<Cache> cacheList = new ArrayList<>(values);
            Comparator<Cache> comparator = new Comparator<Cache>() {
                @Override
                public int compare(Cache c1, Cache c2) {
                    if (c1.useTimes == c2.useTimes) {
                        return c1.index - c2.index;
                    }

                    return c1.useTimes - c2.useTimes;
                }
            };
            Collections.sort(cacheList, comparator);
            Cache remove = map.remove(cacheList.get(0).key);
            Iterator<Map.Entry<Integer, Cache>> iterator = map.entrySet().iterator();
            int index = 0;
            while(iterator.hasNext()){
                Map.Entry<Integer, Cache> next = iterator.next();
                Cache value = next.getValue();
                value.index = index++;
            }
            map.put(key, new Cache(key, val, 0, map.size()));
        }
        return true;
    }

    public int get(int key){
        Cache cache = map.get(key);
        if(cache != null){
            cache.useTimes++;
            return cache.value;
        }
        return -1;
    }
}


public class Shenxinfu01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        LRU lru = new LRU();
        lru.capacity = n;

        for (int i = 0; i < l; i++) {
            String command = in.next();
            if("s".equals(command)){
                int key = in.nextInt();
                int val = in.nextInt();
                lru.set(key, val);
            }else if("g".equals(command)){
                int key = in.nextInt();
                int value = lru.get(key);
                System.out.println(value);
            }
        }
    }
}




