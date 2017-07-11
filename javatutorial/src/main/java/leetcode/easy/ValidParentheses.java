package leetcode.easy;

import java.util.Stack;

/**
 * Created by zhaoyi on 17-7-6.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        int sLength = s.length();
        if (sLength==0)
            return true;
        if (sLength%2!=0)
            return false;
        Stack<Character> buffer = new Stack<Character>();
        Character firstOne = s.charAt(0);
        if (firstOne.equals(')')||firstOne.equals(']')||firstOne.equals('}'))
            return false;
        int i = 0;
        while (i<sLength){
            Character temp = s.charAt(i);
            switch (temp){
                case '(':
                    buffer.push(temp);
                    break;
                case '[':
                    buffer.push(temp);
                    break;
                case '{':
                    buffer.push(temp);
                    break;
                case ')':
                    if (!buffer.empty()){
                        if (!buffer.pop().equals('('))
                            return false;
                    }else
                        return false;
                    break;
                case ']':
                    if (!buffer.empty()){
                        if (!buffer.pop().equals('('))
                            return false;
                    }else
                        return false;
                    break;
                case '}':
                    if (!buffer.empty()){
                        if (!buffer.pop().equals('('))
                            return false;
                    }else
                        return false;
                    break;
                default:
                    return false;
            }
            i++;
        }
        return buffer.empty();
    }

    public static void main(String[] args) {
        String s1 = "((((({{{{{}}}}})))))[[[[[]]]]]";
        String s2 = "";
        String s3 = "((((({[)()}}";
        String s4 = "}[";
        String s5 = "()]}";
        System.out.println(isValid(s5));
    }
}
