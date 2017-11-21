package insurance.ic.repository;

import insurance.ic.repository.pojo.TTopic;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by admin on 2017/11/19.
 */
public interface TopicDao extends PagingAndSortingRepository<TTopic, String> {
    
}
