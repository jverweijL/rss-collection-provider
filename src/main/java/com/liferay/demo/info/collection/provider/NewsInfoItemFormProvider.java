package com.liferay.demo.info.collection.provider;

import com.liferay.info.field.InfoFieldSet;
import com.liferay.info.form.InfoForm;
import com.liferay.info.item.provider.InfoItemFormProvider;
import com.liferay.info.localized.InfoLocalizedValue;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = InfoItemFormProvider.class)
public class NewsInfoItemFormProvider
        implements InfoItemFormProvider<News> {

    @Override
    public InfoForm getInfoForm() {
        return InfoForm.builder(
        ).infoFieldSetEntry(
                InfoFieldSet.builder(
                ).infoFieldSetEntry(
                        NewsInfoFields.nameInfoField
                ).infoFieldSetEntry(
                        NewsInfoFields.imageInfoField
                ).infoFieldSetEntry(
                        NewsInfoFields.descriptionInfoField
                ).infoFieldSetEntry(
                        NewsInfoFields.linkInfoField
                ).labelInfoLocalizedValue(
                        InfoLocalizedValue.localize(NewsInfoFields.class, "news")
                ).build()
        ).name(
                "News"
        ).build();
    }
}
