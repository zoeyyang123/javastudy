package insurance.ic.ds;

import insurance.ic.model.UserSpec;

/**
 * Created by admin on 2017/11/19.
 */
public interface UserManagementService {

    /**
     * 保存用户信息
     * @param userSpec
     */
    void save(UserSpec userSpec);

    /**
     * 删除用户信息
     * @param userId
     */
    void delete(String userId);

    /**
     *
     * @param userName
     * @param newPassword
     */
    void changePassword(String userName, String newPassword);

    /**
     * 修改黑名单设置，true为黑名单用户
     * @param isblack
     */
    void changeblackList(boolean isblack);

    /**
     * 通过id查找用户
     * @param userId
     * @return
     */
    UserSpec findById(String userId);
}
