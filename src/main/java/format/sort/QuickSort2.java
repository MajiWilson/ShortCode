package format.sort;

/**
 * ��������
 */
public class QuickSort2 {
	public static void quickSort(int[] array){
		quickSort(array, 0, array.length-1);

	}
	public static void quickSort(int[] array, int left, int right){
		if( left < right){
			int p = partition(array, left, right);
			quickSort(array, left, p-1);
			quickSort(array, p+1, right);
		}
	}

	public static int partition(int[] array, int left, int right){
		// ���ұ�Ϊ��׼
		int pivot = array[right];
		while(left < right){
			if(array[left] > array[right]){
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
			}
			// �ж�����һ��ָ����pivot, ����һ��ָ�����м俿£
			if (array[left] == pivot) {
				right--;
			} else {
				left++;
			}
		}
		return left;
	}


}
