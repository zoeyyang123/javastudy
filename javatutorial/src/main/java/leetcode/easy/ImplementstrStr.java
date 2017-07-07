package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-6.
 */
public class ImplementstrStr {
    public static int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);
        //直接调用90.96%,偶尔也会掉到69%
        int haystackSize = haystack.length();
        int needleSize = needle.length();
        if (needleSize==0) return 0;
        if (haystackSize<needleSize) return -1;
        boolean flag;
        for (int i = 0; i <haystackSize-needleSize+1 ; i++) {
            flag = true;
            for (int j = 0; j < needleSize; j++) {
                if (haystack.charAt(i+j)!=needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
        //自己写的61.83%
    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        System.out.println(strStr(haystack,needle));
    }
}
