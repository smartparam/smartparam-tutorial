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
package org.smartparam.tutorial.param;

import org.smartparam.tutorial.domain.DateProvider;
import org.smartparam.tutorial.domain.User;
import org.smartparam.tutorial.domain.UserLogin;
import java.util.Date;
import org.smartparam.engine.core.context.DefaultContext;
import org.smartparam.spring.function.SpringPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adam Dubiel
 */
@Service
public class LevelCreators {

    private final DateProvider dateProvider;

    @Autowired
    public LevelCreators(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    @SpringPlugin("currentDate")
    public Date currentDate(DefaultContext context) {
        return dateProvider.currentDate().toDate();
    }

    @SpringPlugin("user.login")
    public UserLogin userLogin(DefaultContext context) {
        return context.get(User.class).login();
    }

    @SpringPlugin("user.accountType")
    public String userAccountType(DefaultContext context) {
        return context.get(User.class).accountType().name();
    }

    @SpringPlugin("user.registrationDate")
    public Date userRegitrationDate(DefaultContext context) {
        return context.get(User.class).registrationDate().toDate();
    }
}
