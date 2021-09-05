package by.kalesnikau.petmilitaryunit.service;

import by.kalesnikau.petmilitaryunit.model.DonutEntity;
import by.kalesnikau.petmilitaryunit.repository.DonutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonutService {

    @Autowired
    DonutRepository donutRepository;

    public DonutEntity getById(long id) { return donutRepository.getById(id);}

    public DonutEntity getByName(String name) { return donutRepository.findByName(name);}

    public List<DonutEntity> getAll() {return donutRepository.findAll();}

    public void update(long id,DonutEntity donut) {
        donut.setId(id);
        donutRepository.save(donut);
    }

    public void deleteById(long id) {
        donutRepository.deleteById(id);
    }

    public void add(DonutEntity donut) {donutRepository.save(donut);}
}
