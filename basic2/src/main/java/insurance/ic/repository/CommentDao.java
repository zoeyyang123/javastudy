package insurance.ic.repository;

import insurance.ic.repository.pojo.TComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by admin on 2017/11/19.
 */
public interface CommentDao extends PagingAndSortingRepository<TComment, String> {

    Page<TComment> findByTopic(String topic, Pageable pageable);
}
