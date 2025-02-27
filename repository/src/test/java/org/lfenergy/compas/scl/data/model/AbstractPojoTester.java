// SPDX-FileCopyrightText: 2021 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0
package org.lfenergy.compas.scl.data.model;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.Test;

abstract class AbstractPojoTester {
    @Test
    void validateSettersAndGetters() {
        var personPojo = PojoClassFactory.getPojoClass(getClassToBeTested());
        var validator = ValidatorBuilder.create()
                // Let's make sure that we have a getter and a setter for every field defined.
                .with(new GetterMustExistRule(), new SetterMustExistRule())
                // Let's also validate that they are behaving as expected
                .with(new SetterTester(), new GetterTester())
                .build();

        // Start the Test
        validator.validate(personPojo);
    }

    protected abstract Class<?> getClassToBeTested();
}
