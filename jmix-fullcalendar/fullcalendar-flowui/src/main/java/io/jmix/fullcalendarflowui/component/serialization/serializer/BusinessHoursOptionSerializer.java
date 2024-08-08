/*
 * Copyright 2024 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.fullcalendarflowui.component.serialization.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.jmix.fullcalendarflowui.component.model.option.BusinessHoursOption;

import java.io.IOException;

public class BusinessHoursOptionSerializer extends StdSerializer<BusinessHoursOption> {

    public BusinessHoursOptionSerializer() {
        super(BusinessHoursOption.class);
    }

    @Override
    public void serialize(BusinessHoursOption value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value.getBusinessHours() != null && !value.getBusinessHours().isEmpty()) {
            gen.writeStartObject();
            gen.writeObjectField("businessHours", value.getBusinessHours());
            gen.writeEndObject();
        } else {
            gen.writeStartObject();
            gen.writeBooleanField("enabled", value.isEnabled());
            gen.writeEndObject();
        }
    }
}
