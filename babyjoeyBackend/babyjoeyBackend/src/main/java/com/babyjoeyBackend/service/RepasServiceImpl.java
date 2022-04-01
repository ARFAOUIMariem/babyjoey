package com.babyjoeyBackend.service;

import com.babyjoeyBackend.entity.RepasEntity;
import com.babyjoeyBackend.exeption.NotFoundExeption;
import com.babyjoeyBackend.repository.RepasRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RepasServiceImpl implements RepasService {
    private final RepasRepository RepasRepository;

    public RepasServiceImpl(RepasRepository RepasRepository) {
        this.RepasRepository = RepasRepository;
    }

    public List<RepasEntity> getAllRepas() {
        List<RepasEntity> repass = RepasRepository.findAll();
        return repass;
    }

    @Override
    public RepasEntity getRepasByID(long id_repas) {
        return null;
    }

    @SneakyThrows
    public RepasEntity getUserByID(long id_repas) {
         RepasEntity repas =  RepasRepository.findById((int) id_repas)
                .orElseThrow(() -> new NotFoundExeption("user not found"+id_repas));

        return  repas;
    }
    @Override
    public RepasEntity addRepas(RepasEntity repas) {
        repas.setNom(repas.getNom());
        // user.setPassword(encoder.encode(user.getPassword()));

        return RepasRepository.save(repas);
    }

    @Override
    public RepasEntity updateRepas(RepasEntity updaterepas, long id_repas) {
        RepasEntity repas = RepasRepository.findById((int) id_repas)
                .orElseThrow(()-> new NotAcceptableStatusException("user not found"));
        repas.setId_repas(updaterepas.getId_repas());
        repas.setNom(updaterepas.getNom());
        repas.setDescription(updaterepas.getDescription());
        repas.setImage(updaterepas.getImage());

        RepasRepository.save(repas);

        return repas;
    }
    @Override
    public void deleteRepas(long Id_repas) {

        RepasRepository.deleteById((int) Id_repas);
    }

    @Override
    public Optional<RepasEntity> getRepasByIdResponse(long id_repas) {
        return RepasRepository.findById((int) id_repas);
    }


}
