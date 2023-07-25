/*
 * Copyright 2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.dynattrui;

import io.jmix.core.annotation.Internal;
import io.jmix.dynattrui.impl.EmbeddingStrategy;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.Frame;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Internal
@org.springframework.stereotype.Component("dynat_DynAttrEmbeddingStrategies")
public class DynAttrEmbeddingStrategies {

    @Autowired(required = false)
    protected List<EmbeddingStrategy> embeddingStrategies;

    public void embedAttributes(Component component, Frame frame) {
        if (embeddingStrategies != null) {
            for (EmbeddingStrategy strategy : embeddingStrategies) {
                if (strategy.supportComponent(component)) {
                    strategy.embed(component, frame);
                }
            }
        }
    }
}
