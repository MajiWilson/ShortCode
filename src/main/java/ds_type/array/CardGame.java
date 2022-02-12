package ds_type.array;

import java.util.*;

/**
 * 若干牌，从上面那一张出来，然后接着拿一张到背后，如此往复，现已知道拿出的顺序，求原始顺序；
 * 比如： 1 3 2 4 对应的原始序列是 1 2 3 4
 */
public class CardGame {

    /**
     * 1 2 3 4 5 6 7 8 9 10
     * 2 3 4 5 6 7 8 9 10       1
     * 3 4 5 6 7 8 9 10 2
     * 4 5 6 7 8 9 10 2         1 3
     * 5 6 7 8 9 10 2 4
     * 6 7 8 9 10 2 4           1 3 5
     * 7 8 9 10 2 4 6
     * 8 9 10 2 4 6             1 3 5 7
     * 9 10 2 4 6 8
     * 10 2 4 6 8               1 3 5 7 9
     * 2 4 6 8 10
     * 4 6 8 10                 1 3 5 7 9 2
     * 6 8 10 4
     * 8 10 4                   1 3 5 7 9 2 6
     * 10 4 8
     * 4 8                      1 3 5 7 9 2 6 10
     * 8 4
     * 4                        1 3 5 7 9 2 6 10 8
     * 4
     *                          1 3 5 7 9 2 6 10 8 4
     */

    /**
     * 思路：
     * 对于给定的序列，前一半鼻屎原始序列的1 3 5 7 ...位，剩下的可以循环即可
     * 这里维持一个下标数组，每次间隔取，下标就是数组最终的位置。
     */
    public int[] getOriginCards(LinkedList<Integer> cards){
        int n = cards.size();
        int[] res = new int[n];
        Queue<Integer> location = new LinkedList<>();
        for(int i = 0; i< n; i++){  // 下标数组
            location.offer(i);
        }
        while(!cards.isEmpty()){
            int size = cards.size();
            if(size%2== 0){
                size = size/2;
            }
            else{
                size = size/2 +1;
            }
            for(int i = 0 ; i< size; i++){
                res[location.poll()] = cards.poll(); // 下标即位置
                location.offer(location.poll());     // 下标间隔取
            }
        }
        return res;
    }

    public LinkedList<Integer> getCards(int n ){
        LinkedList<Integer> cards = new LinkedList<>();
        for(int i = 0 ;i< n; i++){
            cards.add(i+1);
        }
        return cards;
    }

    public LinkedList<Integer> getSerial(LinkedList<Integer> cards){
        LinkedList<Integer> res = new LinkedList<>();
        while(!cards.isEmpty()){
            res.offer(cards.poll());
            if(!cards.isEmpty()){
                cards.offer(cards.poll());
            }
        }
        return res;
    }

    public void cardGame(int n){
        LinkedList<Integer> cards = getCards(n);
        System.out.println("get cards: ");
        for(int x : cards){
            System.out.print(" " + x);
        }
        System.out.println();


        LinkedList<Integer> serial = getSerial(cards);
        System.out.println("get serial: ");
        for(int x : serial){
            System.out.print(" " + x);
        }
        System.out.println();


        int[] originCards = getOriginCards(serial);
        System.out.println("get origin cards: ");
        for(int x : originCards){
            System.out.print(" " + x);
        }
        System.out.println("\n");

    }

}
