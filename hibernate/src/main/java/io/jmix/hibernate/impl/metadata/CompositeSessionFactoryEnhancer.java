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

package io.jmix.hibernate.impl.metadata;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("hibernate_CompositeSessionFactoryEnhancer")
public class CompositeSessionFactoryEnhancer {

    @Autowired
    protected List<SessionFactoryEnhancer> enhancers;

    public void enhance(SessionFactoryImplementor sessionFactoryImplementor) {
        for (SessionFactoryEnhancer enhancer : enhancers) {
            enhancer.enhance(sessionFactoryImplementor);
        }
    }
}
