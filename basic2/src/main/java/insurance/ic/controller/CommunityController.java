package insurance.ic.controller;

import insurance.ic.model.CommentSpec;
import insurance.ic.model.TopicSpec;
import insurance.ic.model.UpvoteSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2017/11/19.
 */
@RestController
@RequestMapping("/v0/community")
public class CommunityController {

    @RequestMapping(value = "/publishTopic", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String publishTopic(@RequestBody TopicSpec topicSpec) {
        return null;
    }

    @RequestMapping(value = "/publishComment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String publishComment(@RequestBody CommentSpec commentSpec) {
        return null;
    }

    @RequestMapping(value = "/doUpvote", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String doUpvote(@RequestBody UpvoteSpec upvoteSpec) {
        return null;
    }

    @RequestMapping(value = "/findTopics", method = RequestMethod.GET, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public Page<UpvoteSpec> findTopics(@PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC)
                                               Pageable pageable) {
        return null;
    }

    @RequestMapping(value = "/findComments", method = RequestMethod.GET, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public Page<UpvoteSpec> findComments(@RequestParam("topic")String topic, @PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC)
                                               Pageable pageable) {
        return null;
    }

    @RequestMapping(value = "/withdrawTopic", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String withdrawTopic(@RequestParam("topicId") String topicId) {
        return null;
    }

    @RequestMapping(value = "/withdrawComment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public String withdrawComment(@RequestParam("commentId") String commentId) {
        return null;
    }
}
