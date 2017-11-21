package insurance.ic.repository.pojo;

import insurance.ic.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 2017/11/19.
 */
@Entity
@Table(name = "T_COMMENT")
public class TComment extends BaseEntity {

    @Id
    private String uuid;
    @Lob
    private String content;
    @Column
    private String commentator;
    @Column
    private Date commentDate;
    @Column
    private String topic;
    @Column
    private Integer status;

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

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
