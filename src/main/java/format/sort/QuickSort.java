package format.sort;

/**
 * ��������
 */
public class QuickSort {

	/**
	 * ����ӿ�
	 * @param array
	 */
	public static void quickSort(int[] array){
		quickSort(array, 0, array.length-1);
	}

	/**
	 * ���η�: ע��λ��p��������������Ƚϣ��Ѿ�������λ�ã�
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void quickSort(int[] array, int left, int right){
		if(left < right){
			int p = partition(array, left, right);
			quickSort(array, left, p-1);
			quickSort(array, p+1, right);
		}
	}

	/**
	 * ����λ��ȷ��:
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static int partition(int[] array, int left, int right){
		//����ָ��
		int i = left;
		//���һ��С��Ƚ�ֵ��λ��
		int j = left-1;
		// �Ƚ�ֵѡ������ֵ:���ֵ������뽻���������Ҫ�ŵ��м�
		int compareNum = array[right];

		while(i < right){
			if(array[i] <  compareNum){
				j++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
			i++;
		}
		// ȷ����λ**
		j++;
		array[right] = array[j];
		array[j] = compareNum;
		return j;
	}




}
