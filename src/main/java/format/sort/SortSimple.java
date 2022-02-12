package format.sort;

public class SortSimple {

	public static void main(String[] args) {
		int n =100;
		int[] array = new int[n];
		for(int i =0;i<n;i++) {//输出排序前的数组
			array[i] =(int)( Math.random()*100);
			System.out.printf("%3d",array[i]);
			if(i%20 ==19) {
				System.out.println();
			}
		}
		System.out.println();



		System.out.println(new RandomizedSelect().select(array, 10));
		new CountSort().countSort(array);


		for(int i =0;i<n;i++) {
			System.out.printf("%3d",array[i]);
			if(i%20 ==19) {
				System.out.println();
			}
		}
		System.out.println();

	}


}
