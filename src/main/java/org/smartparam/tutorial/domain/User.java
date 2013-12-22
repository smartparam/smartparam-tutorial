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
package org.smartparam.tutorial.domain;

import org.joda.time.LocalDate;

/**
 *
 * @author Adam Dubiel
 */
public class User {

    private final UserLogin login;

    private final LocalDate registrationDate;

    private final UserAccountType accountType;

    public User(UserLogin login, LocalDate registrationDate, UserAccountType accountType) {
        this.login = login;
        this.registrationDate = registrationDate;
        this.accountType = accountType;
    }

    public UserLogin login() {
        return login;
    }

    public LocalDate registrationDate() {
        return registrationDate;
    }

    public UserAccountType accountType() {
        return accountType;
    }

}
