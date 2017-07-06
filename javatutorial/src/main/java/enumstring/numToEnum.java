package enumstring;

/**
 * Created by zhaoyi on 17-6-15.
 */
enum BussType {

    UNDERWRITE("02"),
    TOCANCEL("31"),
    CLAIM("15"),
    PRODUCTRECOMMEND("47");


    private String code;

    BussType(String code) {
        this.code = code;
    }
    public String toValue() {
        return code;
    }
    public static BussType getEnumByCode(String code){
        if (code.equals(UNDERWRITE.toValue())){
            return UNDERWRITE;
        }else if (code.equals(TOCANCEL.toValue())){
            return TOCANCEL;
        }else if (code.equals(CLAIM.toValue())){
            return CLAIM;
        }else if (code.equals(PRODUCTRECOMMEND.toValue())){
            return PRODUCTRECOMMEND;
        }else {
            return null;
        }
    }

}
public class numToEnum {
    public static void main(String[] args) {
        String temp = "02";
        BussType bussType = BussType.getEnumByCode(temp);
        switch (bussType)
        {
            case UNDERWRITE:
                System.out.println(BussType.UNDERWRITE.name());
                break;
            case TOCANCEL:
                System.out.println(BussType.TOCANCEL.name());
                break;
            case CLAIM:
                System.out.println(BussType.CLAIM.name());
                break;
            case PRODUCTRECOMMEND:
                System.out.println(BussType.PRODUCTRECOMMEND.name());
                break;
            default:
                break;
        }
    }

}
