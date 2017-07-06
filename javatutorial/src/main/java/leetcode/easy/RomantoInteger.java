package leetcode.easy;

/**
 * Created by zhaoyi on 17-6-29.
 */
public class RomantoInteger {
    //I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
    public static int romanToInt(String s) {
        Character I = 'I';
        Character V = 'V';
        Character X = 'X';
        Character L = 'L';
        Character C = 'C';
        Character D = 'D';
        Character M = 'M';
        int result = 0;
        if (s.equals("IIII")){
            return 4;
        }
        for (int i = 0; i < s.length(); i++) {
            if (I.equals(s.charAt(i))){
                if ((i==s.length()-1)){
                    result += 1;
                }else if (V.equals(s.charAt(i+1))||X.equals(s.charAt(i+1))){
                    result += -1;
                }else
                    result += 1;
            }else if (X.equals(s.charAt(i))){
                if ((i==s.length()-1)){
                    result += 10;
                }else if (L.equals(s.charAt(i+1))||C.equals(s.charAt(i+1))){
                    result += -10;
                }else
                    result += 10;
            }else if (C.equals(s.charAt(i))){
                if ((i==s.length()-1)){
                    result += 100;
                }else if (D.equals(s.charAt(i+1))||M.equals(s.charAt(i+1))){
                    result += -100;
                }else
                    result += 100;
            }else if (V.equals(s.charAt(i))){
                result += 5;
            }else if (L.equals(s.charAt(i))){
                result += 50;
            }else if (D.equals(s.charAt(i))){
                result += 500;
            }else if (M.equals(s.charAt(i))){
                result += 1000;
            }else
                return  0;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "MMMCMXCIX";
        System.out.println(romanToInt(s));
    }
}
