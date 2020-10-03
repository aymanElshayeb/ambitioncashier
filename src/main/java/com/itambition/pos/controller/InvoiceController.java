package com.itambition.pos.controller;

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

    int order_id = 3;
    String lang = "fr";

    @GetMapping("/invoice")
    public void generate_report () {
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
