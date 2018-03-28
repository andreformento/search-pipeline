package com.formento.search.pipeline.stage;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class StageListTest {

    @Test
    public void shouldGetHeadFromEmptyList() {
        final List<Stage<Object>> list = Collections.emptyList();
        assertThat(new StageList<>(list).head()).isEmpty();
    }

    @Test
    public void shouldGetHeadFromList() {
        final List<Stage<Object>> list = ImmutableList.<Stage<Object>>builder().add(o -> o).build();
        assertThat(new StageList<>(list).head()).isNotEmpty();
    }

    @Test
    public void shouldGetTailFromEmptyList() {
        final List<Stage<Object>> list = Collections.emptyList();
        assertThat(new StageList<>(list).tail()).isEmpty();
    }

    @Test
    public void shouldGetTailFromList() {
        final List<Stage<Object>> list = ImmutableList.<Stage<Object>>builder().add(o -> o, o -> o).build();
        assertThat(new StageList<>(list).tail()).isNotEmpty();
    }

    @Test
    public void shouldApplyTransformationsInValue() {
        final Object queryPipelineIn = mock(Object.class);
        final Object queryPipelineFirstTransformation = mock(Object.class);
        final Object queryPipelineSecondTransformation = mock(Object.class);

        final List<Stage<Object>> transformations =
                ImmutableList.<Stage<Object>>builder().add(
                        queryPipeline -> queryPipelineFirstTransformation,
                        queryPipeline -> queryPipelineSecondTransformation
                ).build();

        final StageList stageList = new StageList<>(transformations);
        final Object result = stageList.consume(queryPipelineIn);

        assertThat(result).isEqualTo(queryPipelineSecondTransformation);
    }

}
