package algrithm;
import java.util.PriorityQueue;
class Item implements Comparable<Item>{//ʵ��Comparable�ӿ�
	int weight;//�ýڵ�Ŀǰ�����е�����
	double value;//�ýڵ�Ŀǰ�����е��ܼ�ֵ
	double ceiling;//�ýڵ��ܹ��ﵽ�ļ�ֵ�Ͻ�
	int Left; 	//�ýڵ��Ƿ�������ڵ�
	int level;  //�ýڵ��ǵڼ�����Ʒ��ѡ�񣬲�
	Item father; //�ýڵ�ĸ��ڵ�
	@Override
	public int compareTo(Item x){
		if(this.ceiling < x.ceiling)
			return 1; 
		else if(this.ceiling == x.ceiling)
			return 0;
		else
			return -1;
	}
}

public class BackBag01 {

	private int n = 8;
	private int capacity = 20;
	private int[] weight = new int[n];
	private int[] value = new int[n];
	private int maxValue = 0;
	private int[] bestPlan =new int[n];
	
	public BackBag01() {//���췽��
		for(int i=0;i<n;i++)
			weight[i]=(int)(Math.random()*10)+1;
		for(int i=0;i<n;i++)
			value[i]=(int)(Math.random()*10)+1;
	}
	public int getCapacity() {
		return capacity;
	}
	
	public int getN() {
		return n;
	}
	
	public int[] getPlan() {
		return bestPlan;
	}
	
	public int[] getWeight() {
		return weight;
	}
	
	public int[] getValue() {
		return value;
	}
	
	public void getMaxValue(){
		PriorityQueue<Item> queue = new PriorityQueue<>();//ʹ�����ȶ���
		//����һ����ʼ���ڵ㣬����-1��
		Item initial = new Item();
		initial.level = -1;
		initial.ceiling = 0;
		queue.offer(initial);//���
		while(!queue.isEmpty()){//�ӷǿ�
			Item father = queue.poll();//���Ӳ�ɾ��
			//���Ѿ�������Ҷ�ӽڵ�ʱ
			if(father.level == n-1){
				if(father.value > maxValue){
					maxValue = (int)father.value;
					for(int i=n-1;i>=0;i--){
						bestPlan[i] = father.Left;
						father= father.father;
					}
				}	
			}
			else{
				//��ͳ������ڵ���Ϣ���ж��Ƿ������С�
				if(weight[father.level+1]+father.weight <= capacity){
					Item newNode = new Item();
					newNode.level = father.level+1;
					newNode.value = father.value + value[father.level+1];
					newNode.weight = weight[father.level+1]+father.weight;
					newNode.ceiling = limit(newNode);
					newNode.father = father;
					newNode.Left = 1;
					if(newNode.ceiling > maxValue)//�޽�
						queue.offer(newNode);
				}
				//���ҽڵ����������ܹ�ȡ���ļ�ֵ�Ͻ�ͨ�����׽ڵ���Ͻ��ȥ������Ʒ�ļ�ֵ��
				if((father.ceiling - value[father.level+1])> maxValue){
					Item newNode = new Item();
					newNode.level = father.level+1;
					newNode.value = father.value;
					newNode.weight = father.weight;
					newNode.father = father;
					newNode.ceiling = father.ceiling - value[father.level+1];
					newNode.Left = 0;
					queue.offer(newNode);
				}
			}
		}
	}
	//���ڼ���ýڵ����߼�ֵ�Ͻ�
	
	public double limit(Item no){
		double maxLeft = no.value;
		int remainWeight = capacity - no.weight;
		int templevel = no.level;
		//�����ȡ��ֱ������Ϊֹ��
		while(templevel <= n-1 && remainWeight > weight[templevel] ){
			remainWeight -= weight[templevel];
			maxLeft += value[templevel];
			templevel++;
		}
		//����װʱ������һ����Ʒ�ĵ�λ������ֵ���㵽ʣ��ռ䡣
		if( templevel <= n-1){
			maxLeft += value[templevel]/weight[templevel]*remainWeight;
		}
		return maxLeft;
	}

	public static void main(String[] args){
		BackBag01 x = new BackBag01();
		System.out.println("�����������ͼ�ֵ��");
		for(int i =0;i<x.getN();i++) {
			System.out.println(x.getWeight()[i]+" : "+x.getValue()[i]);
		}
		
		x.getMaxValue();
		System.out.println("�����������ǣ�"+x.getCapacity());
		System.out.println("�ܹ��õ�������ֵ��:"+x.maxValue);
		System.out.println("����Ϊ:");
		for(int i=0;i<x.getN();i++)
			System.out.print(x.getPlan()[i]+"  ");

	}

}


