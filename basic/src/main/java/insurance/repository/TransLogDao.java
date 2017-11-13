package insurance.repository;

import insurance.repository.pojo.TTransLog;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhaoyi on 17-8-28.
 */
public interface TransLogDao extends CrudRepository<TTransLog, String> {
}
