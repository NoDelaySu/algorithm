package meituan;

import java.util.Scanner;

/**
 * @ClassName: Test02
 * @Package: meituan
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/16 18:52
 * @Version: 1.0
 */
public class Test02 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int[] score = {10,9,8,7,6,5,4,3,2,1,0};
        double distance = getDistance(x, y);
        if(distance >=0 && distance <= 1){
            System.out.println(10);
        }else if(distance > 1 && distance <= 2){
            System.out.println(9);
        }else if(distance > 2 && distance <= 3){
            System.out.println(8);
        }else if(distance > 3 && distance <= 4){
            System.out.println(7);
        }else if(distance > 4 && distance <= 5){
            System.out.println(6);
        }else if(distance > 5 && distance <= 6){
            System.out.println(5);
        }else if(distance > 6 && distance <= 7){
            System.out.println(4);
        }else if(distance > 7 && distance <= 8){
            System.out.println(3);
        }else if(distance > 8 && distance <= 9){
            System.out.println(2);
        }else if(distance > 9 && distance <= 10){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

    private static double getDistance(int x, int y) {
        double sqrt = Math.sqrt(x * x + y * y);
        return sqrt;

    }
}
