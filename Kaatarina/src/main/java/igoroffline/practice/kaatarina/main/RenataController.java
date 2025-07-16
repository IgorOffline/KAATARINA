package igoroffline.practice.kaatarina.main;

import Kaatarina.Flatabo.Practice;
import com.google.flatbuffers.FlatBufferBuilder;
import java.nio.ByteBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenataController {

    @GetMapping("/hello")
    public ResponseEntity<ByteBuffer> getHello() {

        final var builder = new FlatBufferBuilder(1024);

        int nameOffset = builder.createString("JavaName");

        Practice.startPractice(builder);
        Practice.addId(builder, 1);
        Practice.addAge(builder, 1_000);
        Practice.addName(builder, nameOffset);
        Practice.addPractice(builder, true);
        int practiceOffset = Practice.endPractice(builder);

        builder.finish(practiceOffset);

        ByteBuffer buf = builder.dataBuffer();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(buf);
    }
}
