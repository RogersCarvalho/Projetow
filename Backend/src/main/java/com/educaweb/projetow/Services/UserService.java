package com.educaweb.projetow.Services;

import com.educaweb.projetow.Repositories.UserRepository;
import com.educaweb.projetow.model.entidade.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {

      return userRepository.findAll();
  }

  public User findById(Long id){
      Optional<User> obj = userRepository.findById(id);
      return obj.get();
  }

  public User Insert(User obj){

      return userRepository.save(obj);
  }


  public void  delete(Long id) {
      userRepository.deleteById(id);
  }


    public User Update(Long id, User obj){

        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {

      entity.setName(obj.getName());
      entity.setEmail(obj.getEmail());
      entity.setPhone(obj.getPhone());

    }


}
