package format.sort;

/* 选择指定顺序的数值*/
/* 期望时间O（N）*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class RandomizedSelect {

	public int select(int[] array, int rank){
		return select(array, 0, array.length -1, rank);
	}

	/**
	 * 结合partition 算法，类似于二分，并且不会重复遍历， 所以时间为O（ n ）
	 */
	public int select(int[] array,int left,int right,int rank) {
		if(left == right) {   //找到
			return array[left];
		}
		int p = partition(array, left, right);
		int k = p-left+1;
		if(k==rank)
			return array[p];
		else if(k < rank) {
			 return select(array,p+1,right,rank-k);
		}
		else
			 return select(array,left,p-1,rank);
		
	}
	
	public int partition(int[] array,int left,int right) {
		int pivot = array[right];
		int i = left-1;
		int j =left;
		for(; j <= right-1; j++) {
			if(array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] =array[j];
				array[j] = temp;
			}
		}
		i++;
		array[j] = array[i];
		array[i]=pivot;
		return i;
	}

	/**
	 * 方法2： 借助大根堆, 时间复杂度较高， nlog(k)
	 */
	public int select2(int[] array, int k){
		PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
		for(int i = 0; i< k; i++){
			heap.offer(array[i]);
		}
		for(int i = k; i< array.length; i++){
			heap.offer(array[i]);
			heap.poll();
		}
		for(int i = 0 ;i < k-1; i++){
			heap.poll();
		}
		return heap.poll();
	}

}
