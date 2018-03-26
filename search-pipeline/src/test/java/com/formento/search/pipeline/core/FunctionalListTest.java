package com.formento.search.pipeline.core;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;


public class FunctionalListTest {

    @Test
    public void shouldGetHeadFromEmptyList() {
        final List<Function<Object, Object>> list = Collections.emptyList();
        assertThat(new FunctionalList<>(list).head()).isEmpty();
    }

    @Test
    public void shouldGetHeadFromList() {
        final List<Function<Object, Object>> list = ImmutableList.<Function<Object, Object>>builder().add(o -> o).build();
        assertThat(new FunctionalList<>(list).head()).isNotEmpty();
    }

    @Test
    public void shouldGetTailFromEmptyList() {
        final List<Function<Object, Object>> list = Collections.emptyList();
        assertThat(new FunctionalList<>(list).tail()).isEmpty();
    }

    @Test
    public void shouldGetTailFromList() {
        final List<Function<Object, Object>> list = ImmutableList.<Function<Object, Object>>builder().add(o -> o, o -> o).build();
        assertThat(new FunctionalList<>(list).tail()).isNotEmpty();
    }

    @Test
    public void shouldApplyTransformationsInValue() {
        final List<Function<String, String>> transformations =
                ImmutableList.<Function<String, String>>builder().add(
                        String::trim,
                        String::toLowerCase
                ).build();
        final FunctionalList<String> functionalList = new FunctionalList<>(transformations);

        assertThat(functionalList.consume(" André Formento ")).isEqualTo("andré formento");
    }

}
