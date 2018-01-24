package akka;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * WatchActor class
 * 为MyWorker指定一个监视着，一旦其意外停止工作，监视着会收到一个通知
 * @author zhaoyi
 * @date 18-1-24
 */
public class WatchActor extends UntypedActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(),this);

    public WatchActor(ActorRef ref){
        getContext().watch(ref);
    }

    @Override
    public void onReceive(Object msg) throws Throwable {
        if (msg instanceof Terminated){
            log.info(String.format("%s has terminated, shutting down system",((Terminated)msg).getActor().path()));
            getContext().system().terminate();
        }else {
            unhandled(msg);
        }
    }
}
