package insurance.ic.ds;

import insurance.ic.model.UpvoteSpec;

import java.util.List;

/**
 * Created by admin on 2017/11/19.
 */
public interface UpvoteService {

    /**
     * 保存一条user与comment的对应关系
     * @param upvoteSpec
     */
    void doUpvote(UpvoteSpec upvoteSpec);

    /**
     * 获取用户所有点赞内容
     * @param userId
     * @return
     */
    List<UpvoteSpec> findByUser(String userId);

    /**
     * 获取用户所有点赞内容
     * @param userId
     * @param topicId
     * @return
     */
    List<UpvoteSpec> findByUserAndTopic(String userId, String topicId);

}
