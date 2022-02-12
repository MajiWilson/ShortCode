package tempWorkspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class: ������������ n �� k������ 1 ... n �����п��ܵ� k ��������ϡ�
 * ����: n = 4, k = 2
 * ���:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 16:12
 */
public class BackTrack_3_KCombination {
        public static List<List<Integer>> list = new ArrayList<>();
        public static int SIZE = 0;
        public static int NUM = 0;
        public static int[] mark ;

        public static void main(String[] args){
            combine(4, 3);
        }

        public static List<List<Integer>> combine(int n, int k) {
            SIZE = n;
            NUM = k;
            mark = new int[SIZE];
            for(int i = 0 ; i < SIZE ;i++){
                mark[i] = 0;
            }
            getCombination(0);
            return list;
        }
        /* ���ݷ����У���ռ�Ϊ x��n�� x[i]=1��ʾ��Ԫ��ȡ��������÷����·�ִ������ �������Ϸ���Ч�ʸ��ߣ� */
        public static void getCombination(int k){
            if( isFull()){
                List<Integer> dataList = new ArrayList<>();
                for(int i = 0 ; i < SIZE ; i ++){
                    if(mark[i] == 1){
                        dataList.add(i+1);
                        System.out.print((i+1)+ " ");
                    }
                }
                System.out.println();
                list.add(dataList);
            }
            else if( k == SIZE){
                return;
            }
            else{/* ע�⣺ ��������ָ�ֵ��䲻��ʡ�� mark[k] = 0 ,��Ȼ��ֵ��0 �����ǿ��ܺ������ݵ�ʱ���Ѿ����ó�1��*/
                mark[k] = 0;
                getCombination(k+1);
                mark[k] = 1;
                getCombination(k+1);
            }
        }

        public static boolean isFull(){
            int count = 0;
            for(int i = 0 ;i < SIZE ; i++){
                if(mark[i] == 1){
                    count++;
                }
            }
            return count == NUM ? true : false;
        }


}
