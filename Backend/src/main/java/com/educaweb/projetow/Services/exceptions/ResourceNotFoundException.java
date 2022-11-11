package com.educaweb.projetow.Services.exceptions;



public class ResourceNotFoundException extends  RuntimeException{

      public ResourceNotFoundException(Object id){

          super("Não encontrado o id:"+ id);
      }
}
