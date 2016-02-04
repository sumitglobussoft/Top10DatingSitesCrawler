/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.top10bestdatingsites.csv;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author GLB-130
 */
public class XlsGenerationAdvice {
    public static void main(String[] args) {
     new XlsGenerationAdvice().generateXLS();
    }
    
    public void generateXLS() {

        HSSFWorkbook hwb = new HSSFWorkbook();
        HSSFSheet sheet = hwb.createSheet("Monster Details");
        HSSFRow rowhead = sheet.createRow((int) 0);
        rowhead.createCell((int) 0).setCellValue("S.No.");
        rowhead.createCell((int) 1).setCellValue("URL");
        rowhead.createCell((int) 2).setCellValue("HEADLINE");
        rowhead.createCell((int) 3).setCellValue("FULL_HTML");
       

        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/top10bestdatingsites", "root", "");
            String sql = "SELECT * FROM  advices;";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int k = 0;
            while (rs.next()) {

                HSSFRow row = sheet.createRow((int) k + 2);
                try {
                    row.createCell((int) 0).setCellValue(k + 1);
                } catch (Exception sd) {
                }
                try {
                    row.createCell((int) 1).setCellValue(rs.getString("URL") + "");
                } catch (Exception sd) {
                }

                try {
                    row.createCell((int) 2).setCellValue(rs.getString("HEADING") + "");
                } catch (Exception sd) {
                }

                try {
                    row.createCell((int) 3).setCellValue(rs.getString("FULL_HTML") + "");
                } catch (Exception sd) {
                }

                

                k++;
            }

        } catch (Exception aaa) {
        }

      
     
        try {
            
            String filename = "data_advice.csv";
            System.out.println("Directory is created!");
            FileOutputStream fileOut = new FileOutputStream(filename);
            hwb.write(fileOut);
            fileOut.close();
            System.out.println("Your excel file has been generated!");
        } catch (IOException iOException) {
        }
            
        

    }
    
}
