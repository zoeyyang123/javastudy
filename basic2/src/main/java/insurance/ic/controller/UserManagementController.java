package insurance.ic.controller;

import insurance.ic.model.TopicSpec;
import insurance.ic.model.UserSpec;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by admin on 2017/11/19.
 */
@Controller
@RequestMapping("/v0")
public class UserManagementController {

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String login(@RequestBody UserSpec userSpec) {
        return null;
    }

    @RequestMapping(value = "/setUserBlackList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String setUserBlackList(@RequestParam("user") String user) {
        return null;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String saveUser(@RequestBody UserSpec userSpec){
        return null;
    }
}
