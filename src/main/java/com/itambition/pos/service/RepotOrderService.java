package com.itambition.pos.service;

import com.itambition.pos.repository.OrderRepo;
import com.itambition.pos.entity.OrderEnitiy;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RepotOrderService {



    @Autowired
    private OrderRepo o;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "E:\\reports\\New folder";
        List<OrderEnitiy> items = o.findAll();        //load file and compile it
        File file = ResourceUtils.getFile("classpath:itemreport.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\item.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\item.pdf");
        }

        return "report generated in path : " + path;
    }

}
