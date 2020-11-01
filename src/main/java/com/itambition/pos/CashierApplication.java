package com.itambition.pos;

import com.itambition.pos.entity.ItemEnitiy;
import com.itambition.pos.repository.ItemRepo;
import com.itambition.pos.service.ReportItemService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
@RestController
public class CashierApplication {
    @Autowired
    private ItemRepo repository;
    @Autowired
    private ReportItemService service;

    @GetMapping("/getEmployees")
    public List<ItemEnitiy> getEmployees() {

        return repository.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReport(format);
    }

    public static void main(String[] args) {
        SpringApplication.run(CashierApplication.class, args);
    }
}
