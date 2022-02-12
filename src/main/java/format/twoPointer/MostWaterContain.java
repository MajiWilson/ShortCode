package format.twoPointer;

/**给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * @Author maojianwei
 * @Date 2020/8/10 18:24
 **/
public class MostWaterContain {

    /* 双指针法，首先以数组边界作为容器，然后哪边小就丢掉那边，这里可以证明这样是正确的 直到重合*/
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length -1;
        int max = Integer.MIN_VALUE;
        while( i < j){
            int volume = Math.min(height[i], height[j])*(j-i);
            max = max < volume ? volume : max;
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return max;
    }

}
