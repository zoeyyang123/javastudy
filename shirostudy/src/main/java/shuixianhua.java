/**
 * Created by zhaoyi on 17-5-11.
 */
public class shuixianhua {
    public static void main(String[] args) {
        for (int i = 100; i <1000 ; i++) {
            int j=i/100;
            int q=i/10-j*10;
            int k=i%10;
            if(Math.pow(j,3)+Math.pow(q,3)+ Math.pow(k,3)==i){
                System.out.println("水仙花:"+i);
            }
        }
    }
}
