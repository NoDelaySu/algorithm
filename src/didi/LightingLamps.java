package didi;

import java.util.Arrays;

public class LightingLamps {

    public static void main(String[] args) {
        int[] lampPositions = {5,4,3,2,1,1000000000}; // 输入的照明灯位置
        int k = 2; // 输入的照明灯数量

        Arrays.sort(lampPositions); // 将照明灯位置排序

        int maxDistance = findMaxDistance(lampPositions, k);
        System.out.println("最大距离是：" + maxDistance);
    }

    public static int findMaxDistance(int[] lampPositions, int k) {
        int n = lampPositions.length;
        int low = 1;
        int high = lampPositions[n - 1]; // 使用最大坐标值作为道路的总长度
        int maxDistance = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 1;
            int currentPos = lampPositions[0];

            for (int i = 1; i < n; i++) {
                if (lampPositions[i] - currentPos >= mid) {
                    count++;
                    currentPos = lampPositions[i];
                }
            }

            if (count >= k) {
                maxDistance = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return maxDistance;
    }
}
