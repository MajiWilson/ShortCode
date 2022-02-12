package ds_type.array;

import java.util.*;

/**输入中有多组测试数据。每组测试数据的第一行为两个整数n和m（1=＜n, m=＜1000），分别表示价签的数量以及小B的购买清单中所列的物品数。第二行为空格分隔的n个正整数，表示货架上各类物品的价格，每个数的大小不超过100000。随后的m行为购买清单中物品的名称，
 * 所有物品名称为非空的不超过32个拉丁字母构成的字符串，保证清单中不同的物品种类数不超过n，
 * 且商店有小B想要购买的所有物品。
 *
 * 6 5
 * 3 5 1 6 8 1
 * peach
 * grapefruit
 * banana
 * orange
 * orange
 * 输出： 11 30
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/18 , 11:39
 */
public class Array_2_ShopList {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt() ){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] price = new int[n];
            String[] list = new String[m];
            for( int i = 0 ; i < n ; i++){
                price[i] = in.nextInt();
            }
            in.nextLine();
            for( int i = 0 ; i < m ;i++){
                list[i] = in.nextLine();
            }
            Arrays.sort( price );
            Arrays.sort( list );
            List<Integer> count = new ArrayList<>();
            if(list.length == 1){
                count.add(1);
            }
            else{
                String fore = list[0];
                int num = 1;
                for( int i = 1 ;i < m ; i++){
                    if( list[i].equals(fore) ){
                        num++;
                    }
                    else{
                        count.add(num);
                        num = 1;
                        fore =list[i];
                    }
                    if( i == m-1){  /* 注意，这里边界条件，每次都要判断是否到达最后一个，否则推出循环就没人处理了 */
                        count.add(num);
                    }
                }
            }
            Collections.sort(count, Collections.reverseOrder());
            int max = 0;
            int min = 0;
            int i = 0;
            for(int c : count){
                for( int j = 0 ; j< c ;j++){
                    max += price[price.length -1-i];
                    min += price[i];
                }
                i++;
            }
            System.out.println(min + " " + max );
        }
    }
}
