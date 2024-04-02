package com.ec.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ec.entity.Merchandise;
import com.ec.repository.MerchandiseRepository;

@Service
public class MerchandiseService {
    private final MerchandiseRepository merchandiseRepository;

    public MerchandiseService(MerchandiseRepository repository) {
        this.merchandiseRepository = repository;
    }

    public List<Merchandise> getMerchandisereList(){
        return merchandiseRepository.findAll();
    }
}
