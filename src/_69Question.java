public class _69Question {


    public static int mySqrt(int x) {
//        1.牛顿迭代法
        long res = x;
        while(res * res > x){
            res = (res + x / res) / 2;
        }
        return (int)res;
//        2. 二分查找
//        long low = 0, high = x / 2, mid = 0;
//        long res = -1;
//        if(x == 1){
//            return 1;
//        }
//        while(low <= high){
//            mid = (low + high) / 2; // 这种写法可能溢出，因此可以写成mid = low + (high - low) / 2
//            if(mid * mid <= x){
//                low = mid + 1;
//                res = mid;
//            }else{
//                high = mid - 1;
//            }
//        }
//
//        return (int)res;
    }
    public static void main(String[] args) {
        System.out.println(mySqrt(1));
    }


}
