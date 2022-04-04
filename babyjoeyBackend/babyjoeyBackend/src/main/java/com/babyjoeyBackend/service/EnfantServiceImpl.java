package com.babyjoeyBackend.service;
import com.babyjoeyBackend.entity.EnfantEntity;
import com.babyjoeyBackend.exeption.NotFoundExeption;
import com.babyjoeyBackend.repository.EnfantRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class EnfantServiceImpl implements EnfantService {
    private final EnfantRepository EnfantRepository;

    public EnfantServiceImpl(EnfantRepository EnfantRepository) {
        this.EnfantRepository = EnfantRepository;
    }

    public List<EnfantEntity> getAllEnfant() {
        List<EnfantEntity> enfants = EnfantRepository.findAll();
        return enfants;
    }
    @SneakyThrows
    public EnfantEntity getEnfantByID(long id_enf) {
        EnfantEntity enfant =  EnfantRepository.findById((int) id_enf)
                .orElseThrow(() -> new NotFoundExeption("user not found"+id_enf));

        return  enfant;
    }
    @Override
    public EnfantEntity addEnfant(EnfantEntity enfant) {
        enfant.setNom(enfant.getNom());
        // user.setPassword(encoder.encode(user.getPassword()));

        return EnfantRepository.save(enfant);
    }

    @Override
    public EnfantEntity updateEnfant(EnfantEntity updateuser, long id_enf) {
        EnfantEntity enfant = EnfantRepository.findById((int) id_enf)
                .orElseThrow(()-> new NotAcceptableStatusException("user not found"));
        enfant.setId_enf(updateuser.getId_enf());
        enfant.setNom(updateuser.getNom());
        enfant.setPrenon(updateuser.getPrenon());
        enfant.setAllergie(updateuser.isAllergie());
        enfant.setType(updateuser.getType());
        enfant.setData_naissance(updateuser.getData_naissance());
        enfant.setDescription(updateuser.getDescription());
        enfant.setNum_inscription(updateuser.getNum_inscription());
        enfant.setImage_enf(updateuser.getImage_enf());
        EnfantRepository.save(enfant);

        return enfant;
    }
    @Override
    public void deleteEnfant(long Id_enf) {

        EnfantRepository.deleteById((int) Id_enf);
    }
    @Override
    public Optional<EnfantEntity> getEnfantByIdResponse(long id_enf) {
        return EnfantRepository.findById((int) id_enf);
    }
}
