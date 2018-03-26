package com.formento.search.pipeline.core;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PipelineTransformerTest {

    @Test
    public void shouldCallAllStages() {
        final Stage<Object> stage1 = mock(Stage.class);
        final Stage<Object> stage2 = mock(Stage.class);

        final StageList<Object> stages = new StageList(ImmutableList.<Stage<Object>>builder().add(stage1, stage2).build());

        final PipelineTransformer subject = new PipelineTransformer(stages);

        final Object queryPipelineIn = spy(mock(Object.class));
        final Object queryPipelineOut = subject.transform(queryPipelineIn);

        verify(stage1, only()).transform(queryPipelineIn);
        verify(stage2, only()).transform(queryPipelineOut);
    }

}
