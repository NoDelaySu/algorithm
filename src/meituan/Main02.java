package meituan;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取初始时间
        String initialTime = scanner.nextLine();
        String[] initialTimeParts = initialTime.split(":");
        int initialHour = Integer.parseInt(initialTimeParts[0]);
        int initialMinute = Integer.parseInt(initialTimeParts[1]);

        // 读取操作次数
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        // 处理每次操作
        for (int i = 0; i < n; i++) {
            String operation = scanner.nextLine();
            char op = operation.charAt(0);
            int x = Integer.parseInt(operation.split(" ")[1]);

            if (op == '+') {
                // 向后调整时间
                initialMinute += x;
                if (initialMinute >= 60) {
                    initialMinute -= 60;
                    initialHour = (initialHour + 1) % 24;
                }
            } else if (op == '-') {
                // 向前调整时间
                initialMinute -= x;
                if (initialMinute < 0) {
                    initialMinute += 60;
                    if (initialHour == 0) {
                        initialHour = 23;
                    } else {
                        initialHour--;
                    }
                }
            }
        }

        // 格式化最终时间
        String finalHourStr = String.format("%02d", initialHour);
        String finalMinuteStr = String.format("%02d", initialMinute);
        String finalTime = finalHourStr + ":" + finalMinuteStr;

        System.out.println(finalTime);
    }
}

