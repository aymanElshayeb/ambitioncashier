//package com.itambition.pos.controller.reports;
//
//import com.itambition.pos.entity.OrderEnitiy;
//import com.itambition.pos.repository.OrderRepo;
//import com.itambition.pos.service.RepotOrderService;
//import net.sf.jasperreports.engine.JRException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.FileNotFoundException;
//import java.sql.Timestamp;
//import java.util.List;
//
//@RestController
//
//public class OrderReportController {
//    @Autowired
//    private OrderRepo reporder;
//
//    @Autowired
//    RepotOrderService repotorderservice;
//
//    @GetMapping("/allorders")
//    public List<OrderEnitiy> allorder(){
//        return reporder.findAll();
//
//    }
//    @GetMapping("/dayorders/{one}/{tow}/{format}")
//    public String exportreportforday(@PathVariable Timestamp one, @PathVariable Timestamp tow, @PathVariable String format) throws FileNotFoundException, JRException {
//
//        return repotorderservice.exportreport(format,  one,tow);
//    }
//}
