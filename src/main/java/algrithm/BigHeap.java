package algrithm;
import java.util.*;
public class BigHeap<T extends Comparable<T>> {
	private ArrayList<T> list = new ArrayList<>();
	
	public BigHeap(){}
	public BigHeap(T[] array){
		for(int i= 0;i<array.length;i++)
			push(array[i]);
		heapSort(array);
		
	}
	public void heapSort(T[] array) {
		for(int i =array.length-1;i>=0;i--) {
			array[i]= pop();
		}
	}
	
	public void push(T x) {
		
		
		list.add(x);
		int currentIndex = list.size()-1;//�ѵ����Ԫ�ص�������
		while(currentIndex>0) {
			int parentIndex = (currentIndex-1)/2;
			if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				T temp =list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else
				break;
			currentIndex = parentIndex;
		}	
	}
	
	public T peek() {//ȡ�Ѷ�Ԫ�أ������ֵ
		return list.get(0);
	}
	
	public T pop() {//ȡ�Ѷ�Ԫ�أ���ɾ����
		if(list.size()==0)
			return null;
		T peek = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		//�����һ��Ԫ���滻����ɾ��������������µ���
		int currentIndex =0;
		while(currentIndex < list.size()){
			int tempMax =currentIndex;
			int leftChildIndex = currentIndex*2+1;
			int rightChildIndex = currentIndex*2+2;
			if(leftChildIndex>list.size()-1)
				break;//��������
			if(list.get(leftChildIndex).compareTo(list.get(tempMax))>0)
				tempMax= leftChildIndex;
			if(rightChildIndex>list.size()-1)
				break;//��������
			if(list.get(rightChildIndex).compareTo(list.get(tempMax))>0)
				tempMax= rightChildIndex;
			if(tempMax != currentIndex) {
				T temp =list.get(currentIndex);//����
				list.set(currentIndex, list.get(tempMax));
				list.set(tempMax, temp);
				currentIndex =tempMax;
			}
			else
				break;//�����Ƚ�
		}
		return peek;
	}
	
	public int size() {
		return list.size();
	}
}
