// SPDX-FileCopyrightText: 2021 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.scl.data.websocket.v1.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import static org.lfenergy.compas.scl.data.SclDataServiceConstants.SCL_DATA_SERVICE_V1_NS_URI;

@Schema(description = "Request to create a new entry in the database containing the SCL Element content.")
@XmlType(name = "CreateWsRequest", namespace = SCL_DATA_SERVICE_V1_NS_URI)
@XmlRootElement(name = "CreateWsRequest", namespace = SCL_DATA_SERVICE_V1_NS_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateWsRequest extends org.lfenergy.compas.scl.data.rest.v1.model.CreateRequest {
}

