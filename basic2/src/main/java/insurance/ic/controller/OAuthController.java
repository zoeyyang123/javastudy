package insurance.ic.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2017/11/19.
 */
@RestController
@RequestMapping("/v0")
public class OAuthController {

    @RequestMapping(value = "/acceptToken", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String acceptAccessToken() {
        return null;
    }

    @RequestMapping(value = "/acceptOAuth", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String acceptOAuthUserInfo() {
        return null;
    }

    @RequestMapping(value = "/getUserInfoByToken", method = RequestMethod.GET, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String getUserInfoByToken() {
        return null;
    }
}
