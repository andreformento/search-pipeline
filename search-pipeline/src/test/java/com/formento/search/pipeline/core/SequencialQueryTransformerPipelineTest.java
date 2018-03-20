package com.formento.search.pipeline.core;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SequencialQueryTransformerPipelineTest {

    @Test
    public void shouldCallAllStages() {
        final Stage stage1 = mock(Stage.class);
        final Stage stage2 = mock(Stage.class);

        final List<Stage> stages = ImmutableList.<Stage>builder().add(stage1, stage2).build();

        final SequencialQueryTransformerPipeline subject = new SequencialQueryTransformerPipeline(stages);

        final QueryPipeline queryPipelineIn = spy(mock(QueryPipeline.class));
        final QueryPipeline queryPipelineOut = subject.execute(queryPipelineIn);

        verify(stage1,only()).transform(queryPipelineIn);
        verify(stage2,only()).transform(queryPipelineOut);
    }

}
