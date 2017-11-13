package foundation.http;

import com.google.common.collect.Maps;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.Map;

public class RPCUtils {

	public static RetryTemplate getRetryTemplate() {
		return getRetryTemplate(1000);
	}
	
	public static RetryTemplate getRetryTemplate(int sleepMillSecond) {
		RetryTemplate template = new RetryTemplate();
		Map<Class<? extends Throwable>, Boolean> exceptionRetry = Maps.newHashMap();
		exceptionRetry.put(Exception.class, true);
		
		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(3, exceptionRetry, true);
		retryPolicy.setMaxAttempts(3);
		template.setRetryPolicy(retryPolicy);
		template.registerListener(new IntervalRetryListener(sleepMillSecond));//sleep 1 second
		return template;
	}
}
