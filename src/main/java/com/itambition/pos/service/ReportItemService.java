package com.itambition.pos.service;


import com.itambition.pos.repository.ItemRepo;
import com.itambition.pos.entity.ItemEnitiy;
import com.itambition.pos.entity.classes.exp;
import net.sf.jasperreports.engine.*;


import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class ReportItemService {
    @Autowired
    private ItemRepo R;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "E:\\reports\\New folder";
        List<ItemEnitiy> items = R.findAll();//load file and compile it

        ArrayList<exp> ee=new ArrayList<exp>();





        for(int i=0;i<items.size();i++){
            exp a= new exp(items.get(i).getName(),items.get(i).getBarcode(),items.get(i).getPrice(),items.get(i).getQuantity(),items.get(i).getSubCategory().getName(),items.get(i).getSubCategory().getCategory().getName());


            ee.add(i,a);

        }







        File file = ResourceUtils.getFile("classpath:itemreport.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ee);
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


    public String exportReportnostock(String reportFormat) throws FileNotFoundException, JRException {
        String path = "E:\\reports\\New folder";
        List<ItemEnitiy> items = R.Noinstock();//load file and compile it

        ArrayList<exp> ee=new ArrayList<exp>();





        for(int i=0;i<items.size();i++){
            exp a= new exp(items.get(i).getName(),items.get(i).getBarcode(),items.get(i).getPrice(),items.get(i).getQuantity(),items.get(i).getSubCategory().getCategory().getName(),items.get(i).getSubCategory().getName());


            ee.add(i,a);

        }



        Logger log = LoggerFactory.getLogger(this.getClass());
        log.info("77777777777777777777777777777777777777");
        log.info(String.valueOf(ee.size()));

        File file = ResourceUtils.getFile("classpath:itemreport.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ee);
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
