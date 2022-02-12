package format.dp;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class CoverArea {

    /**
     * 递归算法：时间复杂度教较高
     */
    private int count = 0;
    public int rectCover(int target) {
        if(target <= 0){
            return 0;
        }
        cover(target, 1);
        return count;
    }
    public void cover(int n , int i){
        if( i > n){
            count++;
            return;
        }
        cover(n ,i+1);
        if((n - i + 1 )/2 >0){
            cover(n, i+2);
        }
    }

    /**
     * 动态规划：实际上这也是个斐波那契数列的变形，
     */
    public int rectCover2(int n) {
        if (n==0 || n==1 || n==2)
            return n;
        int a = 1, b = 2, c = 0;
        for (int i=3; i<=n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
