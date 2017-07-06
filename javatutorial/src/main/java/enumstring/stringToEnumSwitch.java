package enumstring;

/**
 * Created by zhaoyi on 17-6-13.
 * 要先新建一个枚举类型的值 并赋它 string的值
 */
enum EnumExample
{
    Teamreq,Matreq;
}
public class stringToEnumSwitch {
    public static void main(String[] argc)
    {
        String str = "Matreq";
        EnumExample test = EnumExample.valueOf(str);
        switch (test)
        {
            case Matreq:
                System.out.println(EnumExample.Matreq.name());
                break;
            case Teamreq:
                System.out.println(EnumExample.Teamreq.name());
                break;
            default:
                break;
        }

    }
}
