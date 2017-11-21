package insurance.ic.model;

import java.util.Date;

/**
 * Created by admin on 2017/11/19.
 */
public class UpvoteSpec extends BaseModel{

    private String upvoter;
    private String comment;
    private String topic;
    private Date upvoteDate;

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
