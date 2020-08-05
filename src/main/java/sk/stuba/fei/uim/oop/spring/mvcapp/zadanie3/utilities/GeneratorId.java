package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.utilities;

import java.util.concurrent.atomic.AtomicLong;

public class GeneratorId {

    private static final AtomicLong generator = new AtomicLong(0);

    public static long newId() {
        return generator.getAndIncrement();
    }
}
