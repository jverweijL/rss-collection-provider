package com.liferay.demo.info.collection.provider;

import com.liferay.info.field.InfoField;
import com.liferay.info.field.type.ImageInfoFieldType;
import com.liferay.info.field.type.TextInfoFieldType;
import com.liferay.info.localized.InfoLocalizedValue;

public interface NewsInfoFields {

    InfoField<ImageInfoFieldType>
            imageInfoField = BuilderHolder._builder.infoFieldType(
            ImageInfoFieldType.INSTANCE
    ).name(
            "image"
    ).labelInfoLocalizedValue(
            InfoLocalizedValue.localize(
                    News.class, "image")
    ).build();

    InfoField<TextInfoFieldType>
            nameInfoField = BuilderHolder._builder.infoFieldType(
            TextInfoFieldType.INSTANCE
    ).name(
            "name"
    ).labelInfoLocalizedValue(
            InfoLocalizedValue.localize(
                    News.class, "name")
    ).build();

    InfoField<TextInfoFieldType>
            descriptionInfoField = BuilderHolder._builder.infoFieldType(
            TextInfoFieldType.INSTANCE
    ).name(
            "description"
    ).labelInfoLocalizedValue(
            InfoLocalizedValue.localize(
                    News.class, "description")
    ).build();

    InfoField<TextInfoFieldType>
            linkInfoField = BuilderHolder._builder.infoFieldType(
            TextInfoFieldType.INSTANCE
    ).name(
            "link"
    ).labelInfoLocalizedValue(
            InfoLocalizedValue.localize(
                    News.class, "link")
    ).build();

    class BuilderHolder {

        private static final InfoField.NamespacedBuilder _builder =
                InfoField.builder(News.class.getSimpleName());

    }
}