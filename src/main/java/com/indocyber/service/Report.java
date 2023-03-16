package com.indocyber.service;

import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class Report {

    @Autowired
    private TransactionService transactionService;

    public JasperPrint downloadPdf(String date, String dateEnd) throws FileNotFoundException, JRException, SQLException {
        File jasperFile = ResourceUtils.getFile("classpath:reports/Test Cash Bon.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperFile.getAbsolutePath());

        LocalDate dateParam = LocalDate.parse(date);
        LocalDate dateEndParam = LocalDate.parse(dateEnd);
        Map<String, Object> parameter = new HashMap<>();

        System.out.println(dateEndParam);

        parameter.put("date", dateParam);
        parameter.put("dateEnd", dateEndParam);
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceBuilder.url("jdbc:sqlserver://localhost:1433;databaseName=TrollMarket;trustServerCertificate=true;");
        dataSourceBuilder.username("admin");
        dataSourceBuilder.password("123");

        return JasperFillManager.fillReport(jasperReport, parameter, dataSourceBuilder.build().getConnection());
    }
}
