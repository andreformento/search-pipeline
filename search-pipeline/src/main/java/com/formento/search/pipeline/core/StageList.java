package com.formento.search.pipeline.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public final class StageList<T> {

    private final LinkedList<Stage<T>> list;

    public StageList(final List<Stage<T>> list) {
        this.list = new LinkedList<>(list);
    }

    public Optional<Stage<T>> head() {
        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(list.getFirst());
        }
    }

    public Optional<StageList<T>> tail() {
        return Optional.
                of(list).
                filter(l -> l.size() > 1).
                map(l -> new StageList<>(l.subList(1, l.size())));
    }

    public T consume(final T value) {
        return recursiveConsume(this, value);
    }

    private T recursiveConsume(final StageList<T> stageList, final T value) {
        final T nextValue = stageList.
                head().
                map(action -> action.transform(value)).
                orElse(value);

        return stageList.
                tail().
                map(tailList -> recursiveConsume(tailList, nextValue)).
                orElse(nextValue);
    }

}
