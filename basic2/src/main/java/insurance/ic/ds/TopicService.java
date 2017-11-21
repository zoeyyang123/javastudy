package insurance.ic.ds;

import insurance.ic.model.ResponsePage;
import insurance.ic.model.TopicSpec;
import org.springframework.data.domain.Pageable;

/**
 * Created by admin on 2017/11/19.
 */
public interface TopicService {

    /**
     * 发布一个话题
     * @param topicSpec
     */
    void save(TopicSpec topicSpec);

    /**
     * 删除一个话题
     * @param uuid
     */
    void deleteById(String uuid);

    /**
     * 分页获取话题信息
     * @param pageable
     * @return
     */
    ResponsePage<TopicSpec> findPage(Pageable pageable);

    TopicSpec findById(String id);
}
