package com.formento.search.pipeline.stage;

import reactor.core.publisher.Mono;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public final class StageList<T> {

    private final LinkedList<Stage<T>> list;

    public StageList(final List<? extends Stage<T>> list) {
        this.list = new LinkedList<>(list);
    }

    Optional<Stage<T>> head() {
        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(list.getFirst());
        }
    }

    Optional<StageList<T>> tail() {
        return Optional.
                of(list).
                filter(l -> l.size() > 1).
                map(l -> new StageList<>(l.subList(1, l.size())));
    }

    public Mono<T> consume(final Mono<T> value) {
        return recursiveConsume(this, value);
    }

    private Mono<T> recursiveConsume(final StageList<T> stageList, final Mono<T> value) {
        final Mono<T> nextValue = stageList.
                head().
                map(action -> action.transform(value)).
                orElse(value);

        return stageList.
                tail().
                map(tailList -> recursiveConsume(tailList, nextValue)).
                orElse(nextValue);
    }

}
