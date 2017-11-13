package foundation.http;


import foundation.exception.GenericException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;

import javax.ws.rs.core.Response;
import java.util.*;

public class HttpClient {

	public static CloseableHttpClient initHttpClient() {
		return HttpClientBuilder.create().build();
	}


	/**
	 * Send and get response from the specified url, and convert to a string
	 * characters
	 *
	 * @param url
	 * @param contentType
	 * @param encoding
	 * @return
	 */
	public static String getHttpGetContent(String url, String contentType,String encoding){
		HttpGet hg = new HttpGet(url);
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(HttpClientConstants.SOCKET_TIMEOUT)
				.setConnectTimeout(HttpClientConstants.CONNECT_TIMEOUT).build();// 设置请求和传输超时时�?
		hg.setConfig(requestConfig);
		hg.setHeader(HTTP.CONTENT_TYPE, contentType);

		CloseableHttpClient client = initHttpClient();
		try {
			HttpResponse response = client.execute(hg);
			int status = response.getStatusLine().getStatusCode();
			if (status >= HttpStatus.SC_OK
					&& status < HttpStatus.SC_MULTIPLE_CHOICES) {
				return IOUtils.toString(response.getEntity().getContent(),
						encoding);
			} else
				throw new GenericException(
						HttpClientConstants.HTTP_RESPONSE_STATUS_ERROR, String.valueOf(status));
		}catch (GenericException e){
			throw e;
		}catch (Exception e){
			throw new GenericException(e.getMessage());
		}finally {
			try {
				client.close();
			}catch (Exception e){
				throw new GenericException(e.getMessage());
			}

		}

	}

	public static String getHttpPostContent(String url, String contentType, String encoding) {
		return getHttpPostContent(url, new ArrayList<NameValuePair>(), contentType, encoding);
	}

	/**
	 * post http request with http entity
	 *
	 * @param url
	 * @param entity
	 * @param contentType
	 * @param encoding
	 * @return
	 */
	public static String getHttpPostContentByEntity(String url, StringEntity entity, String contentType,String encoding){
		HttpPost post = new HttpPost(url);
		post.setHeader(HTTP.CONTENT_TYPE, contentType);
		post.setEntity(entity);

		CloseableHttpClient client = initHttpClient();
		try {
			HttpResponse response = client.execute(post);
			int status = response.getStatusLine().getStatusCode();
			if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
				return IOUtils.toString(response.getEntity().getContent(), encoding);
			} else
				throw new GenericException(HttpClientConstants.HTTP_RESPONSE_STATUS_ERROR, String.valueOf(status));
		}catch (GenericException e){
			throw e;
		}catch (Exception e){
			throw new GenericException(e.getMessage());
		}finally {
			try {
				client.close();
			}catch (Exception e){
				throw new GenericException(e.getMessage());
			}

		}

	}


	/**
	 * post http request with http entity
	 *
	 * @param url
	 * @param content
	 * @param contentType
	 * @param encoding
	 * @return
	 */
	public static String getHttpPostContentByContent(String url, String content, String contentType,String encoding) {

		StringEntity entity = new StringEntity(content, encoding);
		HttpPost post = new HttpPost(url);
		post.setHeader(HTTP.CONTENT_TYPE, contentType);
		post.setEntity(entity);

		CloseableHttpClient client = initHttpClient();
		try {
			CloseableHttpResponse response = client.execute(post);
			String result = IOUtils.toString(response.getEntity().getContent(), encoding);

			if(response.getStatusLine().getStatusCode() == Response.Status.OK.getStatusCode())
				return result;
			else
				throw new GenericException(HttpClientConstants.HTTP_RESPONSE_STATUS_ERROR, String.valueOf(response.getStatusLine().getStatusCode()));
		}catch (GenericException e){
			throw e;
		}catch (Exception e){
			throw new GenericException(e.getMessage());
		}finally {
			try {
				client.close();
			}catch (Exception e){
				throw new GenericException(e.getMessage());
			}
		}

	}

	/**
	 * post http request with parameter
	 *
	 * @param url
	 * @param params
	 * @param contentType
	 * @param encoding
	 * @return
	 */
	public static String getHttpPostContent(String url, String params, String contentType, String encoding){
		return getHttpPostContent(url, convertPOSTParametersToNVP(params), contentType, encoding);
	}

	public static String getHttpPostContent(String url, Map<String, String> params, String contentType,String encoding){
		return getHttpPostContent(url, generatePostParams(params), contentType, encoding);
	}

	private static String getHttpPostContent(String url, List<NameValuePair> nvps, String contentType,String encoding){

		CloseableHttpClient client = initHttpClient();
		try {
			UrlEncodedFormEntity entity = null;
			if (nvps != null && nvps.size() > 0) {
				entity = new UrlEncodedFormEntity(nvps, encoding);
			}
			HttpPost post = new HttpPost(url);
			post.setHeader(HTTP.CONTENT_TYPE, contentType);
			if (entity != null) {
				post.setEntity(entity);
			}

			HttpResponse response = client.execute(post);
			int status = response.getStatusLine().getStatusCode();
			if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
				return IOUtils.toString(response.getEntity().getContent(), encoding);
			} else
				throw new GenericException(HttpClientConstants.HTTP_RESPONSE_STATUS_ERROR, String.valueOf(status));
		}catch (GenericException e){
			throw e;
		}catch (Exception e){
			throw new GenericException(e.getMessage());
		}finally {
			try {
				client.close();
			}catch (Exception e){
				throw new GenericException(e.getMessage());
			}
		}

	}

	private static List<NameValuePair> generatePostParams(Map<String, String> params) {
		if (params == null) {
			return null;
		}

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Iterator<String> keyParam = params.keySet().iterator();
		while (keyParam.hasNext()) {
			String key = keyParam.next();
			NameValuePair pair = new BasicNameValuePair(key, params.get(key));
			nvps.add(pair);
		}

		return nvps;
	}

	/**
	 *
	 *
	 * @param POSTParameters
	 * @return
	 */
	private static Map<String, String> convertPOSTParametersToNVP(String POSTParameters) {
		Map<String, String> nvps = new LinkedHashMap<String, String>();
		for (String s : POSTParameters.split("&")) {
			String name = s.split("=")[0];
			String value = s.substring(s.indexOf("=") + 1);
			nvps.put(name, value);
		}
		return nvps;

	}

	public static String retryDoPost(final String url, final String requestContent, final String contentType,final String encoding) {
		final StringEntity entity = new StringEntity(requestContent, encoding);

		String responsePayLoad = "";
		try {
			responsePayLoad = RPCUtils.getRetryTemplate(5 * 60 * 1000).execute(new RetryCallback<String, Exception>() {
				@Override
				public String doWithRetry(RetryContext context) throws Exception {
					return HttpClient.getHttpPostContentByEntity(url, entity, contentType, encoding);
				}
			});
		}catch (Exception e){
			throw new GenericException(e.getMessage());
		}

		return responsePayLoad;
	}
}
