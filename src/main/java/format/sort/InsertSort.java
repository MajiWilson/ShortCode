package format.sort;

/**
 * ��������ÿ��ǰ��һ����֮ǰ�����ж��������
 * */

public class InsertSort{
	
	public static void insertSort(int[] array) {
		//��һ����������
		for(int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j;
			for(j = i-1; j >=0 && array[j] > temp; j--) {  // �ҵ���һ��С�ڵ��� temp �Ľڵ㣬֮ǰ�����ƶ�
				array[j+1]= array[j];
			}
			array[j+1]=temp;
		}
	}
	

}
