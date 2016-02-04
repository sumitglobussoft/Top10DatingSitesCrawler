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
@Table(name = "advices", catalog = "top10bestdatingsites", schema = "")
public class Advices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADVICE_ID")
    private Integer adviceId;
    @Basic(optional = false)
    @Column(name = "URL")
    private String url;
    @Column(name = "HEADING")
    private String heading;
    @Lob
    @Column(name = "FULL_HTML")
    private String fullHtml;

    public Advices() {
    }

    public Advices(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public Advices(Integer adviceId, String url) {
        this.adviceId = adviceId;
        this.url = url;
    }

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
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
        hash += (adviceId != null ? adviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advices)) {
            return false;
        }
        Advices other = (Advices) object;
        if ((this.adviceId == null && other.adviceId != null) || (this.adviceId != null && !this.adviceId.equals(other.adviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.top10bestdatingsites.entity.Advices[ adviceId=" + adviceId + " ]";
    }
    
}
