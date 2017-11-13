package foundation.utils;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by minsheng-zxg on 2017/8/9.
 */
public class FileOperation {
    public Response download(String path, String defaultName) throws IOException {
        File file = new File(path);
        Response.ResponseBuilder responseBuilder = Response.ok(file);
        responseBuilder.type("application/x-msdownload");
        responseBuilder.header("Content-Disposition", "attachment; filename=" + URLEncoder.encode(defaultName, "UTF-8"));
        responseBuilder.header("Content-Length", Long.toString(file.length()));
        Response response = responseBuilder.build();
        return response;
    }

}
