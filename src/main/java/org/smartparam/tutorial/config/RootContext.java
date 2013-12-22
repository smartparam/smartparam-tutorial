/*
 * Copyright 2013 Adam Dubiel, Przemek Hertel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.smartparam.tutorial.config;

import org.smartparam.engine.config.ParamEngineConfig;
import org.smartparam.engine.config.ParamEngineConfigBuilder;
import org.smartparam.engine.config.ParamEngineFactory;
import org.smartparam.engine.core.ParamEngine;
import org.smartparam.engine.core.parameter.ParamRepository;
import org.smartparam.repository.fs.ClasspathParamRepository;
import org.smartparam.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Adam Dubiel
 */
@Configuration
@ComponentScan(basePackages = {"com.adamdubiel.smartparam"},
        excludeFilters = @ComponentScan.Filter(Configuration.class))
public class RootContext {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public ParamEngine paramEngine() {
        ParamRepository repository = new ClasspathParamRepository("/param", ".*\\.param$");
        ParamEngineConfig engineConfig = ParamEngineConfigBuilder.paramEngineConfig()
                .withAnnotationScanEnabled("org.smartparam.spring", "com.adamdubiel.smartparam.param", "com.adamdubiel.smartparam.domain.discount")
                .registerModule(new SpringModule(applicationContext))
                .withParameterRepositories(repository).build();
        return ParamEngineFactory.paramEngine(engineConfig);
    }

}
