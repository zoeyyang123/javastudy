package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-7.
 */
public class CountandSay {
    public static String countAndSay(int n) {
        if (n==1) return "1";
        String input = countAndSay(n-1);
        int inputSize = input.length();
        Character temp = input.charAt(0);
        int num = 1;
        StringBuffer outPut = new StringBuffer();
        for (int i = 1; i < inputSize; i++) {
            Character inputIChar = input.charAt(i);
            if (inputIChar==temp){
                num++;
            }else {
                outPut.append(Integer.toString(num));
                outPut.append(temp);
                num = 1;
                temp = inputIChar;
            }
        }
        outPut.append(Integer.toString(num));
        outPut.append(temp);
        return outPut.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
