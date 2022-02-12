package format.sort;

public class QuickSort {
	public void quickSort(int[] array){
		quickSort(array, 0, array.length-1);

	}
	public void quickSort(int[] array, int left, int right){
		if( left < right){
			int p = partition(array, left, right);
			quickSort(array, left, p);
			quickSort(array, p+1, right);
		}
	}

	public int partition(int[] array, int left, int right){
		int i = left; // ����ָ��
		int j = left -1; //���һ��С�ڱȽ�ֵ��ָ��
		int pivot = array[right];
		while(i < right){
			if(array[i] < pivot){
				j++;
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
			}
			i++;
		}
		j++;
		array[right] = array[j];
		array[j] = pivot;
		return j;
	}

	public int partition2(int[] array, int left, int right){
		int pivot = array[right];
		while(left < right){
			if(array[left] > array[right]){	// ������ ����һ��ָ��ʧ��ֵ����pivot
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
			}
			if (array[left] == pivot) {		// �ж�����һ��ָ����pivot, ����һ��ָ�����м俿£
				right--;
			} else {
				left++;
			}
		}
		return left;
	}


}
