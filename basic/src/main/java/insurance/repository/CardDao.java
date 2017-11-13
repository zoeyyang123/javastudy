package insurance.repository;

import insurance.repository.pojo.TCard;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhaoyi on 17-8-28.
 */

public interface CardDao extends CrudRepository<TCard, String> {
}
