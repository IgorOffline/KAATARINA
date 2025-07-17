package igoroffline.practice.kaatarina;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record AgeRecord(int value) {}
