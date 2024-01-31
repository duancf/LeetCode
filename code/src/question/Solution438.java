package question;

import java.util.*;

/**
 * @author duancf
 * @version 1.0
 * @date created in 2023年10月13日 10:43
 * @since 1.0
 */
public class Solution438 {

    public static List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()){
            return new ArrayList();
        }
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        List<Character> pList = new ArrayList<>();
        for (char c : pArr) {
            pList.add(c);
        }
        List<Character> sList = new ArrayList();
        List<Integer> result = new ArrayList();
        for(int i = 0; i < pArr.length; i++){
            sList.add(sArr[i]);
        }
        for(int i = 0; i < sArr.length; i++){
            if(charQuery(sList, pList)){
                result.add(i);
            }
            sList.remove(0);
            if(i + p.length() < sArr.length){
                sList.add(sArr[i + p.length()]);
            } else{
                return result;
            }
        }
        return result;
    }

    private static boolean charQuery(List<Character> s, List<Character> p){
        if(s.size() != p.size()){
            return false;
        }
        List<Character> tmp = new ArrayList<>(s);
        for(Character c : p){
            if(tmp.isEmpty()){
                return false;
            }
            if(tmp.contains(c)){
                tmp.remove(tmp.indexOf(c));
            } else{
                return false;
            }
        }
        if(tmp.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s, p));
    }
}
