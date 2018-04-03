package com.formento.search.pipeline.simplepipeline.stage;

import com.formento.search.pipeline.simplepipeline.SimpleQuery;
import com.formento.search.pipeline.simplepipeline.SimpleStage;
import com.formento.search.pipeline.stage.Either;
import com.formento.search.pipeline.stage.Stage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Qualifier("simpleSortStage")
public class QueryFieldStage implements SimpleStage {

    @Override
    public Either<Mono<SimpleQuery.Builder>, Mono<Stage<SimpleQuery.Builder>>> transform(final Mono<SimpleQuery.Builder> value) {
        final Mono<SimpleQuery.Builder> transform = value.map(builder -> builder.setQueryField("title~5 description~1"));

        return Either.withLeft(transform);
    }

}
