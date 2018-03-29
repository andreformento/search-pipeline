package com.formento.search.pipeline.simplepipeline;

import com.formento.search.pipeline.stage.Stage;
import com.formento.search.pipeline.stage.StageList;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

@Component
public class SimpleQueryStageFactory {

    public StageList<SimpleQuery> create() {
        final ImmutableList<Stage<SimpleQuery>> stages = ImmutableList.<Stage<SimpleQuery>>builder().
                add(qp -> new SimpleQuery(qp.getTerms().trim(), qp.getPageNumber())).
                build();

        return new StageList<>(stages);
    }

}
