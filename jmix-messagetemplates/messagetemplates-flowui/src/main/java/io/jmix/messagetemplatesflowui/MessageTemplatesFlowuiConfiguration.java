/*
 * Copyright 2024 Haulmont.
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

package io.jmix.messagetemplatesflowui;

import io.jmix.core.CoreConfiguration;
import io.jmix.core.annotation.JmixModule;
import io.jmix.core.impl.scanning.AnnotationScanMetadataReaderFactory;
import io.jmix.flowui.FlowuiConfiguration;
import io.jmix.flowui.sys.ViewControllersConfiguration;
import io.jmix.flowui.sys.registration.ComponentRegistration;
import io.jmix.flowui.sys.registration.ComponentRegistrationBuilder;
import io.jmix.messagetemplates.MessageTemplatesConfiguration;
import io.jmix.messagetemplatesflowui.component.loader.GrapesJsLoader;
import io.jmix.messagetemplatesflowui.kit.component.GrapesJs;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collections;

@Configuration
@ComponentScan
@ConfigurationPropertiesScan
@EnableTransactionManagement
@JmixModule(dependsOn = {CoreConfiguration.class, FlowuiConfiguration.class, MessageTemplatesConfiguration.class})
@PropertySource(name = "io.jmix.messagetemplatesflowui", value = "classpath:/io/jmix/messagetemplatesflowui/module.properties")
public class MessageTemplatesFlowuiConfiguration {

    @Bean("msgtmp_ViewControllersConfiguration")
    public ViewControllersConfiguration views(ApplicationContext applicationContext,
                                              AnnotationScanMetadataReaderFactory metadataReaderFactory) {
        ViewControllersConfiguration viewControllers
                = new ViewControllersConfiguration(applicationContext, metadataReaderFactory);
        viewControllers.setBasePackages(Collections.singletonList("io.jmix.messagetemplatesflowui.view"));
        return viewControllers;
    }

    @Bean
    public ComponentRegistration grapesJs() {
        return ComponentRegistrationBuilder.create(GrapesJs.class)
                .withComponentLoader("grapesJs", GrapesJsLoader.class)
                .build();
    }
}
