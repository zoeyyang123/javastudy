package foundation.ct.repository.pojo;

import foundation.model.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name = "T_CODE_TABLE")
public class TCodeTable extends BaseEntity {

    @Id
    private String uuid;
    @Column
    private String name;
    @Column
    private String code;
    @Lob
    @Column(length = 10000)
    private String content;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
