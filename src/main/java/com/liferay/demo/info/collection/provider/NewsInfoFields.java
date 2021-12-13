package com.liferay.demo.info.collection.provider;

import com.liferay.info.field.InfoField;
import com.liferay.info.field.type.ImageInfoFieldType;
import com.liferay.info.field.type.TextInfoFieldType;
import com.liferay.info.localized.InfoLocalizedValue;

public interface NewsInfoFields {
    public final InfoField<ImageInfoFieldType> imageInfoField =
            InfoField.builder(
            ).infoFieldType(
                    ImageInfoFieldType.INSTANCE
            ).name(
                    "image"
            ).labelInfoLocalizedValue(
                    InfoLocalizedValue.localize(News.class, "image")
            ).build();

    public final InfoField<TextInfoFieldType> nameInfoField = InfoField.builder(
    ).infoFieldType(
            TextInfoFieldType.INSTANCE
    ).name(
            "name"
    ).labelInfoLocalizedValue(
            InfoLocalizedValue.localize(News.class, "name")
    ).build();

    public final InfoField<TextInfoFieldType> descriptionInfoField = InfoField.builder(
    ).infoFieldType(
            TextInfoFieldType.INSTANCE
    ).name(
            "description"
    ).labelInfoLocalizedValue(
            InfoLocalizedValue.localize(News.class, "description")
    ).build();

    public final InfoField<TextInfoFieldType> linkInfoField = InfoField.builder(
    ).infoFieldType(
            TextInfoFieldType.INSTANCE
    ).name(
            "link"
    ).labelInfoLocalizedValue(
            InfoLocalizedValue.localize(News.class, "link")
    ).build();


}
