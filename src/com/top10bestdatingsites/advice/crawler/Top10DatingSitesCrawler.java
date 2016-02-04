/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.top10bestdatingsites.advice.crawler;

import com.clonescriptscrapper.dao.CloneScriptDirectoryDaoImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Ashwini Mendon
 */
public class Top10DatingSitesCrawler {
    
        ApplicationContext context
            = new ClassPathXmlApplicationContext("Beans.xml");
    // TODO code application logic here

    CloneScriptDirectoryDaoImpl objCloneScriptDirectoryDaoImpl
            = (CloneScriptDirectoryDaoImpl) context.getBean("CloneScriptDirectoryDaoImpl");

    public final static void main(String[] args) throws Exception {
        System.out.println("----------------------------------------");
        new Top10DatingSitesCrawler().getdata();
//        BufferedReader reader = new BufferedReader(new FileReader("urls.txt"));
//        String line = reader.readLine();
        
        
        
        

//        ExecutorService executor = Executors.newFixedThreadPool(1);
////        for (String line1 : lines) {
////            System.out.println(""+line1);
//            try {
//                Runnable worker = new ScrappEachUrl(line1);
//                executor.execute(worker);
//                } catch (Exception e) {
//                        System.out.println(e);
//                }
            
//        }
    }
    
    public void getdata(){
        List<String> lines = new ArrayList<String>();
        
//        while (line != null) {
//            lines.add(line);
//            line = reader.readLine();
//          }
//        String line1 ="http://www.top10bestdatingsites.com/reviews";
//        String line1 ="http://www.top10bestdatingsites.com/senior/reviews";
//        lines.add("http://www.top10bestdatingsites.com/advice");
//        lines.add("http://www.top10bestdatingsites.com/senior/advice");
        lines.add("http://www.top10bestdatingsites.com/gay/advice");
        lines.add("http://www.top10bestdatingsites.com/lesbian/advice");
        lines.add("http://www.top10bestdatingsites.com/christian/advice");
        
        for (String line : lines) {
            Crawling obj = new Crawling();
        obj.dataPagination(line,objCloneScriptDirectoryDaoImpl);
        }
        
    }

    
}

