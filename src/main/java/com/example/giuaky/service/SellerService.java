package com.example.giuaky.service;
import com.example.giuaky.models.Seller;
import com.example.giuaky.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SellerService {

        @Autowired
        private SellerRepository sellerRepository;


        public List<Seller> findAll() {
            return sellerRepository.findAll();
        }


        public Seller findById(Long id) {
            return sellerRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        }


        public Seller save(Seller user) {
            return sellerRepository.save(user);
        }


        public Seller update(Seller user) {
            return sellerRepository.save(user);
        }
        public void delete(Long id) {
            sellerRepository.deleteById(id);
        }



}
