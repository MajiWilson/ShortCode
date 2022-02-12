package algrithm;//�㷨ʱ�临�Ӷ�λn3/2 /logn  ����������һ������һ�����Ա�һ���������������ʣ�������
import java.util.*;
public class EfficientPrimeNumber {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int n = input.nextInt();
		
		List<Integer> list =new ArrayList<>();
		final int NUMBER_PER_LINE =10;
		int count =0;
		int number =2;
		int squareRoot =1;
		System.out.println("С�ڸ���ֵ������������");
		while(number <= n) {
			boolean isPrime =true;
			if(squareRoot*squareRoot < number)
				squareRoot++;
			for(int k =0;k<list.size() && list.get(k)<=squareRoot;k++) {
				if(number%list.get(k) == 0) {
					isPrime =false;
					break;
				}
			}
			if(isPrime) {
				count++;
				list.add(number);
				if(count % NUMBER_PER_LINE==0) {
					System.out.println(number);
				}
				else {
					System.out.print(number+" ");
				}
			}
			 number++;
		}
		System.out.println("����"+count+"������");
		input.close();
	}

}
