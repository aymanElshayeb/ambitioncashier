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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RepotOrderService {



    @Autowired
    private OrderRepo o;

    public String exportreport(String reportFormat, Timestamp one, Timestamp tow) throws FileNotFoundException, JRException {
        String path = "E:\\reportorder";
        List<OrderEnitiy> orders = o.findAll();
        List<OrderEnitiy> orderss = new ArrayList<>();


        int b= one.compareTo(tow);

        if(b>=0) {

            for (int i = 0; i < orders.size(); i++) {
                int c=orders.get(i).getDateTime().compareTo(one);
                int d=orders.get(i).getDateTime().compareTo(tow);
                if (c<=0&&d>=0) {


                    orderss.add(i, orders.get(i));
                }

            }

            File file = ResourceUtils.getFile("classpath:0rders.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orderss);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "Java Techie");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            if (reportFormat.equalsIgnoreCase("html")) {
                JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\order.html");
            }
            if (reportFormat.equalsIgnoreCase("pdf")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\order.pdf");
            }

            return "report generated in path : " + path;
        }
        else
        {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getDateTime().compareTo(tow)<=0&&orders.get(i).getDateTime().compareTo(one)>=0) {


                    orderss.add(i, orders.get(i));
                }

            }

            File file = ResourceUtils.getFile("classpath:0rders.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orderss);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "Java Techie");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            if (reportFormat.equalsIgnoreCase("html")) {
                JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\order.html");
            }
            if (reportFormat.equalsIgnoreCase("pdf")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\order.pdf");
            }

            return "report generated in path : " + path;

        }
    }



}
