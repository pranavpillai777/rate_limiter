package org.example;


import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class service {
   User user;
   ArrayList<User> database=new ArrayList<>();
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
