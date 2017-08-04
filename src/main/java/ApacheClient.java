import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.IOException;

/**
 * Created by yacovyitzhak on 04/08/2017.
 */
public class ApacheClient {

    public static void upload(String url,String fileName) throws IOException {

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        File uploadFile = new File(fileName);

        FileBody uploadFilePart = new FileBody(uploadFile);
        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("file", uploadFilePart);
        httpPost.setEntity(reqEntity);

        HttpResponse response = httpclient.execute(httpPost);
    }

}
