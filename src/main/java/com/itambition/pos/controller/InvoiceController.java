package com.itambition.pos.controller;

import com.itambition.pos.entity.OrderEnitiy;
import com.itambition.pos.entity.OrderID;
import com.itambition.pos.service.InvoiceService;
import com.itambition.pos.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping(value = "/invoice")
@RestController
public class InvoiceController {
    @Autowired
    OrderService orderService;

    @Autowired
    InvoiceService invoiceService;

    final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${invoice.logo.path}")
    private String logo_path;

    @Value("${invoice.template.path}")
    private String invoice_template;

    @Value("${invoice.saved.path}")
    private String filePath;

    int order_id = 1;
    String lang = "fr";

    @GetMapping("/invoice")
    public void generate_report () {

        if (orderService.getOrder(order_id).size() == 0 )
        {
            orderService.addOrder(new OrderEnitiy(new OrderID(1,1),"Pizza-italian",100001,java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"),2,50,100));
            orderService.addOrder(new OrderEnitiy(new OrderID(1,2),"Pizza-spanish",100010,java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"),2,100,200));
        }
        log.info("Preparing the pdf report via jasper.");
        try {
            invoiceService.createPdfReport(orderService.getOrder(order_id),invoice_template,order_id,logo_path,lang,filePath);
            log.info("Invoice successfully saved at the given path.");
        } catch (final Exception e) {
            log.error("Some error has occurred while preparing the Invoice pdf.");
            e.printStackTrace();
        }
    }
}
