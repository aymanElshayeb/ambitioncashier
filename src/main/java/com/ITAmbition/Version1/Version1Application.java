package com.ITAmbition.Version1;

import com.ITAmbition.Version1.Entity.ItemEnitiy;
import com.ITAmbition.Version1.Repository.ItemRepo;
import com.ITAmbition.Version1.Service.reportitemservice;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
@RestController
public class Version1Application {
    @Autowired
    private ItemRepo repository;
    @Autowired
    private reportitemservice service;

    @GetMapping("/getEmployees")
    public List<ItemEnitiy> getEmployees() {

        return repository.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReport(format);
    }

    public static void main(String[] args) {
        SpringApplication.run(Version1Application.class, args);
    }
}
