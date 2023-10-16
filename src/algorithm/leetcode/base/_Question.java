import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _Question {

    public static int dfs(LinkedList<Integer> numList, LinkedList<Integer> a, LinkedList<Integer> b,
                          boolean isA, int maxAns){
        if(numList.size() == 0){
            int max = Math.max(a.stream().mapToInt(Integer::intValue).sum(),
                    b.stream().mapToInt(Integer::intValue).sum());
            return Math.max(maxAns, max);
        }
        if(isA) {
            int aFirstBNextStepMax = 0;
            int aLastBNextStepMax = 0;
            if(numList.size() + 1 >= 4){
                Integer first = numList.removeFirst();
                Integer aFirstNumListFirst = numList.getFirst();
                Integer aFirstNumListLast = numList.getLast();
                numList.addFirst(first);

                Integer last = numList.removeLast();
                Integer aLastNumListFirst = numList.getFirst();
                Integer aLastNumListLast = numList.getLast();
                numList.addLast(last);

                aFirstBNextStepMax = Math.max(aFirstNumListFirst, aFirstNumListLast); // 4
                aLastBNextStepMax = Math.max(aLastNumListFirst, aLastNumListLast); // 100
            }


            Integer first = numList.removeFirst();
            if((numList.size() + 1 == 3 && (first >= numList.getLast()))
                    || (numList.size() + 1 == 2 && (first >= numList.getFirst()))
                    || (numList.size() + 1 >= 4 && (aFirstBNextStepMax <= aLastBNextStepMax))
                    || (numList.size() + 1 == 1)){
                a.addLast(first);
                maxAns = dfs(numList, a, b, !isA, maxAns);  // step1 step3
                a.removeLast();
            }
            numList.addFirst(first);

            Integer last = numList.removeLast();
            if((numList.size() + 1 == 3 && (last >= numList.getFirst()))
                    || (numList.size() + 1 == 2 && last >= numList.getLast())
                    || (numList.size() + 1 >= 4 && (aFirstBNextStepMax >= aLastBNextStepMax))
                    || (numList.size() + 1 == 1)){
                a.addLast(last);
                maxAns = dfs(numList, a, b, !isA, maxAns); // step3=102
                a.removeLast();
            }
            numList.addLast(last);

        }else{
            int bFirstANextStepMax = 0;
            int bLastANextStepMax = 0;
            if(numList.size() + 1 >= 4){
                Integer first = numList.removeFirst();
                Integer bFirstNumListFirst = numList.getFirst();
                Integer bFirstNumListLast = numList.getLast();
                numList.addFirst(first);

                Integer last = numList.removeLast();
                Integer bLastNumListFirst = numList.getFirst();
                Integer bLastNumListLast = numList.getLast();
                numList.addLast(last);
                bFirstANextStepMax = Math.max(bFirstNumListFirst, bFirstNumListLast); // 4
                bLastANextStepMax = Math.max(bLastNumListFirst, bLastNumListLast); // 100
            }

            Integer first = numList.removeFirst();
            if((numList.size() + 1 == 3 && (first >= numList.getLast()))
                    || (numList.size() + 1 == 2 && (first >= numList.getFirst()))
                    || (numList.size() + 1 >= 4 && (bFirstANextStepMax <= bLastANextStepMax))
                    || (numList.size() + 1 == 1)){
                b.addLast(first);
                maxAns = dfs(numList, a, b, !isA, maxAns);  // step1 step3
                b.removeLast();
            }
            numList.addFirst(first);

            Integer last = numList.removeLast();
            if((numList.size() + 1 == 3 && (last >= numList.getFirst()))
                    || (numList.size() + 1 == 2 && last >= numList.getLast())
                    || (numList.size() + 1 >= 4 && (bFirstANextStepMax >= bLastANextStepMax))
                    || (numList.size() + 1 == 1)){
                b.addLast(last);
                maxAns = dfs(numList, a, b, !isA, maxAns); // step3=102
                b.removeLast();
            }
            numList.addLast(last);
        }


        return maxAns;
    }

    public static int getAnswer(LinkedList<Integer> numList){
        int ans = -1;
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
        ans = dfs(numList, a, b, true, Integer.MIN_VALUE);

        return ans;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 读取第一行的整数 n

        Integer[] numbers = new Integer[n]; // 创建一个数组来存储 n 个数字

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt(); // 读取第二行的 n 个数字
        }

        scanner.close(); // 关闭输入流
        Integer [] nums = {1,100,2};
        List<Integer> ints = Arrays.asList(numbers);
        LinkedList<Integer> numList = new LinkedList<>(ints);
        System.out.println(getAnswer(numList));

    }
}
//5000
//16715 38706 53998 71552 42582 38683 87181 8226 65518 37074 15723 90500 28524 88453 89186 53134 80554 58019 68184 52522 20400 435 99279 21444 8479 88402 79122 89795 76701 10577 77726 32231 82688 93262 75823 84996 50813 16882 84012 25470 466 12524 32789 39398 1618 98508 5611 89589 98352 76259 87488 61574 56975 36473 30367 32472 44713 60782 44638 33797 34109 30582 99747 98941 28030 8463 67828 78598 51705 86021 70627 24312 80902 71913 98137 42965 17394 29965 93730 34886 49900 32707 39800 50012 85710 22614 15188 78726 20973 27465 56977 88142 69252 42096 61186 24281 68957 34061 53175 53759 11169 82508 52747 70695 18082 66976 13936 29191 56101 21663 28575 76955 56469 50235 74970 47845 94085 34468 69539 93284 18341 49659 22307 7448 98089 60088 56819 62580 57366 72734 11598 76869 37389 38365 28249 11555 74108 92394 30610 94070 50787 48666 22425 20555 86531 41701 74364 36343 14445 40664 18471 88076 617 55771 14123 76249 45957 66437 5837 4487 51616 76925 27410 50161 23318 82163 55240 52580 74830 90366 95703 51512 17442 94295 75625 31758 12526 26326 55128 87019 48157 93420 82423 80468 60879 49410 38786 49003 82414 62384 9353 35561 16851 84128 63066 380 84755 2724 6030 77762 96655 23477 92791 41639 7772 17102 82856 34141 87983 31689 70436 99962 16621 71512 43466 13622 38961 40551 6400 55365 44862 60240 28415 41073 88103 45152 89600 96828 5853 14953 34853 34166 68536 17126 9577 47802 82536 34742 94892 80398 42205 58324 12633 31034 30453 94196 10073 78665 82118 36611 15421 16734 7661 90559 85511 41753 9365 32372 76346 16203 23690 54169 76739 61750 1888 490 48935 78569 45663 48552 4301 76634 66225 97391 6702 13925 48686 82583 99036 58436 66439 65229 59729 99696 68017 63826 45753 86872 47476 39380 66785 10847 40180 38316 6785 38363 7583 13369 30855 43884 68663 42331 66309 49369 33122 36883 94109 81969 63119 63801 29483 32801 3371 21278 96627 72786 73892 28003 25996 86022 96093 11354 91917 69010 15442 58972 96438 11006 64749 8170 56514 43355 95722 74376 27050 4804 80200 46520 61