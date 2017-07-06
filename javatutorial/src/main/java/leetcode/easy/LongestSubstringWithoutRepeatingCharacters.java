package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaoyi on 17-6-27.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
/*        HashMap<Character,Integer> ss = new HashMap();
        int j = 0;
        int k = s.length()!=0?1:0;
        for (int i = 0; i < s.length(); i++) {
            if (ss.containsKey(s.charAt(i))){
                j=ss.get(s.charAt(i));
                i=j+1;
                k=ss.size()>k?ss.size():k;
                ss.clear();
            }
            ss.put(s.charAt(i),i);
        }
        k=ss.size()>k?ss.size():k;
        return k;*/
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
    public static void main(String[] args) {
        String a = new String("wwpwwwpwkew");
        System.out.println(lengthOfLongestSubstring(a));
    }

}
