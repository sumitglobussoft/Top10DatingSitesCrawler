/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.top10bestdatingsites.crawler;

import com.clonescriptscrapper.dao.CloneScriptDirectoryDaoImpl;
import com.top10bestdatingsites.entity.Alldata;
import com.top10bestdatingsites.utility.FetchGooglePageWithProxy;
import java.net.URI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author GLB-130
 */
public class ScrapUrl implements Runnable {

    FetchGooglePageWithProxy FetchGooglePageWithProxy = new FetchGooglePageWithProxy();
    
    CloneScriptDirectoryDaoImpl objCloneScriptDirectoryDaoImpl = null;

    String url = null;

    ScrapUrl(String url,CloneScriptDirectoryDaoImpl objCloneScriptDirectoryDaoImpl) {
      
        this.url = url;
        this.objCloneScriptDirectoryDaoImpl = objCloneScriptDirectoryDaoImpl;
    }

    @Override
    public void run() {
        
        fetchData(url, objCloneScriptDirectoryDaoImpl);

    }
//    public static void main(String[] args) {
//        new ScrapUrl().fetchData("senior", "http://www.top10bestdatingsites.com/senior/reviews/match");
//    }

    public void fetchData(String url,CloneScriptDirectoryDaoImpl objCloneScriptDirectoryDaoImpl) {
        
        Alldata objAlldata = new Alldata();

        Document objDocument = null;
        String urlResponse = null;
        try {
            urlResponse = FetchGooglePageWithProxy.fetchPageSourcefromClientGoogle(new URI(url));

            objDocument = Jsoup.parse(urlResponse);

            Elements ee = objDocument.select("section[class=main] div[class=shell clearfix]");

            String headline = ee.select("div[class=review_top] h1").text();
            System.out.println("headline::" + headline);

            String rating = ee.select("aside[class=sidebar left] div[itemprop=ratingValue]").text();
            System.out.println("rating:::" + rating);

            Elements fullHTML = ee.select("div[class=content right] div[class=text-entry]");
            System.out.println("fullHTML:::" + fullHTML);

            objAlldata.setFullHtml(fullHTML.toString());
            objAlldata.setHeadline(headline);
            objAlldata.setRating(rating);
            objAlldata.setUrl(url);
            objCloneScriptDirectoryDaoImpl.insertAlldata(objAlldata);
            
            
        } catch (Exception e) {

        }

    }

}
