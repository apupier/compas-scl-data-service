// SPDX-FileCopyrightText: 2021 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0
package org.lfenergy.compas.scl.data.rest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CompasSclDataServiceConfigurationTest {
    @Test
    void createElementConverter_WhenCalled_ThenObjectReturned() {
        assertNotNull(new CompasSclDataServiceConfiguration().createElementConverter());
    }

    @Test
    void createSclDataModelMarshaller_WhenCalled_ThenObjectReturned() {
        assertNotNull(new CompasSclDataServiceConfiguration().createSclDataModelMarshaller());
    }
}