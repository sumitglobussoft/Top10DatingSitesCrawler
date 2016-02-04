/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clonescriptscrapper.dao;


import com.top10bestdatingsites.entity.Advices;
import com.top10bestdatingsites.entity.Alldata;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author GLB-214
 */
public class CloneScriptDirectoryDaoImpl implements CloneScriptDirectoryDao {

    private SimpleJdbcInsert launchDataInsert;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void insertAlldata(Alldata objAlldata) {

        String SQL = "insert into alldata (URL, HEADLINE, RATING, FULL_HTML) values (?, ?, ?, ?)";
        try {
            jdbcTemplateObject.update(SQL, objAlldata.getUrl(), objAlldata.getHeadline(), objAlldata.getRating(), objAlldata.getFullHtml());
            System.out.println("Alldata Data inserted");
        } catch (Exception e) {
        }
    }
    
    @Override
    public void insertAdvices(Advices objAdvices){
         String SQL = "insert into advices (URL, HEADING, FULL_HTML) values (?, ?, ?)";
        try {
            jdbcTemplateObject.update(SQL, objAdvices.getUrl(), objAdvices.getHeading(), objAdvices.getFullHtml());
            System.out.println("Advices Data inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
