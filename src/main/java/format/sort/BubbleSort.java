package format.sort;//���ڽ�������


/**
 * �����ð�������㷨
 */

public class BubbleSort{

	public static void BubbleSort(int[] array) {
		bubbleSort(array);
	}

	/**
	 * flag �û���ʱֹͣ�� �����ޱ�Ҫ�ıȽ� ʱ�临�Ӷ�Ϊ o(n2)
	 */
	public static void bubbleSort(int[] array) {
		boolean flag = false;

		// ���ѭ��Ӧ���Ǵ����ұ�����������С��ÿһ�ζ��ǽ����̶�
		for(int i = array.length-1; i>0 && !flag; i--){
			flag = true;
			for(int j = 0; j <= i-1; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = false;
				}
			}
		}

	}

}
