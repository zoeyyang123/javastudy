package insurance.ic.repository;

import insurance.ic.repository.pojo.TUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by admin on 2017/11/19.
 */
public interface UserDao extends PagingAndSortingRepository<TUser, String> {

    @Query("SELECT m FROM #{#entityName} m WHERE m.userName=:userName")
    TUser findByUserName(@Param("userName") String userName);
}
