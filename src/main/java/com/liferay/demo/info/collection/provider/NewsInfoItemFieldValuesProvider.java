package com.liferay.demo.info.collection.provider;

import com.liferay.info.field.InfoFieldValue;
import com.liferay.info.item.InfoItemFieldValues;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.provider.InfoItemFieldValuesProvider;
import com.liferay.info.type.WebImage;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = InfoItemFieldValuesProvider.class)
public class NewsInfoItemFieldValuesProvider
        implements InfoItemFieldValuesProvider<News> {

    @Override
    public InfoItemFieldValues getInfoItemFieldValues(News news) {
        return InfoItemFieldValues.builder(
        ).infoFieldValues(
                _getInfoFieldValues(news)
        ).infoItemReference(
                new InfoItemReference(News.class.getName(), news.getId())
        ).build();
    }

    private List<InfoFieldValue<Object>> _getInfoFieldValues(News news) {
        List<InfoFieldValue<Object>> infoFieldValues = new ArrayList<>();

        infoFieldValues.add(
                new InfoFieldValue<>(
                        NewsInfoFields.nameInfoField, news.getName()));
        infoFieldValues.add(
                new InfoFieldValue<>(
                        NewsInfoFields.imageInfoField, new WebImage(news.getImage())));
        infoFieldValues.add(
                new InfoFieldValue<>(
                        NewsInfoFields.descriptionInfoField, news.getDescription()));
        infoFieldValues.add(
                new InfoFieldValue<>(
                        NewsInfoFields.linkInfoField, news.getLink()));

        return infoFieldValues;
    }
}
