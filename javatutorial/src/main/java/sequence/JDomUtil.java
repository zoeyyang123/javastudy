package sequence;


import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;


public class JDomUtil {

	public static final String moudle = JDomUtil.class.getName();


	public static synchronized String sender(String xml, String url,
			String method, String userName, String password) throws Exception {

		Object[] params = new Object[1];
		params[0] = xml;
		Service service = new Service();
		Call call = null;
		try {
			call = (Call) service.createCall();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		call.setTargetEndpointAddress(url);
		call.setOperationName(method);
		return (String) call.invoke(params);
	}



}