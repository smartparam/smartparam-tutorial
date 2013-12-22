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
package org.smartparam.tutorial.param.type;

import org.smartparam.tutorial.domain.UserLogin;
import org.smartparam.engine.annotated.annotations.ParamType;
import org.smartparam.engine.core.type.SimpleType;

/**
 *
 * @author Adam Dubiel
 */
@ParamType("userLogin")
public class UserLoginType extends SimpleType<UserLogin> {

    public UserLoginType() {
        super(UserLogin.class);
    }

    @Override
    protected String encodeValue(UserLogin userLogin) {
        return userLogin.value();
    }

    @Override
    protected UserLogin decodeValue(String text) {
        return new UserLogin(text);
    }

}
