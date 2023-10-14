public class _167Question {

    public static void main(String[] args) {
        int [] numbers = new int[]{1,2,3};
        int target = 6;
        int[] twoSum = twoSum(numbers, target);
        System.out.println(twoSum[0]+","+twoSum[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] != target){
                int temp1 = target - numbers[left];
                int temp2 = target - numbers[right];
                if(numbers[left] < temp2) left++;
                if(numbers[right] > temp1) right--;
            }else{
                break;
            }
        }

        return new int[]{left + 1,right + 1};
    }
}
