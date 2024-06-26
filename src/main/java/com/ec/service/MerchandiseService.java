package com.ec.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ec.entity.Merchandise;
import com.ec.repository.MerchandiseRepository;

import jakarta.transaction.Transactional;

@Service
public class MerchandiseService {
    private final MerchandiseRepository merchandiseRepository;

    public MerchandiseService(MerchandiseRepository repository) {
        this.merchandiseRepository = repository;
    }

    public List<Merchandise> getMerchandisereList(){
        return merchandiseRepository.findAll();
    }

    public List<Merchandise> getCategoryList(String category){
        return merchandiseRepository.findByCategory(category);
    }

    public Merchandise getMerchandise(Integer id) {
        return merchandiseRepository.findById(id).get();
    }

    @Transactional
    public void saveMerchandise(Merchandise merchandise) {
        merchandiseRepository.save(merchandise);

    }
}
