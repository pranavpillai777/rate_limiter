package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class service {

    @Autowired
    Model model;
    @Autowired
    repository repo;

    User user;

    public boolean isallowed() {
        long currentTime = System.currentTimeMillis();

        if (model.getLastRefillTimeStamp() == 0) {
            model.setLastRefillTimeStamp(currentTime);
            model.setCurrentToken(model.getCapacity());
        } else {
            long elapsedTime = currentTime - model.getLastRefillTimeStamp();
            int tokensToAdd = (int) (elapsedTime / 10000);

            if (tokensToAdd > 0) {
                int newTokens = Math.min(model.getCapacity(), model.getCurrentToken() + tokensToAdd);
                model.setCurrentToken(newTokens);
                model.setLastRefillTimeStamp(currentTime);
            }
        }

        if (model.getCurrentToken() > 0) {
            model.setCurrentToken(model.getCurrentToken() - 1);
            return true;
        }

        return false;
    }

    public void createuser(User user){
        repo.save(user);
    }

    public boolean updateuser(String name, String age,int id, int idpath){
         User user=repo.findById(idpath).orElseThrow(()-> new RuntimeException("user not found!"));
             user.setId(idpath);
             user.setName(name);
             user.setAge(age);
             repo.save(user);
             return true;
        }

    public User readuser(int id){
        User user=repo.findById(id).orElseThrow(()-> new RuntimeException("user not found!"));
            if (user.getId()==id){
                return user;
            }
        return null;
    }

    public boolean deleteuser(int id) {
        User user=repo.findById(id).orElseThrow(()->new RuntimeException("USER NOT FOUND!"));
        repo.deleteById(user.getId());
        return true;
    }
}