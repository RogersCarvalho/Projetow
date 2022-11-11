package com.educaweb.projetow.Services;

import com.educaweb.projetow.Repositories.UserRepository;
import com.educaweb.projetow.Services.exceptions.DataBaseException;
import com.educaweb.projetow.Services.exceptions.ResourceNotFoundException;
import com.educaweb.projetow.model.entidade.User;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public User findById(Long id){
          Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }






    public List<User> findAll() {
        return userRepository.findAll();
    }


  public User Insert(User obj){
      return userRepository.save(obj);
  }


  public void  delete(Long id) {

        try {
            userRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }

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
