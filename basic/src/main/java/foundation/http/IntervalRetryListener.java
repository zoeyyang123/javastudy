package foundation.http;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

public class IntervalRetryListener implements RetryListener {
	private int sleepMilliSeconds;
	
	public IntervalRetryListener(int sleepMilliSeconds){
		this.sleepMilliSeconds = sleepMilliSeconds;
	}

	@Override
	public <T, E extends Throwable> boolean open(RetryContext context,RetryCallback<T, E> callback) {
		return true;
	}

	@Override
	public <T, E extends Throwable> void close(RetryContext context,RetryCallback<T, E> callback, Throwable throwable) {
	}

	@Override
	public <T, E extends Throwable> void onError(RetryContext context,RetryCallback<T, E> callback, Throwable throwable) {
		try {
			Thread.sleep(sleepMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
