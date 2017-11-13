package foundation.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

//import com.ebao.insurance.common.utils.Assert;
//import com.ebao.insurance.common.utils.LoggerFactory;

/**
 * @ Author LiRui
 * @ Date 2017-06-06
 *  web中使用到的工具类，如获取登录用户IP地址等
 */
public class WebUtils {

	private static final String _255 = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
	private static final Pattern pattern = Pattern.compile("^(?:" + _255 + "\\.){3}" + _255 + "$");

//	private static final Logger log = LoggerFactory.getLogger();

	public static String getIPAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
//		if (log.isDebugEnabled()) {
//			log.debug("getIPAddress:IP address (x-forwarded-for): " + ip);
//		}
		if (!hasIP(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
//			if (log.isDebugEnabled()) {
//				log.debug("getIPAddress:IP address (Proxy-Client-IP): " + ip);
//			}
		}
		if (!hasIP(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
//			if (log.isDebugEnabled()) {
//				log.debug("getIPAddress:IP address (WL-Proxy-Client-IP): " + ip);
//			}
		}
		boolean found = false;
		if (hasIP(ip)) {
			StringTokenizer tokenizer = new StringTokenizer(ip, ",");
			while (tokenizer.hasMoreTokens()) {
				ip = tokenizer.nextToken().trim();
				if (isIPv4Valid(ip) && !isIPv4Private(ip)) {
					found = true;
					break;
				}
			}
//			if (log.isDebugEnabled()) {
//				log.debug("getIPAddress:IP address (validIPv4): " + ip);
//			}
		}
		if (!found) {
			ip = request.getRemoteAddr();
//			if (log.isDebugEnabled()) {
//				log.debug("getIPAddress:IP address (RemoteAddr): " + ip);
//			}
		}
		if ("0:0:0:0:0:0:0:1".equals(ip) || "127.0.0.1".equals(ip)) {
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
//				if (log.isDebugEnabled()) {
//					log.debug("getIPAddress:IP address (HostAddress): " + ip);
//				}
			} catch (UnknownHostException e) {
//				if (log.isErrorEnabled()) {
//					log.error("getIPAddress:error.\n", e);
//				}
			}
		}

//		if (log.isInfoEnabled()) {
//			log.info("getIPAddress:IP address: " + ip);
//		}
		return ip;
	}

	public static long ipV4ToLong(String ip) {
		String[] octets = ip.split("\\.");
		return (Long.parseLong(octets[0]) << 24) + (Integer.parseInt(octets[1]) << 16)
				+ (Integer.parseInt(octets[2]) << 8) + Integer.parseInt(octets[3]);
	}

	public static boolean isWechatBrowser(HttpServletRequest request) {
		String userAgent = StringUtils.lowerCase(request.getHeader("user-agent"));
		return StringUtils.indexOf(userAgent, "micromessenger") > 0;
	}

	private static boolean isIPv4Private(String ip) {
		long longIp = ipV4ToLong(ip);
		return (longIp >= ipV4ToLong("10.0.0.0") && longIp <= ipV4ToLong("10.255.255.255"))
				|| (longIp >= ipV4ToLong("172.16.0.0") && longIp <= ipV4ToLong("172.31.255.255"))
				|| (longIp >= ipV4ToLong("192.168.0.0") && longIp <= ipV4ToLong("192.168.255.255"));
	}

	private static boolean isIPv4Valid(String ip) {
		return pattern.matcher(ip).matches();
	}

	private static boolean hasIP(String ipStr) {
		return StringUtils.isNotBlank(ipStr) && !"unknown".equalsIgnoreCase(ipStr);
	}
	
	public static String getServletRootUrl(HttpServletRequest request) {
		//简单修改，后续需要改好
		if(request==null){
			return "";
		}
//		Assert.isNotNull(request);
		// url: http://axatp.localhost:10080/pa_web/api/ebaopay/new
		String url = request.getRequestURL().toString();
		// uri: /pa_web/api/ebaopay/new
		String uri = request.getRequestURI();
		String root = url.substring(0, url.indexOf(uri));
		// rootContextUrl: http://axatp:localhost:10080/pa_web
		String rootContextUrl = root + request.getContextPath();
//		if (log.isDebugEnabled())
//			log.debug("root context url = " + rootContextUrl);
		return rootContextUrl;
	}
}
