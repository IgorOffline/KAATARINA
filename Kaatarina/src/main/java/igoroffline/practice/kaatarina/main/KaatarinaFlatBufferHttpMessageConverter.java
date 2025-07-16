package igoroffline.practice.kaatarina.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;

public class KaatarinaFlatBufferHttpMessageConverter extends AbstractHttpMessageConverter<ByteBuffer> {

    public KaatarinaFlatBufferHttpMessageConverter() {
        super(new MediaType("application", "octet-stream"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return ByteBuffer.class.isAssignableFrom(clazz);
    }

    @Override
    protected ByteBuffer readInternal(Class<? extends ByteBuffer> clazz, HttpInputMessage inputMessage)
            throws IOException {
        InputStream is = inputMessage.getBody();
        byte[] bytes = is.readAllBytes();
        return ByteBuffer.wrap(bytes);
    }

    @Override
    protected void writeInternal(ByteBuffer byteBuffer, HttpOutputMessage outputMessage) throws IOException {
        OutputStream os = outputMessage.getBody();
        os.write(byteBuffer.array());
        os.flush();
    }
}
