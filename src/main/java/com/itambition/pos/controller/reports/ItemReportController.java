package com.itambition.pos.controller.reports;

import com.itambition.pos.repository.ItemRepo;
import com.itambition.pos.service.ReportItemService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
@RestController
public class ItemReportController {
    @Autowired
    private ItemRepo repository;

    @Autowired
    private ReportItemService servicereportitem;

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return servicereportitem.exportReport(format);
    }

    @GetMapping("/report/nostock/{format}")
    public String generateReportnostock(@PathVariable String format) throws FileNotFoundException, JRException {
        return servicereportitem.exportReportnostock(format);
    }
}
