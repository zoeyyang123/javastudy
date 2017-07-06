package leetcode.easy;

/**
 * Created by zhaoyi on 17-6-29.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer result = new StringBuffer();
        int strsLength = strs.length;
        if (strsLength==0)
            return "";
        else if (strsLength==1)
            return result.append(strs[0]).toString();
        else {
            int maxLength = strs[0].length();
            for (int i = 1; i < strsLength; i++) {
                int temp = strs[i].length();
                maxLength = maxLength>temp?temp:maxLength;
            }
            boolean flag1 = false;
            for (int j = 0; j < maxLength; j++) {
                Character temp = strs[0].charAt(j);
                for (int k = 1; k < strsLength; k++) {
                    if (!temp.equals(strs[k].charAt(j))){
                        flag1 = true;
                        break;
                    }
                }
                if (flag1) {
                    break;
                }else {
                    result.append(temp);
                }
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        String[] strs1 = new String[3];
        strs1[0] = "babc";
        strs1[1] = "cabcdefg";
        strs1[2] = "abxyz";
        String[] strs2 = new String[1];
        strs2[0] = "";
        String[] strs3 = new String[0];
        System.out.println("结果："+longestCommonPrefix(strs3));
    }
}
