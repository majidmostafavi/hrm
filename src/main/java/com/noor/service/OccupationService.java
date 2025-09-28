package com.noor.service;

import com.noor.dao.OccupationRepository;
import com.noor.dto.OccupationDTO;
import com.noor.entity.Occupation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OccupationService {
    @Inject
     OccupationRepository occupationRepository;

    public List<Occupation> listAll() {
       return occupationRepository.listAll();

    }

    public Optional<Occupation> findByIdOptional(Long id) {
        return occupationRepository.findByIdOptional(id);

    }

    @Transactional
    public Occupation create(Occupation occupation) {
        occupationRepository.persist(occupation);
        return occupation;

    }

    @Transactional
    public boolean deleteById(Long id) {
        return occupationRepository.deleteById(id);

    }

    @Transactional
    public boolean update(Long id, OccupationDTO occupationDTO) {
        Optional occupationOptional =occupationRepository.findByIdOptional(id);
        if(occupationOptional.isPresent()) {
            Occupation occupation = (Occupation) occupationOptional.get();
            occupation.setName(occupationDTO.name());
            occupation.setCode(occupationDTO.code());
            occupationRepository.getEntityManager().merge(occupation);
            return true;
        }else {
            return false;
        }
    }
}
