package zhangyue;

/**
 * @ClassName: Main01
 * @Package: zhangyue
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/27 19:05
 * @Version: 1.0
 */
import java.util.*;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main01 {
    static class Solution {
        public static int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k,(a, b) ->
                    Integer.compare(frequencyMap.get(a), frequencyMap.get(b)));

            for (int num : frequencyMap.keySet()) {
                minHeap.offer(num);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            int[] answer = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                answer[i] = minHeap.poll();
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arrayStr = input.split(",");
        int[] nums = new int[arrayStr.length];
        for(int i = 0; i < arrayStr.length; i++){
            nums[i] = Integer.parseInt(arrayStr[i]);
        }
        int k = Integer.parseInt(scanner.nextLine());
        int[] result = solution.topKFrequent(nums, k);
        String output = String.join(",", Arrays.stream(result).mapToObj(String::valueOf).toArray(String[]::new));
        System.out.println(output);

    }
}
