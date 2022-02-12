package tempWorkspace;

import java.util.LinkedHashMap;

/**
 * Class: �Ľ�������
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/12 , 10:57
 */
public class BackTracking_4_WordFinding2 {
    public static void main(String[] args){
        char[][] letters = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
                {'C', 'H', 'E', 'K'}
        };
        String word = "ABCCED";
        System.out.println( exist(letters,  word) );

    }
    public static boolean exist(char[][] letters, String word){
        for(int i = 0 ; i < letters.length; i++){
            for( int j = 0 ; j< letters[0].length ; j++){
                if( findWord(letters, word, i, j , 0)){
                    return true;
                }
            }
        }
        return false;
    }
    /* ˼·�� ֻҪ�ҵ���ֹͣ�����ˣ�Ȼ��Ϊ�˱����Ѿ����ʹ�����ͬһ�λ��ݹ����б��ظ����ʣ���·���ϵ����еĽڵ㶼����Ϊ �Ǻţ�
    ��Ȼ�ڱ��λ���һ�Ժ�����ָ����Լ����´����¿�ʼ�Ļ���*/
    public static boolean findWord( char[][] letters, String word, int row, int col , int index ){
        char letter = word.charAt(index);
        if(letter != letters[row][col]){
            return false;
        }
        if( index == word.length()-1 ) {
            return true;
        }
        letters[row][col] = '*';
        boolean alreadyFind = false;
        if( !alreadyFind && row - 1 >= 0 && letters[row - 1][col] != '*'){
            alreadyFind = findWord(letters, word, row-1, col, index+1);
        }
        if( !alreadyFind && row + 1 < letters.length  && letters[row + 1][col] != '*'){
            alreadyFind = findWord(letters, word, row+1, col, index+1);
        }
        if( !alreadyFind && col - 1 >= 0 && letters[row][col-1] != '*'){
            alreadyFind = findWord(letters, word, row, col-1, index+1);
        }
        if( !alreadyFind && row + 1 < letters[0].length && letters[row][col+1] != '*'){
            alreadyFind = findWord(letters, word, row, col+1, index+1);
        }

        letters[row][col] = word.charAt(index);
        return alreadyFind;
    }

}
