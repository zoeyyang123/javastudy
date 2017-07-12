package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-11.
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        if (al==0)return b;
        if (bl==0)return a;
        int bigOne = al>bl?al:bl;
        StringBuffer rerult = new StringBuffer();
        Character[] buffer = new Character[bigOne];
        char flag = '0';
        int temp;
        int tempa;
        int tempb;
        int i = 0;
        while (al>0||bl>0){
            tempa=al>0?a.charAt(al-1):48;
            tempb=bl>0?b.charAt(bl-1):48;
            temp=flag+tempa+tempb;
            switch (temp){
                case 144:
                    buffer[i]='0';
                    flag='0';
                    break;
                case 145:
                    buffer[i]='1';
                    flag='0';
                    break;
                case 146:
                    buffer[i]='0';
                    flag='1';
                    break;
                case 147:
                    buffer[i]='1';
                    flag='1';
                    break;
                default:
                    break;
            }
            i++;
            al--;
            bl--;
        }
        if (flag=='1'){
            rerult.append('1');
            for (int j = buffer.length-1; j>=0  ; j--) rerult.append(buffer[j]);
        }else
            for (int j = buffer.length-1; j>=0  ; j--) rerult.append(buffer[j]);
        return rerult.toString();

        /*public String addBinary(String a, String b) {

            int offset = 0;
            StringBuilder sb = new StringBuilder();

            for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j>= 0; i--, j--){
                int curSum = offset;
                if(i >= 0)
                    curSum += a.charAt(i) - '0';
                if(j >= 0)
                    curSum += b.charAt(j) - '0';
                if(curSum >= 2){
                    curSum -= 2;
                    offset = 1;
                } else offset = 0;

                sb.insert(0, (char)(curSum + 48));
            }

            if(offset == 1) sb.insert(0, '1');

            return sb.toString();
        }*/
        //用stringbuilder可以在特定位置插入字符
    }

    public static void main(String[] args) {
        String a = "111111";
        String b = "111111";
        System.out.println(addBinary(b,a));
    }
}
