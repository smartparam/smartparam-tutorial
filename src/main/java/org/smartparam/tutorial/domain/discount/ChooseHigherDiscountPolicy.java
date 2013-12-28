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

import org.smartparam.spring.function.SpringPlugin;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adam Dubiel
 */
@Service
public class ChooseHigherDiscountPolicy implements MultiDiscountPolicy {

    @Override
    @SpringPlugin("discount.policy.chooseHigher")
    public Discount combine(Discount discountA, Discount discountB) {
        return discountA.value() >= discountB.value() ? discountA : discountB;
    }

}
