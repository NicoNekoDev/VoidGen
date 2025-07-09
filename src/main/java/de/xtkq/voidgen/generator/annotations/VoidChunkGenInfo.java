package de.xtkq.voidgen.generator.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface VoidChunkGenInfo {
    String[] versions();
}
