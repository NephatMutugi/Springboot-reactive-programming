package com.teohkenya.main;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

/**
 * @ Author NMuchiri
 **/
public class MonoFluxTest {

    @Test
    public void testMono(){

        // mono can only handle one element
        Mono<String> monoString =  Mono.just("Nephat Mutugi").log();
        monoString.subscribe(System.out::println);
    }
}
