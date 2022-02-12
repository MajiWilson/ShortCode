package tempWorkspace;

/**
 * Class: ʹ�ö�̬�滮���������
 * ���Ž�������i- m ֮�����С����������ĳ�������������� �� i - k �� k -m ��������������С�������ҵ���Сֵ��
 * ��֯�ṹ����ά���飬m[i][j]��ʾ�� i �� j ����С���裻
 * �ݹ鷽�̣� �� i== j : m[i][j] = 0 ;
 *           �� i < j : m[i][j] = Min{ m[i][k] + m[k+1][j] + p[i-1]*p[k+1]*p[j] } ���� i <= k <j
 * </>
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 10:32
 */
public class DP_3_MatrixChain2 {
    private static int N = 20;
    private static int[] p = {5,10,3,12,5,50,6,7,10,20,28,2,12,5,3,12,23,33,2,12,2,};

    public static void main(String[] args) {
        int result = matrixChainOrder();
        System.out.println(result);
    }
    /* �Ե����ϼ��㣬�ö�ά�������洢�Ѿ�������������⣬ ���õݹ飬ʱ�临�Ӷ� O��3^n�� */
    public static int matrixChainOrder() {
        int n = p.length - 1 ;
        int[][] cost = new int[n+1][n+1]; // cost[i][j] ��ʾ�ӵ� i �����󵽵� j ��������Ҫ�˷��Ĵ���
        for( int i = 0 ;i <= n ; i ++ ){
            cost[i][i] = 0;
        }
        for(int i = 1 ; i <= n ; i ++){
            for( int j = i-1; j >= 1 ; j--){
                int multiMax = Integer.MAX_VALUE;
                for( int k = j; k< i ;k++){
                    int temp = cost[j][k] + cost[k+1][i] + p[j-1]*p[k]*p[i];
                    multiMax = temp < multiMax ? temp : multiMax;
                }
                cost[j][i] = multiMax;
            }
        }
        print(cost);
        return cost[1][n];
    }

    public static void print(int[][] array){
        for( int i= 0 ;i < array.length; i ++ ){
            for(int j = 0 ;j < array[0].length; j ++){
                System.out.print(array[i][j] + "            ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
