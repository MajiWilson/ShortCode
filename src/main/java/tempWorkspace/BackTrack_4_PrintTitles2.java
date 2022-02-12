package tempWorkspace;

import java.util.Arrays;

/**����ӡˢ
 * Class:����һ�׻�����ģ tiles������ÿ����ģ�϶�����һ����ĸ tiles[i]�����������ӡ���ķǿ���ĸ���е���Ŀ��
 * "AAB"
 * "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"
 * 8
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/13 , 16:07
 */
public class BackTrack_4_PrintTitles2 {
    private static int answer = 0;
    public static void main(String[] args){
        String s = "AAB";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        backtrack(chars, visited, 0);
        System.out.println(answer);
    }
    public static void backtrack(char[] chars, boolean[] visited, int len) {
        if (len == chars.length) {
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            answer++;
            backtrack(chars, visited, len + 1);
            visited[i] = false;
        }
    }



}
