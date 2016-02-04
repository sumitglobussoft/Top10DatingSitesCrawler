/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.top10bestdatingsites.crawler;

import com.clonescriptscrapper.dao.CloneScriptDirectoryDaoImpl;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.top10bestdatingsites.form.IndiabixForm;
import com.top10bestdatingsites.utility.FetchGooglePageWithProxy;
import com.top10bestdatingsites.utility.PostFetchSource;
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
    FetchGooglePageWithProxy FetchGooglePageWithProxy = new FetchGooglePageWithProxy();
    
//    public static void main(String[] args) {
//        new Crawling().dataPagination("http://www.top10bestdatingsites.com/senior/reviews");
//    }
    public void dataPagination(String urlPage,CloneScriptDirectoryDaoImpl objCloneScriptDirectoryDaoImpl) {
        
        List<String> listUrls = new ArrayList<>();
         Document objDocument = null;
        String urlResponse = null;
        try {
            urlResponse = FetchGooglePageWithProxy.fetchPageSourcefromClientGoogle(new URI(urlPage));
            
            
            objDocument = Jsoup.parse(urlResponse);
            
            Elements ee = objDocument.select("div[class=review-list] ul li div[class=site-info] p a[class=more]");
            for (Element ee1 : ee) {
                
                String url=ee1.attr("href");
                listUrls.add("http://www.top10bestdatingsites.com"+url);
                 System.out.println("urlResponse"+url);
            }
            
            ExecutorService executor = Executors.newFixedThreadPool(10);
        for (String line1 : listUrls) {
            System.out.println(""+line1);
            try {
                Runnable worker = new ScrapUrl(line1,objCloneScriptDirectoryDaoImpl);
                executor.execute(worker);
                } catch (Exception e) {
                        System.out.println(e);
                }
            
        }
           
            
    }catch(Exception e){
        
    }
    }
}
