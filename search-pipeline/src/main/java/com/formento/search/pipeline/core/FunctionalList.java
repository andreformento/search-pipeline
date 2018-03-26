package com.formento.search.pipeline.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public final class FunctionalList<T> {

    private final LinkedList<Function<T, T>> list;

    public FunctionalList(final List<Function<T, T>> list) {
        this.list = new LinkedList<>(list);
    }

    public Optional<Function<T, T>> head() {
        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(list.getFirst());
        }
    }

    public Optional<FunctionalList<T>> tail() {
        if (list.size() <= 1) {
            return Optional.empty();
        } else {
            return Optional.of(new FunctionalList<>(list.subList(1, list.size())));
        }
    }

    public T consume(T value) {
        return consumeRecursive(this, value);
    }

    private T consumeRecursive(FunctionalList<T> functionalList, T value) {
        final T nextValue = functionalList.
                head().
                map(action -> action.apply(value)).
                orElse(value);

        return functionalList.
                tail().
                map(tailList -> consumeRecursive(tailList, nextValue)).
                orElse(nextValue);
    }

}
