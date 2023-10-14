package shenxinfu;

/**
 * @ClassName: Shenxinfu01S
 * @Package: Shenxinfu
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/16 17:03
 * @Version: 1.0
 */
import java.util.*;

class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        if (cache.size() >= capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = cache.entrySet().iterator();
            iterator.next(); // Get the first entry (oldest)
            iterator.remove(); // Remove the oldest entry
        }
        cache.put(key, value);
    }
}

public class Shenxinfu01S {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();

        int n = scanner.nextInt();

        LRUCache lruCache = new LRUCache(capacity);

        for (int i = 0; i < n; i++) {
            String operation = scanner.next();
            int key = scanner.nextInt();

            if (operation.equals("s")) {
                int value = scanner.nextInt();
                lruCache.set(key, value);
            } else if (operation.equals("g")) {
                int result = lruCache.get(key);
                System.out.println(result);
            }
        }

        scanner.close();
    }
}

