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
import org.eclipse.smarthome.core.thing.UID;

/**
 * Identifier of a profile type.
 *
 * @author Karel Goderis - initial contribution and API.
 *
 */
@NonNullByDefault
public class KNXProfileTypeUID extends UID {

    public static final String KNX_SCOPE = "knx";

    public KNXProfileTypeUID(String profileType) {
        super(profileType);
    }

    public KNXProfileTypeUID(String scope, String id) {
        super(scope, id);
    }

    @Override
    protected int getMinimalNumberOfSegments() {
        return 2;
    }

    public String getScope() {
        return getSegment(0);
    }

    public String getId() {
        return getSegment(1);
    }

}
