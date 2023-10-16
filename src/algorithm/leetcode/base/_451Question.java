import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _451Question {

    public static String frequencySort(String s) {
        Map<Character, Integer> unsortedMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char key = s.charAt(i);
            unsortedMap.put(key, unsortedMap.getOrDefault(key, 0) + 1);
        }
//        System.out.println(unsortedMap);
        // 使用自定义比较器按值排序
        Comparator<Character> valueComparator = (key1, key2) -> {
            Integer value1 = unsortedMap.get(key1);
            Integer value2 = unsortedMap.get(key2);
            // 比较值，如果值相同则按键的自然顺序排序
            if (value1.compareTo(value2) == 0) {
                return key1.compareTo(key2);
            }
            return value2.compareTo(value1);
        };
        Map<Character, Integer> sortedMap = new TreeMap<>(valueComparator);
        sortedMap.putAll(unsortedMap);
//        System.out.println(sortedMap); // 输出将会按值排序
        // 构建排序后的字符串
        StringBuilder sortedString = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < value; i++) {
                sortedString.append(key);
            }
        }
        return sortedString.toString();
    }


    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
