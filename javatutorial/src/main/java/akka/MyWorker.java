package akka;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;


/**
 * MyWorker class
 * UntypedActor方法已经被废弃了?
 * 是的，2.5.0以后就废弃了，用AbstractActor 代替
 * https://doc.akka.io/api/akka/2.5.6/akka/actor/UntypedActor.html
 * 此处暂时还用UntypedActor
 * @author zhaoyi
 * @date 18-1-24
 */
public class MyWorker extends UntypedActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(),this);
    public static enum Msg {
        WORKING,DONE,CLOSE
    }
    @Override
    public void onReceive(Object msg) {
        if (msg == Msg.WORKING){
            log.info("I am working");
        }
        if (msg == Msg.DONE){
            log.info("Stop working");
        }
        if (msg == Msg.CLOSE){
            log.info("I will shutdown");
            getSender().tell(Msg.CLOSE,getSelf());
            getContext().stop(getSelf());
        }else {
            unhandled(msg);
        }
    }

    @Override
    public void preStart() throws Exception {
        log.info("MyWorker is staring");
    }

    @Override
    public void postStop() throws Exception {
        log.info("MyWorker is stopping");
    }

}
