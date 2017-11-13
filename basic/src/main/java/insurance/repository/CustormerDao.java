package insurance.repository;

import insurance.repository.pojo.TCustomer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhaoyi on 17-8-28.
 */
public interface CustormerDao extends CrudRepository<TCustomer, String> {
}
