package insurance.ic.ds;

import insurance.ic.model.UserOAuthSpec;
import insurance.ic.model.UserSpec;

/**
 * Created by admin on 2017/11/19.
 */
public interface OAuthService {

    /**
     * 保存
     * @param userOAuthSpec
     */
    void save(UserOAuthSpec userOAuthSpec);

    /**
     * 通过oauthToken查找
     * @param oauthToken
     * @return
     */
    UserSpec findByOauthToken(String oauthToken);
}
