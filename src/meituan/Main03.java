package meituan;

import java.util.Scanner;

import java.math.BigInteger;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong(); // 输入正整数m

        BigInteger sum = BigInteger.ZERO;
        BigInteger segmentSum = BigInteger.ZERO; // 当前段的和
        long segmentLength = 1; // 当前段的长度

        while (m > 0) {
            segmentSum = BigInteger.ZERO;
            if (m >= segmentLength) {
                // 如果剩余的项数大于等于当前段的长度
                BigInteger segmentLengthBigInt = BigInteger.valueOf(segmentLength);
                segmentSum = segmentLengthBigInt.multiply(segmentLengthBigInt.add(BigInteger.ONE)).divide(BigInteger.valueOf(2)); // 计算当前段的和
                sum = sum.add(segmentSum).mod(BigInteger.valueOf((long)(10e9+7))); // 累加部分当前段的和到总和
                m -= segmentLength; // 更新剩余的项数
                segmentLength++; // 更新当前段的长度
            } else {
                // 如果剩余的项数小于当前段的长度
                BigInteger segmentLengthBigFirst = BigInteger.valueOf(segmentLength);
                BigInteger segmentLengthBigLast = BigInteger.valueOf(segmentLength - m + 1);
                segmentSum = BigInteger.valueOf(m)
                        .multiply(segmentLengthBigFirst.add(segmentLengthBigLast))
                        .divide(BigInteger.valueOf(2)); // 计算当前段的和
                sum = sum.add(segmentSum).mod(BigInteger.valueOf((long)(10e9+7))); // 累加部分当前段的和到总和
                m -= segmentLength; // 更新剩余的项数
                segmentLength++; // 更新当前段的长度
            }
        }

        System.out.println(sum.toString());
    }
}




