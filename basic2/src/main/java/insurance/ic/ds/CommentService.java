package insurance.ic.ds;

import insurance.ic.model.CommentSpec;
import insurance.ic.model.ResponsePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by admin on 2017/11/19.
 */
public interface CommentService {
    /**
     * 发布一条评论
     * @param commentSpec
     */
    void save(CommentSpec commentSpec);

    /**
     * 删除一条评论
     * @param uuid
     */
    void deleteById(String uuid);

    /**
     * 分页查找
     * @param pageable
     * @return
     */
    ResponsePage<CommentSpec> findPageByTopic(String topicId, Pageable pageable);
}
