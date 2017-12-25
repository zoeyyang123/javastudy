package LittleTest;

/**
 * 1230!末尾有多少个0？
 * Created by zhaoyi on 17-11-21.
 */
public class Test3 {
    public static void main(String[] args) {
        long m =1;
        int cnt=0;
        for (int i = 1; i <=1230 ; i++) {
            m=m*i;
            if (m%10==0){
                while (m%10==0){
                    m=m/10;
                    cnt++;
                }
                m=m%10;
            }
        }
        System.out.println(cnt);
    }
}
