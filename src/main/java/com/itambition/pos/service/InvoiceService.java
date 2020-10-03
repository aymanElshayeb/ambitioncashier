package com.itambition.pos.service;

import com.itambition.pos.entity.OrderEnitiy;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class InvoiceService {


    public void createPdfReport(final List<OrderEnitiy> orderEnitiys ,String invoice_template , int order_id, String logo_path,String lang , String filePath) throws JRException {
        final JasperReport invoice = load_invoice_template(invoice_template);

        ///////////////////////////////////////////////////////////////////////////
        // Fetching from the data source.
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(orderEnitiys);

        // Adding the additional parameters to the pdf.
        final Map<String, Object> parameters = fill_parameters(order_id ,logo_path ,lang);

        // Filling the report with the employee data and additional parameters information.
        final JasperPrint print = JasperFillManager.fillReport(invoice, parameters, source);

        String Invoice_Name = "invoice" + "_" + String.valueOf(order_id) + "_" + lang + ".pdf" ;
        JasperExportManager.exportReportToPdfFile(print, filePath + Invoice_Name);
    }

    private JasperReport load_invoice_template(String invoice_template)throws JRException
    {
        // Fetching the .jrxml file from the resources folder.
        InputStream stream = this.getClass().getResourceAsStream(invoice_template);

        JasperDesign jasperDesign = JRXmlLoader.load(stream);

        // Compile the Jasper report from .jrxml to .japser
        JasperReport invoice = JasperCompileManager.compileReport(jasperDesign);

        return invoice;
    }

    private Map<String, Object> fill_parameters(int order_id , String logo_path , String lang)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("order_id", order_id);
        parameters.put("logo",getClass().getResourceAsStream(logo_path));
        parameters.put("REPORT_LOCALE", new Locale(lang));

        return parameters;
    }
}
