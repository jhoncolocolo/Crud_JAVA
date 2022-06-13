package com.api.usuarios.service;

import com.api.usuarios.entity.Usuario;
import com.api.usuarios.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepo usuarioRepo;
    
    public Usuario insert(Usuario usr){
        return usuarioRepo.save(usr);
    }
    
    public Usuario udpate(Integer id,Usuario usr){
        Usuario updatedUser = usuarioRepo.findById(id).get();
        updatedUser.setNames (usr.getNames());
        updatedUser.setSurnames(usr.getSurnames());
        updatedUser.setIdentification_id(usr.getIdentification_id());
        updatedUser.setBirth(usr.getBirth());
        return usuarioRepo.save(updatedUser);
    }
    
    public List<Usuario> all(){
        return usuarioRepo.findAll();
    }

    public Usuario getById(Integer id){
        return usuarioRepo.findById(id).get();
    }
    
    public void delete(Integer id){
        usuarioRepo.deleteById(id);
    }
}
