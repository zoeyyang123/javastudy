package insurance.ic.repository.pojo;

import insurance.ic.model.BaseEntity;

import javax.persistence.*;

/**
 * Created by admin on 2017/11/19.
 */
@Entity
@Table(name = "T_SENSITIVE_WORDS")
public class TSensitiveWords extends BaseEntity{

    @Id
    private String uuid;
    @Column
    private String code;
    @Lob
    private String content;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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
