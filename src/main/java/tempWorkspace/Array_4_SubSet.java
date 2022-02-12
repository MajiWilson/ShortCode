package tempWorkspace;

import java.util.ArrayList;
import java.util.List;

/**
 * Class:����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ���,�����ռ���
 * ����: nums = [1,2,3]
 * ���:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 17:18
 */
public class Array_4_SubSet {

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        List<List<Integer>> result =  getAllSubSet( nums );

        for(List<Integer> subSet : result){
            System.out.print("[ ");
            for(int x : subSet){
                System.out.print(x+ " ");
            }
            System.out.println("] ");
        }
    }
    /* ˼·�ǣ�ÿ�ζ�����Ԫ�أ��������Ӽ���ʱ��Ч�ʽϸߣ����ǿռ����Ĵ� */
    public static List<List<Integer>> getAllSubSet(int[] array){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for( int i = 0 ;i < array.length ; i++){
            int num = result.size();
            for(int j = 0 ;j< num ; j ++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(array[i]);
                result.add(temp);
            }
        }
        return result;
    }
    public boolean hasCommomChar(String originString, String newString){
        if( originString == "" || originString == null ){
            return true;
        }
        int n = newString.length();
        for(int i = 0 ;i < n ;i ++){
            if(originString.contains(String.valueOf(newString.charAt(i)) ) ){
                return false;
            }
        }
        return true;
    }

}
