/**
 * Copyright (c) 2014,2017 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.knx.internal.profiles;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.thing.profiles.ProfileTypeBuilder;
import org.eclipse.smarthome.core.thing.profiles.ProfileTypeUID;
import org.eclipse.smarthome.core.thing.profiles.StateProfileType;

/**
 * KNX profile constants.
 *
 * @author Karel Goderis - initial contribution and API.
 *
 */
@NonNullByDefault
public interface KNXProfiles {

    ProfileTypeUID COMMAND = new ProfileTypeUID(KNXProfileTypeUID.KNX_SCOPE, "command");
    ProfileTypeUID INBOUND = new ProfileTypeUID(KNXProfileTypeUID.KNX_SCOPE, "inbound");

    StateProfileType COMMAND_TYPE = ProfileTypeBuilder.newState(COMMAND, "Command").build();
    StateProfileType INBOUND_TYPE = ProfileTypeBuilder.newState(INBOUND, "Inbound").build();
}