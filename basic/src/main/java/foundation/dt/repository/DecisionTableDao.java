package foundation.dt.repository;

import foundation.dt.repository.pojo.TDecisionTable;
import foundation.security.OrganizationAware;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface DecisionTableDao extends CrudRepository<TDecisionTable, String>, OrganizationAware {

    @Query("SELECT m FROM #{#entityName} m WHERE m.code=:code")
    TDecisionTable findByCode(@Param("code") String code);
}
