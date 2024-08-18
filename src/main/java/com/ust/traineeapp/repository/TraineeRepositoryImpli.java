package com.ust.traineeapp.repository;

import com.ust.traineeapp.model.Trainee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TraineeRepositoryImpli implements TraineeRepository{

    private List<Trainee> traineeDB;

    @PostConstruct
    void init(){
        traineeDB = new ArrayList<>();
    }

    @Override
    public Trainee addTrainee(Trainee trainee) {
        traineeDB.add(trainee);
        return trainee;
    }

    @Override
    public Trainee updateTrainee(Trainee trainee) {
          Trainee oldTrainee = getTrainee(trainee.getId());
          if(oldTrainee != null){
              oldTrainee.setName(trainee.getName());
              oldTrainee.setLocation(trainee.getLocation());

          }
          return oldTrainee;
    }

    @Override
    public void deleteTrainee(int id) {

        traineeDB.removeIf(t -> t.getId() == id);
    }

    @Override
    public Trainee getTrainee(int id) {
        return traineeDB.stream().filter(t->t.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return traineeDB;
    }
}
