package com.armada.armadacider.controller;

import com.armada.armadacider.model.Detail;
import com.armada.armadacider.model.Product;
import com.armada.armadacider.repository.DetailRepository;
import com.armada.armadacider.repository.ProductRepository;
import com.armada.armadacider.service.DetailService;
import com.armada.armadacider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/details/")

public class DetailRestController {
    @Autowired
    DetailRepository detailRepository;

    @Autowired
    DetailService detailService;

    //CRUD: read
    @GetMapping("/details")
    public Iterable<Detail> getAllDetails (){
        return detailRepository.findAll();

    }
    //CRUD: delete
    @DeleteMapping("/delete")
    public String deleteDetail(@RequestParam String id) {

        //System.out.println("id:" + id);
        Optional<Detail> detailFound = detailRepository.findById(id);
        long countBefore = detailRepository.count();
        //System.out.println("detailFound:" + detailFound);

        if (detailFound.isPresent()){
            detailRepository.deleteById(id);
            long countAfter = detailRepository.count();
            String response = "detail deleted: " + id + " count: " + countBefore + "/" + countAfter;
            return response;
        } else return "id: " + id +  " not found " + " count: " + countBefore;

    }
    //CRUD: create
    @PostMapping(path="create", consumes = "application/JSON")
    public Detail createDetail(@RequestBody Detail detail){
        //
        Detail detailCreated = detailRepository.save(detail);
        return detailCreated;
    }
    // CRUD: update
    @PutMapping("/update")
    public String updateDetail(@RequestParam String id, @RequestBody Detail newDetailData) {
        Optional<Detail> detailFound = detailRepository.findById(id);

        if (detailFound.isPresent()) {
            Detail detailToUpdate = detailFound.get();
            detailToUpdate.setQuantity(newDetailData.getQuantity());
            detailToUpdate.setPrice(newDetailData.getPrice());
            detailToUpdate.setDiscount(newDetailData.getDiscount());
            detailToUpdate.setTaxes(newDetailData.getTaxes());
            detailToUpdate.setTotal(newDetailData.getTotal());
            detailToUpdate.setPaid(newDetailData.isPaid());
            detailRepository.save(detailToUpdate);
            return "Detail updated: " + id;
        } else {
            return "ID: " + id + " not found.";
        }
    }
    @PostMapping("/populate")
    public String populateDB(){

        detailService.populate();

        return "ok";
    }
}
