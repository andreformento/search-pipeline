package com.formento.search.pipeline.core;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class FunctionalListTest {

    @Test
    public void shouldGetHeadFromEmptyList() {
        final List<Object> list = Collections.emptyList();
        assertThat(new FunctionalList<>(list).head()).isEmpty();
    }

    @Test
    public void shouldGetHeadFromList() {
        final List<Object> list = ImmutableList.builder().add(new Object()).build();
        assertThat(new FunctionalList<>(list).head()).isNotEmpty();
    }

    @Test
    public void shouldGetTailFromEmptyList() {
        final List<Object> list = Collections.emptyList();
        assertThat(new FunctionalList<>(list).tail()).isEmpty();
    }

    @Test
    public void shouldGetTailFromList() {
        final List<Object> list = ImmutableList.builder().add(new Object(), new Object()).build();
        assertThat(new FunctionalList<>(list).tail()).isNotEmpty();
    }

}
