
import java.io.IOException;

/**
 * Created by yacovyitzhak on 04/08/2017.
 */
public class Main {
    private static final String url = "http://localhost:8080/myapp/file/upload";
    private static final String fileName = "/Users/yacovyitzhak/Documents/tmp/A.Beautiful.Mind.2001.1080p.BluRay.H264.AAC-RARBG.mp4";
    //private static final String fileName = "/Users/yacovyitzhak/Documents/tmp/a.txt";

    public static void main(String[] args) throws IOException {
        ApacheClient.upload(url,fileName);
        JerseyClient.upload(url,fileName);

    }

}
