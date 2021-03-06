/**
 * Copyright (C) 2020 SINTEF
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package no.sintef.fiskinfo.model.fishingfacility

import android.content.Context
import com.google.gson.annotations.SerializedName
import no.sintef.fiskinfo.R

enum class ToolTypeCode(val code : String, val stringResource : Int) {
    @SerializedName("NETS")
    NETS("NETS", R.string.tool_type_code_nets),

    @SerializedName("LONGLINE")
    LONGLINE("LONGLINE", R.string.tool_type_code_longline),

    @SerializedName("CRABPOT")
    CRABPOT("CRABPOT", R.string.tool_type_code_crabpot),

    @SerializedName("DANPURSEINE")
    DANPURSEINE("DANPURSEINE", R.string.tool_type_code_danpurseine);

    fun getLocalizedName(context : Context):String {
        return context.resources.getString(stringResource)
    }
}