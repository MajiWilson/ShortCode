package format.sort;

/**
 * Class: 计数排序
 * 数字在一定范围内；
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/27 , 21:47
 */
public class CountSort {
    public int N = 100;

    public void countSort(int[] array){
        int[] count = new int[N];    // 空间复杂度O（N）
        int n = array.length;
        for(int i = 0; i< N ;i ++){  // 初始化为0 ，java中也可以省略
            count[i] = 0;
        }
        for(int i = 0 ; i< n; i++){  // 计数
            count[array[i]]++;
        }
        for(int i =1 ;i< N ;i++){    // 累加
            count[i] += count[i-1];
        }
        int[] result = new int[n];
        for(int i =0;i< n ;i++){     // 输出
            result[ count[ array[i] ] -1 ]  = array[i];   // 注意个数 与 序号的细节
            count[array[i]]--;
        }
        for(int i = 0; i< n ;i++){   // 覆盖
            array[i] =result[i];
        }
    }
}
