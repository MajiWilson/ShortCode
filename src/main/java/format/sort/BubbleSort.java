package format.sort;//���ڽ�������


/**
 * �����ð�������㷨
 */

public class BubbleSort{

	public BubbleSort(int[] array) {
		bubbleSort(array);
	}

	/**
	 * flag �û���ʱֹͣ�� �����ޱ�Ҫ�ıȽ� ʱ�临�Ӷ�Ϊ o(n2)
	 */
	public void bubbleSort(int[] array) {
		boolean flag = true;
		for( int i =0; i < array.length-1 && flag; i++ ) {    // n-1 ��
			flag =false;
			for( int j =0; j < array.length-i-1; j++ ){  //ÿ�αȽ� n- i ��
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
