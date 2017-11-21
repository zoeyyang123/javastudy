package insurance.ic.model;

import java.util.Date;

/**
 * Created by admin on 2017/11/19.
 */
public class CommentSpec extends BaseModel{

    private String content;
    private String commentator;
    private Date commentDate;
    private String topic;

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
}
