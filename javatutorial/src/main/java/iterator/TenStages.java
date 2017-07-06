package iterator;

/**
 * Created by zhaoyi on 17-7-3.
 */
public class TenStages {
    private static int total(Integer n){
        if (n<=0)
            return 0;
        else if (n==1)
            return 1;
        else if (n==2){
            return 2;
        }else {
            return total(n-2)+total(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(total(100));
    }
}
