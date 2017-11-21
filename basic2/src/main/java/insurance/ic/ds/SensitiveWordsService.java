package insurance.ic.ds;

import insurance.ic.model.SensitiveWordsSpec;

/**
 * Created by admin on 2017/11/19.
 */
public interface SensitiveWordsService {

    /**
     * 保存敏感词配置
     * @param sensitiveWordsSpec
     */
    void save(SensitiveWordsSpec sensitiveWordsSpec);

    /**
     * 更新敏感词配置
     * @param sensitiveWordsSpec
     */
    void update(SensitiveWordsSpec sensitiveWordsSpec);

    /**
     * 删除敏感词配置
     * @param code
     */
    void deleteByCode(String code);

    /**
     * 获取敏感词配置
     * @param code
     * @return
     */
    SensitiveWordsSpec findByCode(String code);
}
