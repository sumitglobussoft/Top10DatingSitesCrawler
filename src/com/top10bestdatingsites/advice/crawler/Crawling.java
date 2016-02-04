/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.top10bestdatingsites.advice.crawler;

import com.clonescriptscrapper.dao.CloneScriptDirectoryDaoImpl;
import com.top10bestdatingsites.utility.FetchSource;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author GLB-130
 */
public class Crawling {

    FetchSource objFetchSource = new FetchSource();
    List<String> listUrls = new ArrayList<>();

//    public static void main(String[] args) {
//        new Crawling().dataPagination("http://www.top10bestdatingsites.com/senior/reviews");
//    }
    public void dataPagination(String urlPage, CloneScriptDirectoryDaoImpl objCloneScriptDirectoryDaoImpl) {

        
        Document objDocument = null;
        String urlResponse = null;
        try {
            urlResponse = objFetchSource.fetchPageSourceWithProxy(urlPage);

            objDocument = Jsoup.parse(urlResponse);

            Elements ee = objDocument.select("div[class=content left] div[class=entry] article");
//            System.out.println(""+ee);
            for (Element ee1 : ee) {

                String url = ee1.select("a").attr("href");
                listUrls.add("http://www.top10bestdatingsites.com" + url);
                System.out.println("url::" + url);
            }
            try {
                String pagination = objDocument.select("div[class=content left] div[class=entry] div[class=nextPrevContainer] a[title=Next Articles]").attr("href");
                System.out.println("pagination::" + pagination);
                if (pagination.length() > 0) {
                    dataPagination("http://www.top10bestdatingsites.com" + pagination, objCloneScriptDirectoryDaoImpl);
                } 
                else{
                     ExecutorService executor = Executors.newFixedThreadPool(1);
            for (String line1 : listUrls) {
                System.out.println("" + line1);
                try {
                    Runnable worker = new ScrapUrl(line1, objCloneScriptDirectoryDaoImpl);
                    executor.execute(worker);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
                }
            } catch (Exception e) {
                System.out.println("over");
            }

           
        } catch (Exception e) {

        }
    }
}
