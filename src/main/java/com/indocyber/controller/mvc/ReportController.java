package com.indocyber.controller.mvc;

import com.indocyber.service.Report;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private Report report;

    @GetMapping("/download")
    public void exportToPdf(HttpServletResponse response, @Param("date") String date, @Param("dateEnd") String dateEnd) throws JRException, SQLException, IOException {

        String filename = "TestJasper-" + DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss").format(LocalDateTime.now()) + ".pdf";
        response.setContentType("application/pdf");
        response.addHeader("Content-disposition", "attachment; filename=" + filename);
        OutputStream out = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(report.downloadPdf(date, dateEnd), out);
    }
}
