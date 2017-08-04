
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by yacovyitzhak on 04/08/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        upload();
    }
    public static void upload() throws IOException {

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://localhost:8080/myapp/file/upload");
        File uploadFile = new File("/Users/yacovyitzhak/Documents/tmp/A.Beautiful.Mind.2001.1080p.BluRay.H264.AAC-RARBG.mp4");

        FileBody uploadFilePart = new FileBody(uploadFile);
        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("file", uploadFilePart);
        httpPost.setEntity(reqEntity);

        HttpResponse response = httpclient.execute(httpPost);
    }

}
