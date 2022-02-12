package tempWorkspace; /**
 * Class: box[]�е�box[i]��ʾ��i���������е�С�������
 * �������ٵ������ǵ����еĺ����е���Ŀ��ͬ��
 * ˼·��������Ȼ�����һ�μ��ɣ������������������£���¼���Բ����λ�ã��Լ��ظ���Ԫ�أ���Ҫ�޸ĵģ�
 * Ȼ��˳��һ�����ƣ�������ʹ�ÿ��Բ����λ�ã����еĻ��������ֵ��������ȡֵ���ɣ�
 *
 * * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/6 , 18:05
 */
import java.util.*;
public class Array_3_MakeBoxDifferent{

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int n = in.nextInt();
        int[] box = new int[n];
        for( int i = 0 ; i < n ; i++){
            box[i] = in.nextInt();
        }
        Arrays.sort( box );
        int sum = 0 ;
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> value = new ArrayList<>();
        int foreBox = box[0];
        for(int i = 1 ; i<n ; i++){
            if(box[i] - box[i-1] >=2){
                for( int j = box[i-1]+1; j<box[i] ; j++){
                    list.add(j);
                }
            }
            if( box[i] == foreBox){
                value.add(box[i]);
            }
            else{
                foreBox = box[i];
            }
        }
        int accValue = box[n-1]+1;
        for( int x : value){
            if(!list.isEmpty()){
                sum += list.get(0) - x ;
                list.remove(0);
            }
            else{
                sum += accValue-x;
                accValue++;
            }
        }
        System.out.println( sum );

    }

}



