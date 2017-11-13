package foundation.http;


import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpParameterUtil {
	private final static Logger logger = LoggerFactory.getLogger(HttpParameterUtil.class);

	public static StringEntity transformParameter(
            Map<String, List<String>> params, String encoding) {
		StringEntity entity = null;
		if (params != null && !params.isEmpty()) {
			List<NameValuePair> nvps = new ArrayList<>();
			for (String key : params.keySet()) {
				for (String value : params.get(key))
					nvps.add(new BasicNameValuePair(key, value));

			}
			try {
				entity = new UrlEncodedFormEntity(nvps,
						encoding == null ? HttpClientConstants.DEFAULT_ENCODING : encoding);
			} catch (UnsupportedEncodingException e) {
				logger.error(
						"transform post parameter to string entity throws UnsupportedEncodingException ",
						e);
				throw new RuntimeException(e);
			}
		}

		return entity;
	}

	public static void put(Map<String, List<String>> parameterMap, String key,
                           String value) {
		Assert.notNull(parameterMap);
		Assert.notNull(key);
		Assert.notNull(value);

		List<String> values = parameterMap.get(key);
		if (values == null) {
			values = new ArrayList<String>();
			parameterMap.put(key, values);
		}

		values.add(value);
	}

	public static void logParameter(final Map<String, List<String>> params) {
		if (params != null) {
			logger.debug("parameter of http request is ");
			for (String key : params.keySet()) {
				logger.info("key = " + key);
				for (String value : params.get(key))
					logger.info("value = " + value);

			}
		}
	}

	public static String concatParams(final String url,
                                      final Map<String, List<String>> params) {
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		sb.append("?");
		if (params != null) {
			for (String key : params.keySet()) {
				for (String value : params.get(key)) {
					sb.append(key);
					sb.append("=");
					sb.append(value);
					sb.append("&");
				}
			}
			return sb.substring(0, sb.length() - 1);
		} else
			return url;
	}

	@SuppressWarnings("rawtypes")
	public static Map<String, String> parseRequest(HttpServletRequest request) {
		Assert.notNull("request", "request from alipay can not be null");
		// 获取POST过来反馈信息
		Map<String, String> params = new HashMap<>();
		Map requestParams = request.getParameterMap();
		for (Object o : requestParams.keySet()) {
			String name = (String) o;
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}

		return params;
	}

	public static String transMapToString(Map<String, String> map) {
		Assert.notNull(map, "map can not be null");

		StringBuilder sb = new StringBuilder();
		for (String key : map.keySet()) {
			sb.append(key).append("=")
					.append(null == map.get(key) ? "" : map.get(key))
					.append("^");
		}

		logger.trace("built string = {}", sb.toString());

		return sb.toString();
	}
}
