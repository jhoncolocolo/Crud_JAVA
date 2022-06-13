package com.api.usuarios.controller;

import com.api.usuarios.entity.Usuario;
import com.api.usuarios.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usrService;

    @GetMapping(value = "/")
    public RedirectView getPage(){
        return new RedirectView("usuarios");
    }

    @GetMapping(value="/usuarios")
    public List<Usuario> all(){
        return usrService.all();
    }

    @GetMapping(value="/usuarios/{id}")
    public Usuario getById(@PathVariable Integer id){
        return usrService.getById(id);
    }
    
    @PostMapping(value="/usuarios")
    public Usuario save(@RequestBody Usuario usr){
        return usrService.insert(usr);
    }
    
    @PutMapping(value = "/usuarios/{id}")
    public Usuario update(@PathVariable Integer id, @RequestBody Usuario usr){
        return usrService.udpate(id,usr);
    }
    
    @DeleteMapping(value = "/usuarios/{id}")
    public String delete(@PathVariable Integer id){
        usrService.delete(id);
        return "Usuario con Código: "+id+" fue borrado satisfactoriamente";
    }
}