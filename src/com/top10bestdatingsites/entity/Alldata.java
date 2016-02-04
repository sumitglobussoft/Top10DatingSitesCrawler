/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.top10bestdatingsites.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author GLB-130
 */
@Entity
@Table(name = "alldata", catalog = "top10bestdatingsites", schema = "")
public class Alldata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DATA_ID")
    private Integer dataId;
    @Basic(optional = false)
    @Column(name = "URL")
    private String url;
    @Column(name = "HEADLINE")
    private String headline;
    @Column(name = "RATING")
    private String rating;
    @Lob
    @Column(name = "FULL_HTML")
    private String fullHtml;

    public Alldata() {
    }

    public Alldata(Integer dataId) {
        this.dataId = dataId;
    }

    public Alldata(Integer dataId, String url) {
        this.dataId = dataId;
        this.url = url;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFullHtml() {
        return fullHtml;
    }

    public void setFullHtml(String fullHtml) {
        this.fullHtml = fullHtml;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataId != null ? dataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alldata)) {
            return false;
        }
        Alldata other = (Alldata) object;
        if ((this.dataId == null && other.dataId != null) || (this.dataId != null && !this.dataId.equals(other.dataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.top10bestdatingsites.entity.Alldata[ dataId=" + dataId + " ]";
    }
    
}
