package igoroffline.practice.kaatarina.main;

import Kaatarina.Flatabo.Practice;
import com.google.flatbuffers.FlatBufferBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenataController {

    @GetMapping("/renata/1")
    public byte[] getRenata1() {

        final var builder = new FlatBufferBuilder(1024);

        int nameOffset = builder.createString("Renata1");

        Practice.startPractice(builder);
        Practice.addId(builder, 1);
        Practice.addAge(builder, 1_000);
        Practice.addName(builder, nameOffset);
        Practice.addPractice(builder, true);
        int practiceOffset = Practice.endPractice(builder);

        builder.finish(practiceOffset);

        final var buffer = builder.dataBuffer();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        return bytes;
    }
}
