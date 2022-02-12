package ds_type.set;
import java.util.*;

public class PerformanceCompair {
	static final int N = 50000;

	public static void main(String[] args) {
		
		List<Integer> list =new ArrayList<>();
		for(int i =0;i<N;i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		
		Collection<Integer> set1 =new HashSet<Integer>(list);
		System.out.print("Number Test time for HashSet:");
		System.out.println(getTestTime(set1)+"����");
		System.out.print("Remove Test time for HashSet:");
		System.out.println(getRemoveTime(set1)+"����");
		
		Collection<Integer> set2 =new LinkedHashSet<Integer>(list);
		System.out.print("Number Test time for LinkedHashSet:");
		System.out.println(getTestTime(set2)+"����");
		System.out.print("Remove Test time for LinkedHashSet:");
		System.out.println(getRemoveTime(set2)+"����");
		
		Collection<Integer> set3 =new TreeSet<Integer>(list);
		System.out.print("Number Test time for TreeSet:");
		System.out.println(getTestTime(set3)+"����");
		System.out.print("Remove Test time for TreeSet:");
		System.out.println(getRemoveTime(set3)+"����");
		
		Collection<Integer> set4 =new ArrayList<Integer>(list);
		System.out.print("Number Test time for ArrayList:");
		System.out.println(getTestTime(set4)+"����");
		System.out.print("Remove Test time for ArrayList:");
		System.out.println(getRemoveTime(set4)+"����");
		
		Collection<Integer> set5 =new LinkedList<Integer>(list);
		System.out.print("Number Test time for LinkedList:");
		System.out.println(getTestTime(set5)+"����");
		System.out.print("Remove Test time for LinkedList:");
		System.out.println(getRemoveTime(set5)+"����");

	}
	public static long getTestTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		for(int i =0;i<N;i++) {
			c.contains((int)Math.random()*2*N);
		}
		return System.currentTimeMillis()-startTime;
	}
	public static long getRemoveTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		for(int i =0;i<N;i++) {
			c.remove(i);
		}
		return System.currentTimeMillis()-startTime;
	}
	

}
