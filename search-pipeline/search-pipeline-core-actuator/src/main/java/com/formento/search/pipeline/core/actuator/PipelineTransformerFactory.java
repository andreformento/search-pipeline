package com.formento.search.pipeline.core.actuator;

import com.formento.search.pipeline.core.PipelineTransformer;
import com.formento.search.pipeline.core.StageList;

import java.util.Collections;

public class PipelineTransformerFactory {

    public static void main(String... args) {

    }

    public <T> PipelineTransformer<T> create() {
        return new PipelineTransformer<T>(new StageList<>(Collections.emptyList()));
    }

}
