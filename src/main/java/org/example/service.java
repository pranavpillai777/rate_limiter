package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class service {

    @Autowired
    Model model;

    User user;
    ArrayList<User> database=new ArrayList<>();

    public boolean isallowed() {
        long currentTime = System.currentTimeMillis();

        if (model.getLastRefillTimeStamp() == 0) {
            model.setLastRefillTimeStamp(currentTime);
            model.setCurrentToken(model.getCapacity());
        } else {
            long elapsedTime = currentTime - model.getLastRefillTimeStamp();
            int tokensToAdd = (int) (elapsedTime / 1000);

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
        database.add(new User(user.getName(),user.getAge(),user.getId()));
    }

    public boolean updateuser(String name, String age,int id, int idpath){
        for (User user:database){
            if (user.getId()==idpath){
                user.setAge(age);
                user.setId(id);
                user.setName(name);
                return true;
            }
        }
        return false;
    }

    public User readuser(int id){
        for (User user:database){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public boolean deleteuser(int id) {
        database.removeIf(user -> user.getId() == id);
        return true;
    }
}