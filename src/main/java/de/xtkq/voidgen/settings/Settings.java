/*
 *     CitizensBooks
 *     Copyright (c) 2023 @ Drăghiciu 'NicoNekoDev' Nicolae
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package de.xtkq.voidgen.settings;

import de.xtkq.voidgen.settings.impl.BooleanSetting;

import java.util.List;

public class Settings {
    public static final BooleanSetting CHECK_FOR_UPDATES = new BooleanSetting("check_for_updates", true,
            List.of(
                    "Whether or not to check for updates."
            )
    );
    public static final BooleanSetting ENABLE_METRICS = new BooleanSetting("enable_metrics", true,
            List.of(
                    "bStats metrics collected by this plugin.",
                    "https://bstats.org/plugin/bukkit/VoidGen/26816"
            )
    );
    public static final BooleanSetting ENABLE_VERBOSE = new BooleanSetting("enable_verbose", true,
            List.of(
                    "Setting it to false will disable all debug messages."
            )
    );
}