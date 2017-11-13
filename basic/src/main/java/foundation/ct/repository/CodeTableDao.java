package foundation.ct.repository;

import foundation.ct.repository.pojo.TCodeTable;
import foundation.security.OrganizationAware;
import org.springframework.data.repository.CrudRepository;


public interface CodeTableDao extends CrudRepository<TCodeTable, String>, OrganizationAware {
}
