package com.example.giuaky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.giuaky.models.Seller;
import com.example.giuaky.service.SellerService;

import java.util.List;

@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    // Khởi tạo danh sách Seller
    public SellerController() {}

    // Trả về danh sách Seller
    @GetMapping("/seller")
    @ResponseBody
    public List<Seller> getSellerList() {
        return sellerService.findAll();
    }

    // Trả về một Seller cụ thể theo ID
    @GetMapping("/seller/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable("id") long id) {
        Seller seller = sellerService.findById(id);
        if (seller != null) {
            return ResponseEntity.ok(seller);
        }
        return ResponseEntity.status(404).body(null);  // Trả về lỗi 404 nếu không tìm thấy
    }

    // Xóa Seller theo ID
    @DeleteMapping("/seller/{id}")
    @ResponseBody
    public List<Seller> removeSellerById(@PathVariable("id") Long id) {
        sellerService.delete(id);
        return sellerService.findAll();
    }

    // Tạo mới một Seller
    @PostMapping("/seller")
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) {
        sellerService.save(seller);
        return ResponseEntity.status(201).body(seller);
    }

    // Cập nhật Seller theo ID
    @PutMapping("/seller/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable("id") Long id, @RequestBody Seller updateSeller) {
        Seller seller = sellerService.findById(id);
        if (seller != null) {
            seller.setFirstName(updateSeller.getFirstName());
            seller.setLastName(updateSeller.getLastName());
            seller.setMobileNo(updateSeller.getMobileNo());
            seller.setPassword(updateSeller.getPassword());
            sellerService.save(seller);
            return ResponseEntity.ok(seller);
        }
        return ResponseEntity.status(404).body(null);
    }
}
