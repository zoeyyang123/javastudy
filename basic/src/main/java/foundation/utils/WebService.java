package foundation.utils;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.hibernate.service.spi.ServiceException;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;

//import org.apache.poi.xwpf.usermodel.Document;

/**
 * Created by minsheng-zxg on 2017/6/21.
 */
public class WebService {
    private static final boolean newLineflag = true;
    private static final String newLine = "\r\n";

    public static synchronized String sender(String xml, String url,
                                             String method) throws Exception {

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

    public static Document buildXMLDocumentFromString(String tXMLMessage) {
        SAXBuilder tSAXBuilder = new SAXBuilder();
        Document tDocument = null;
        try {
            tDocument = tSAXBuilder.build(new StringReader(tXMLMessage));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return tDocument;
    }


    public static String getStartXmlString(String key) {
        if (newLineflag) {
            return "<" + key + ">" + newLine;
        }
        return "<" + key + ">";
    }


    public static String getEndXmlString(String key) {
        if (newLineflag) {
            return "</" + key + ">" + newLine;
        }
        return "</" + key + ">";
    }


    public static String getXMLString(String key, String value) {
        String node = "";
        if (value == null) {
            value = "";
            node = "<" + key + "/>";
        } else {
            node = "<" + key + ">" + value + "</" + key + ">";
        }
        if (newLineflag) {
            return node + newLine;
        }
        return node;
    }
}
