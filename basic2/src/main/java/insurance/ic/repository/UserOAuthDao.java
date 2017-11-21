package insurance.ic.repository;

import insurance.ic.repository.pojo.TUserOAuth;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by admin on 2017/11/19.
 */
public interface UserOAuthDao extends PagingAndSortingRepository<TUserOAuth, String> {

    @Query("SELECT m FROM #{#entityName} m WHERE m.userId=:userId")
    TUserOAuth findByUserId(@Param("userId") String userId);

    @Query("SELECT m FROM #{#entityName} m WHERE m.oauthToken=:oauthToken")
    TUserOAuth findByOAuthToken(@Param("oauthToken") String oauthToken);
}
