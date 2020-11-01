package com.itambition.pos.controller;

import com.itambition.pos.entity.CategoryEntity;
import com.itambition.pos.entity.ItemEnitiy;
import com.itambition.pos.entity.OrderEnitiy;
import com.itambition.pos.entity.OrderItemEntity;
import com.itambition.pos.entity.classes.ItemOrderCache;
import com.itambition.pos.repository.ItemRepo;
import com.itambition.pos.repository.OrderItemRepo;
import com.itambition.pos.repository.OrderRepo;
import com.itambition.pos.service.ItemService;
import com.itambition.pos.service.OrderItemService;
import com.itambition.pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.*;

@RestController
public class OrderRestController {
    Hashtable<Long,Integer> itemOrderCaches = new Hashtable<Long,Integer>();

    @CachePut(value="itemscache" ,key = "#barcode" )
    @RequestMapping("/AddOrderItem1")
    @ResponseBody
    public ItemOrderCache addToOrder(@RequestParam long barcode , @RequestParam int quantity)
    {
        System.out.println("add item to order list");
        if(itemOrderCaches.containsKey(barcode))
        {
            int newQuanitiy = itemOrderCaches.get(barcode) + quantity;
            itemOrderCaches.replace(barcode,itemOrderCaches.get(barcode),newQuanitiy);
            return new ItemOrderCache(barcode,newQuanitiy);
        }
        itemOrderCaches.put(barcode,quantity);
        return new ItemOrderCache(barcode,quantity);
    }

    @CachePut(value="itemscache" ,key = "#barcode" )
    @RequestMapping("/AddOrderItem2")
    @ResponseBody
    public ItemOrderCache addToOrder(@RequestParam long barcode)
    {
        System.out.println("add item to order list");
        if(itemOrderCaches.containsKey(barcode))
        {
            int newQuanitiy = itemOrderCaches.get(barcode) + 1;
            itemOrderCaches.replace(barcode,itemOrderCaches.get(barcode),newQuanitiy);
            return new ItemOrderCache(barcode,newQuanitiy);
        }
        itemOrderCaches.put(barcode,1);
        return new ItemOrderCache(barcode,1);
    }

    @CacheEvict(value="itemscache",key="#barcode")
    @RequestMapping("/deleteOrderItem")
    public String delete(@RequestParam long barcode) {
        System.out.println("Deleting item from order list");
        if(itemOrderCaches.get(barcode)>1)
        {
            itemOrderCaches.replace(barcode,itemOrderCaches.get(barcode),itemOrderCaches.get(barcode)-1);
            return "reduce quantity "+ barcode ;
        }
        else
        {
            itemOrderCaches.remove(barcode);
            return "Deleted "+ barcode ;
        }
    }

    @Autowired
    OrderItemRepo orderItemRepo;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ItemRepo itemRepo;



    @RequestMapping("/checkout")
    public String checkout() {
        List<OrderItemEntity> orderItemEntities = new ArrayList<>();
        OrderEnitiy orderEnitiy = new OrderEnitiy(new Timestamp(System.currentTimeMillis()));

        Set<Long> setofbarcodes = itemOrderCaches.keySet();
        Iterator<Long> iterator = setofbarcodes.iterator();
        long totalPrice = 0;

        while(iterator.hasNext()) {
            Long key = iterator.next();
            ItemEnitiy itemEnitiy= itemRepo.findByBarcode(key);
            orderItemEntities.add(new OrderItemEntity(
                    itemEnitiy.getName(),
                    itemEnitiy.getBarcode(),
                    itemOrderCaches.get(key),
                    itemEnitiy.getPrice(),
                    (long)(itemOrderCaches.get(key)*itemEnitiy.getPrice()),
                    orderEnitiy));
            totalPrice+=(long)(itemOrderCaches.get(key)*itemEnitiy.getPrice());
        }
        orderEnitiy.setTotal_price(totalPrice);

        orderRepo.save(orderEnitiy);
        orderItemRepo.saveAll(orderItemEntities);
        return "order insert to db successifuly";
    }

    @RequestMapping("/getAllItem")
    @ResponseBody
    public List<OrderItemEntity> getAll(){
        System.out.println("Getting all records OrderItems");
        return orderItemService.getAllitems();
    }

}
