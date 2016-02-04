/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.top10bestdatingsites.advice.crawler;

import com.clonescriptscrapper.dao.CloneScriptDirectoryDaoImpl;
import com.top10bestdatingsites.entity.Advices;
import com.top10bestdatingsites.utility.FetchSource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author GLB-130
 */
public class ScrapUrl implements Runnable {
//      ApplicationContext context
//            = new ClassPathXmlApplicationContext("Beans.xml");
//    // TODO code application logic here
//
//    CloneScriptDirectoryDao objCloneScriptDirectoryDaoImpl1
//            = (CloneScriptDirectoryDaoImpl) context.getBean("CloneScriptDirectoryDaoImpl");

    FetchSource objFetchSource = new FetchSource();
    
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
    public static void main(String[] args) {
        ScrapUrl obj =new ScrapUrl("http://www.top10bestdatingsites.com/advice/stats/online-dating-trends-to-look-out-for-in-2016", null);
    obj.fetchData("http://www.top10bestdatingsites.com/advice/stats/online-dating-trends-to-look-out-for-in-2016", null);
    }

    public void fetchData(String url,CloneScriptDirectoryDaoImpl objCloneScriptDirectoryDaoImpl) {
        
        Advices objAdvices = new Advices();

        Document objDocument = null;
        String urlResponse = null;
        try {
            urlResponse = objFetchSource.fetchPageSourceWithProxy(url);

            objDocument = Jsoup.parse(urlResponse);

            Elements fullHTML = objDocument.select("div[class=content left] div[class=entry");
         
//            System.out.println("fullHTML::::"+fullHTML);
                    

            String headline = fullHTML.select("h1").text();
            System.out.println("headline::" + headline);
            
           objDocument.getElementsByClass("cta_widget").remove();
           fullHTML = objDocument.select("div[class=content left] div[class=entry");
         
//            System.out.println("fullHTML::::"+fullHTML);
           
//
//            String rating = ee.select("aside[class=sidebar left] div[itemprop=ratingValue]").text();
//            System.out.println("rating:::" + rating);
//
//            Elements fullHTML = ee.select("div[class=content right] div[class=text-entry]");
//            System.out.println("fullHTML:::" + fullHTML);

            objAdvices.setFullHtml(fullHTML.toString());
            objAdvices.setHeading(headline);
            objAdvices.setUrl(url);
            objCloneScriptDirectoryDaoImpl.insertAdvices(objAdvices);
            
            
        } catch (Exception e) {

        }

    }

}
