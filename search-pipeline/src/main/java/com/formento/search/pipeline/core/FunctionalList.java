package com.formento.search.pipeline.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class FunctionalList<T> {

    private final LinkedList<T> list;

    public FunctionalList(final List<T> list) {
        this.list = new LinkedList<>(list);
    }


    public Optional<T> head() {
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

}
