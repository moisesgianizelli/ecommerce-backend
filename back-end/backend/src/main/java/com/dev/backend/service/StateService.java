package com.dev.backend.service;

import com.dev.backend.entity.State;
import com.dev.backend.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> searchAll(){
        return stateRepository.findAll();
    }

    public State insert(State state){
        state.setDateCreation(new Date());
        State stateNew = stateRepository.saveAndFlush(state);
        return stateNew;
    }

    public State modify(State state){
        state.setDateUpdate(new Date());
        return stateRepository.saveAndFlush(state);
    }

    public void delete(Long id){
        State state = stateRepository.findById(id).get();
        stateRepository.delete(state);

    }

}
