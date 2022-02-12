package format.sort;//属于交换排序


/**
 * 升序的冒泡排序算法
 */

public class BubbleSort{

	public BubbleSort(int[] array) {
		bubbleSort(array);
	}

	/**
	 * flag 用户及时停止， 避免无必要的比较 时间复杂度为 o(n2)
	 */
	public void bubbleSort(int[] array) {
		boolean flag = true;
		for( int i =0; i < array.length-1 && flag; i++ ) {    // n-1 轮
			flag =false;
			for( int j =0; j < array.length-i-1; j++ ){  //每次比较 n- i 次
				if( array[j] > array[j+1]) {
					int temp = array[j];
					array[j] =array[j+1];
					array[j+1] =temp;
					flag =true;
				}
			}
		}
	}

}
