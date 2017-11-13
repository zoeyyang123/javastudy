package insurance.repository;

import insurance.repository.pojo.TPolicy;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhaoyi on 17-8-28.
 */
public interface PolicyDao extends CrudRepository<TPolicy, String> {
}
