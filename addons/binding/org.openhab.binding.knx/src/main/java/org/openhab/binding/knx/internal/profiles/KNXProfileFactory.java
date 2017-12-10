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

import java.util.Collection;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.smarthome.core.thing.profiles.Profile;
import org.eclipse.smarthome.core.thing.profiles.ProfileCallback;
import org.eclipse.smarthome.core.thing.profiles.ProfileContext;
import org.eclipse.smarthome.core.thing.profiles.ProfileFactory;
import org.eclipse.smarthome.core.thing.profiles.ProfileType;
import org.eclipse.smarthome.core.thing.profiles.ProfileTypeProvider;
import org.eclipse.smarthome.core.thing.profiles.ProfileTypeUID;
import org.osgi.service.component.annotations.Component;

/**
 * A factory and advisor for KNX profiles.
 *
 * This {@link ProfileFactory} implementation handles all KNX {@link Profile}s.
 *
 * @author Karel Goderis - initial contribution and API.
 *
 */
@NonNullByDefault
@Component(service = ProfileFactory.class)
public class KNXProfileFactory implements ProfileFactory, ProfileTypeProvider {

    private static final Set<ProfileType> SUPPORTED_PROFILE_TYPES = Stream
            .of(KNXProfiles.COMMAND_TYPE, KNXProfiles.INBOUND_TYPE).collect(Collectors.toSet());

    private static final Set<ProfileTypeUID> SUPPORTED_PROFILE_TYPE_UIDS = Stream
            .of(KNXProfiles.COMMAND, KNXProfiles.INBOUND).collect(Collectors.toSet());

    @Nullable
    @Override
    public Profile createProfile(ProfileTypeUID profileTypeUID, ProfileCallback callback, ProfileContext context) {
        if (KNXProfiles.COMMAND.equals(profileTypeUID)) {
            return new KNXCommandProfile(callback);
        } else if (KNXProfiles.INBOUND.equals(profileTypeUID)) {
            return new KNXInboundProfile(callback);
        } else {
            return null;
        }
    }

    @Override
    public Collection<ProfileType> getProfileTypes(@Nullable Locale locale) {
        return SUPPORTED_PROFILE_TYPES;
    }

    @Override
    public @NonNull Collection<@NonNull ProfileTypeUID> getSupportedProfileTypeUIDs() {
        return SUPPORTED_PROFILE_TYPE_UIDS;
    }

}
