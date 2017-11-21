package insurance.ic.repository;

import insurance.ic.repository.pojo.TSensitiveWords;
import insurance.ic.repository.pojo.TUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by admin on 2017/11/19.
 */
public interface SensitiveWordsDao extends PagingAndSortingRepository<TSensitiveWords, String> {

    @Query("SELECT m FROM #{#entityName} m WHERE m.code=:code")
    TUser findByCode(@Param("code") String code);
    
}
