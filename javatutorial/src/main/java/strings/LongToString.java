package strings;

/**
 * Created by zhaoyi on 17-6-14.
 */
public class LongToString {
    public final static long ss = 1234512312;

    public static void main(String[] args) {
        System.out.println(""+ss);
        System.out.println(String.valueOf(ss));
        System.out.println(String.valueOf(System.currentTimeMillis()));
    }

}
