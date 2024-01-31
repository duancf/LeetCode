package question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duancf
 * @version 1.0
 * @date created in 2024年01月30日 11:06
 * @since 1.0
 */
public class Solution79 {

    public static boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, wordArr, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, int bi, int bj, char[] w, int wi, List<String> list){
        if(wi == w.length - 1 && w[wi] == board[bi][bj]){
            return true;
        }
        if(board[bi][bj] != w[wi]){
            return false;
        }
        list.add("row" + bi + "col" + bj);
        boolean resultFlag = false;
        if(bi + 1 < board.length && !list.contains("row" + (bi + 1) + "col" + bj)) {
            resultFlag = resultFlag || exist(board, bi + 1, bj, w, wi + 1, new ArrayList<>(list));
        }
        if(bj + 1 < board[0].length && !list.contains("row" + bi + "col" + (bj + 1))){
            resultFlag = resultFlag || exist(board, bi, bj + 1, w, wi + 1, new ArrayList<>(list));
        }
        if(bi - 1 >= 0 && !list.contains("row" + (bi - 1) + "col" + bj)) {
            resultFlag = resultFlag || exist(board, bi - 1, bj, w, wi + 1, new ArrayList<>(list));
        }
        if(bj - 1 >= 0 && !list.contains("row" + bi + "col" + (bj - 1))) {
            resultFlag = resultFlag || exist(board, bi, bj - 1, w, wi + 1, new ArrayList<>(list));
        }
        return resultFlag;


    }

    public static boolean dfs(char[][] board, int bi, int bj, char[] w, int wi){
        if(bi >= board.length || bi < 0 || bj >= board[0].length || bj < 0 || wi >= w.length || w[wi] != board[bi][bj]){
            return false;
        }
        if(wi == w.length-1){
            return true;
        }
        board[bi][bj] = '#';
        boolean res = dfs(board, bi-1, bj, w, wi+1) || dfs(board, bi+1, bj, w, wi+1)
                || dfs(board, bi, bj-1, w, wi+1) || dfs(board, bi, bj+1, w, wi+1);
        board[bi][bj] = w[wi];
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'}};
        String word = "AAAAAAAAAAAAAAa";
        System.out.println(exist(board, word));
    }
}
