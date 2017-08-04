
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;

/**
 * Created by yacovyitzhak on 04/08/2017.
 */
public class JerseyClient {
    public static void upload(String url,String fileName) throws IOException
    {
        final Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();

        // MediaType of the body part will be derived from the file.
        final FileDataBodyPart filePart = new FileDataBodyPart("file", new File(fileName));
        final MultiPart multipart = new FormDataMultiPart()
                .field("xxx", "yyy")
                .bodyPart(filePart);
        final WebTarget target = client.target(url);

        final Response response = target.request()
                .post(Entity.entity(multipart, multipart.getMediaType()));//Use response object to verify upload success
        multipart.close();
    }
}
