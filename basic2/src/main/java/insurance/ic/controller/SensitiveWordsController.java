package insurance.ic.controller;

import insurance.ic.model.SensitiveWordsSpec;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2017/11/19.
 */
@RestController
@RequestMapping("/v0")
public class SensitiveWordsController {

    @RequestMapping(value = "/saveSensitiveWords", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String saveSensitiveWords(@RequestBody SensitiveWordsSpec sensitiveWordsSpec) {
        return null;
    }

    @RequestMapping(value = "/saveSensitiveWords", method = RequestMethod.GET, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String findSensitiveWords() {
        return null;
    }

    @RequestMapping(value = "/findSensitiveWordsByCode", method = RequestMethod.GET, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String findSensitiveWordsByCode(@RequestParam("code") String code) {
        return null;
    }
}
