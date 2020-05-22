/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.security.token.jwt.config;

import io.micronaut.context.BeanContext;
import io.micronaut.context.condition.Condition;
import io.micronaut.context.condition.ConditionContext;
import io.micronaut.security.config.SecurityConfiguration;
import io.micronaut.security.handlers.LoginHandlerMode;

/**
 * Evaluates to true if a bean of type {@link io.micronaut.security.config.SecurityConfiguration} is set and {@link io.micronaut.security.config.SecurityConfiguration#getLoginHandler()} equals bearer.
 *
 * @author Sergio del Amo
 * @since 2.0.0
 */
public class LoginHandlerFactoryBearerCondition implements Condition  {

    @Override
    public boolean matches(ConditionContext context) {
        BeanContext beanContext = context.getBeanContext();
        if (!beanContext.containsBean(SecurityConfiguration.class)) {
            return false;
        }
        SecurityConfiguration config = beanContext.getBean(SecurityConfiguration.class);
        return config.getLoginHandler() != null && config.getLoginHandler() == LoginHandlerMode.BEARER;
    }
}