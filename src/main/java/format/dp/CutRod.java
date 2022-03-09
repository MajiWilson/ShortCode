package format.dp;

import java.util.Arrays;

/**
 * Class: һ�����������ĳ��ȣ���λ���������Ǯ��
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 22:08
 */
public class CutRod {

    private static int[] r = new int[25];

    private static int[] price ={0,
            1,5,8,9,10,17,19,20,24,30,
            35,40,47,50,58,60,69,70,80,85,
            89,90,94,95,100
    };

    public static void main(String[] args) {

        int n =24;
        Arrays.fill(r, -1);
        int best1 = cutRod(n);
        System.out.println(n+": "+best1);
        int best2 = cutRod2(n);
        System.out.println(n+": "+best2);
        int best3 = cutRod3(n);
        System.out.println(n+": "+best3);

    }
    /**
     * ������⣬�ݹ飬 �ظ���������û���Ż� ʱ��Ч�ʽϲ�
     * */
    public static int cutRod(int n) {
        if(n == 0)
            return 0;
        int tempMax = 0;
        for(int i =1 ; i<=n; i++) {
            int temp = price[i]+cutRod(n-i);
            if(temp > tempMax)
                tempMax = temp;
        }
        return tempMax ;
    }

    /**
     * ��Ȼ�ǵݹ��㷨�� �ݹ�ʱ���ж��������Ƿ��Ѿ�����ˣ��������˾�ֱ�ӻ�ȡ�����ټ������������Զ����µķ���
     */
    public static int cutRod2(int n) {
        if(r[n]>=0) {
            return r[n];
        }
        if(n==0) {
            return 0;
        }
        else {
            int tempMax = -1;
            for(int i = 1; i <= n; i++) {
                int temp = price[i] + cutRod(n-i);
                if(temp > tempMax )
                    tempMax = temp;
            }
            r[n] = tempMax;
            return tempMax;
        }

    }
    /**
     * ��̬�滮�� ������¼���������Ž⣬����ȡ�Ե����ϵķ�����ʵ��, ���Ա���ݹ�
     * */
    public static int cutRod3(int n) {
        int[] record = new int[n+1];
        Arrays.fill(record, 0);
        for( int i = 1; i <= n ; i++){
            int tempMax = 0;
            for(int j = 1 ; j<= i; j++){
                int temp = price[j] + record[i-j];
                tempMax = tempMax > temp ? tempMax : temp;
            }
            record[i] = tempMax;
        }
        return record[n];
    }

}
