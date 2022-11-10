// SPDX-FileCopyrightText: 2021 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.scl.data.websocket.v1.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.xml.bind.annotation.*;
import java.util.UUID;

import static org.lfenergy.compas.scl.data.SclDataServiceConstants.SCL_DATA_SERVICE_V1_NS_URI;

@Schema(description = "Request to update an existing entry in the database containing the SCL Element content. " +
        "A new version is created and the old version is also kept.")
@XmlType(name = "UpdateWsRequest", namespace = SCL_DATA_SERVICE_V1_NS_URI)
@XmlRootElement(name = "UpdateWsRequest", namespace = SCL_DATA_SERVICE_V1_NS_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateRequest extends org.lfenergy.compas.scl.data.rest.v1.model.UpdateRequest {
    @Schema(description = "The ID of the SCL File.",
            example = "f7b98f4d-3fe4-4df2-8533-d7f0c1800344")
    @XmlElement(name = "Id", namespace = SCL_DATA_SERVICE_V1_NS_URI, required = true)
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
