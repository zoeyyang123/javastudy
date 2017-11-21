package insurance.ic.model;

/**
 * Created by admin on 2017/11/20.
 */
public class SensitiveWordsSpec extends BaseModel {

    private String code;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
