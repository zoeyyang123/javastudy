package insurance.ic.repository.pojo;

import insurance.ic.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 2017/11/19.
 */
@Entity
@Table(name = "T_TOPIC")
public class TTopic extends BaseEntity {

    @Id
    private String uuid;
    @Column
    private String subject;
    @Lob
    private String content;
    @Column
    private String tag;
    @Column
    private String publisher;
    @Column
    private Date publishDate;
    @Lob
    @Basic(fetch = FetchType. LAZY)
    private byte[] image;
    @Column
    private Integer status;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
