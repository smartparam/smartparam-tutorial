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
import org.smartparam.engine.core.context.LevelValues;
import org.smartparam.tutorial.domain.DateProvider;
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

    private final DateProvider dateProvider;

    @Autowired
    public DiscountCalculator(ParamEngine paramEngine, DateProvider dateProvider) {
        this.paramEngine = paramEngine;
        this.dateProvider = dateProvider;
    }

    public Discount calculateForUser(User user) {
        long loyaltyDiscountValue = paramEngine.get("discount.loyalty",
                user.registrationDate().toDate(),
                user.accountType().name()).getLong();
        Discount loyaltyDiscount = new Discount(loyaltyDiscountValue);

        long targetedDiscountValue = paramEngine.get("discount.targeted",
                dateProvider.currentDate().toDate(),
                user.login().value()).getLong();
        Discount targetedDiscount = new Discount(targetedDiscountValue);

        Discount combinedDiscount = (Discount) paramEngine.callEvaluatedFunction("discount.policy",
                new LevelValues(dateProvider.currentDate().toDate(), user.accountType().name()),
                loyaltyDiscount, targetedDiscount);

        return combinedDiscount;
    }

}
