package format.sort;

/**
 * 希尔排序：
 */
public class ShellSort {

	public void shellSort(int[] array) {
		int j;
		for(int gap=array.length/2;gap > 0; gap/= 2){
			for(int i = gap; i < array.length; i++){
				int temp = array[i];
				for(j=i; j>=gap && temp < array[j-gap]; j-=gap){
					array[j] = array[j-gap];
				}
				array[j] = temp;
				for(int x:array)
					System.out.print(x+" ");
				System.out.println();
			}
		}
	}
}
