package insurance.ic.repository.pojo;

import insurance.ic.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by admin on 2017/11/19.
 */
@Entity
@Table(name = "T_UPVOTE")
public class TUpvote extends BaseEntity{

    @Id
    private String uuid;
    @Column
    private String upvoter;
    @Column
    private String comment;
    @Column
    private String topic;
    @Column
    private Date upvoteDate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUpvoter() {
        return upvoter;
    }

    public void setUpvoter(String upvoter) {
        this.upvoter = upvoter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getUpvoteDate() {
        return upvoteDate;
    }

    public void setUpvoteDate(Date upvoteDate) {
        this.upvoteDate = upvoteDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
