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
package org.smartparam.tutorial.domain.discount;

import org.smartparam.engine.core.ParamEngine;
import org.smartparam.tutorial.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adam Dubiel
 */
@Service
public class DiscountCalculator {

    private final ParamEngine paramEngine;

    @Autowired
    public DiscountCalculator(ParamEngine paramEngine) {
        this.paramEngine = paramEngine;
    }

    public Discount calculateForUser(User user) {
        long discountValue = paramEngine.get("discount.loyalty",
                user.registrationDate().toDate(),
                user.accountType().name()).getLong();
        return new Discount(discountValue);
    }

}
