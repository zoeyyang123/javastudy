package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-7.
 */
public class LengthofLastWord {
    public static int lengthOfLastWord(String s) {
        int i = s.length();
        int max =0;
        while (i>0){
            if (s.charAt(i-1)!=' ') max++;
            else {
                if (max!=0)
                    break;
            }
            i--;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("    asdf  asdfa   "));
    }
}
