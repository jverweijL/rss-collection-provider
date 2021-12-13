package com.liferay.demo.info.collection.provider;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ClassedModel;

import java.io.Serializable;

public class News implements ClassedModel {

    @Override
    public Class<?> getModelClass() {
        return News.class;
    }

    @Override
    public String getModelClassName() {
        return News.class.getName();
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    // not implemented
    @Override
    public ExpandoBridge getExpandoBridge() {
        return null;
    }

    // not implemented
    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
    }

    public News(long id, String name, String image, String description, String link) {
        _id = id;
        _name = name;
        _image = image;
        _description = description;
        _link = link;
    }

    public long getId() {
        return _id;
    }

    public String getImage() {
        return _image;
    }

    public String getName() {
        return _name;
    }

    public String getDescription() {
        return _description;
    }

    public String getLink() {
        return _link;
    }

    private long _id;
    private String _image;
    private String _name;
    private String _description;
    private String _link;

}
