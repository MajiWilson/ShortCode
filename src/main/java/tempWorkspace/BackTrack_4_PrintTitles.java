package tempWorkspace;

import java.util.HashSet;
import java.util.Set;

/**����ӡˢ
 * Class:����һ�׻�����ģ tiles������ÿ����ģ�϶�����һ����ĸ tiles[i]�����������ӡ���ķǿ���ĸ���е���Ŀ��
 * "AAB"
 * "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"
 * 8
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/13 , 12:23
 */
public class BackTrack_4_PrintTitles {
    public static void main(String[] args){
        String s = "AAB";
        System.out.println( solution(s));
    }
    /* ˼·�� ��һ����ݷ����õ�˳����ִ���Ȼ��������е�ÿһ���ַ���������1������ȫ���У�����set���ظ����ص㣬���set�е�Ԫ��Ϊ���*/
    public static int solution(String s){
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        backTrack(s, sb,0, set);
        sb = new StringBuilder();
        Set<String> set2 = new HashSet<>();
        for(String str : set){
            if(str.length() > 1 ){
                sb.delete(0, sb.length());
                allRange( str.toCharArray(),0, set2);
            }
        }
        set.addAll(set2);
        return set.size();
    }
    public static void backTrack(String s , StringBuilder sb, int k, Set<String> set){
        if( k == s.length() ){
            if(sb.length()!= 0 ){
                System.out.println(sb.toString());
                set.add(sb.toString());
            }
        }
        else{
            sb.append(s.charAt(k));
            backTrack(s, sb, k+1, set);
            sb.deleteCharAt(sb.length()-1);
            backTrack(s, sb, k+1, set);
        }

    }
    public static void allRange(char[] letters , int k , Set<String> set){
        if( k == letters.length ){
            String s = new String(letters);
            System.out.println("all "+ s );
            set.add( s ) ;
        }
        else{
            for( int i = k; i< letters.length ; i++){
                char temp = letters[k];
                letters[k] = letters[i];
                letters[i] = temp;

                allRange(letters, k+1, set);

                temp = letters[k];
                letters[k] = letters[i];
                letters[i] = temp;
            }
        }
    }




}
