package insurance.ic.repository;

import insurance.ic.repository.pojo.TUpvote;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by admin on 2017/11/19.
 */
public interface UpvoteDao extends PagingAndSortingRepository<TUpvote, String> {
    
}
