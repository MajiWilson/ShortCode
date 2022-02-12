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
		int i = left; // 遍历指针
		int j = left -1; //最后一个小于比较值的指针
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
			if(array[left] > array[right]){	// 交换， 其中一个指针失踪值得是pivot
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
			}
			if (array[left] == pivot) {		// 判断是哪一个指针是pivot, 则另一个指针向中间靠拢
				right--;
			} else {
				left++;
			}
		}
		return left;
	}


}
