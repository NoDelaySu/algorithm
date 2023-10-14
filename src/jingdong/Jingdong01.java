package jingdong;

import java.util.*;

/**
 * 100 3
 * 300 50
 * 200 30
 * 50 5
 *
 * 95
 */
public class Jingdong01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Integer totalCost = in.nextInt();
        Integer num = in.nextInt();
        if(totalCost < 0 || num < 0){
            System.out.println(0);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < num; i++){
            Integer money = in.nextInt();
            Integer discount = in.nextInt();
            if(money >= discount){
                if(map.get(money) != null && map.get(money) < discount){
                    map.put(discount, money);
                }else{
                    map.putIfAbsent(discount, money);
                }
            }
        }
//        Object[] valueArray = map.values().toArray();
        Object[] keyArray =  map.keySet().toArray();
        Arrays.sort(keyArray, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer)o1;
                Integer i2 = (Integer)o2;
                return i2 - i1;
            }
        });
        List<Integer> keyList = new ArrayList<>();
        for (Object o : keyArray) {
            keyList.add((Integer)o);
        }

        for (Integer discount : keyList) {
            if(map.get(discount) != null && map.get(discount) <= totalCost){
                totalCost -= discount;
                break;
            }

        }
        //System.out.println(keyList);
        System.out.println(totalCost);

    }
}
