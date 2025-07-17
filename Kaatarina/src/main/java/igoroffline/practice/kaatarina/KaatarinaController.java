package igoroffline.practice.kaatarina;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/kaatarina")
public class KaatarinaController {

    @Get("/hello")
    public AgeRecord hello() {
        return new AgeRecord(100);
    }
}
