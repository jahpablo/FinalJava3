package com.jahpablo.controller.finaljava3;

import com.jahpablo.model.finaljava3.DAOArtista;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ControladorArtista {
    
    @RequestMapping(value = "/artista", method = RequestMethod.GET, headers = {"Accept=application/json"})
        public @ResponseBody String artista()throws Exception{
             DAOArtista ar = new DAOArtista();
             
            return ar.obtenerTodos();
        }
        @RequestMapping(value = "/artistadel/{id}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
        public @ResponseBody String artistaBorrar(@PathVariable Integer id)throws Exception{
             DAOArtista ar = new DAOArtista();
             ar.borrarArtista(id);
            return "Borrado con exito";
        }
}
