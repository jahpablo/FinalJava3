package com.jahpablo.controller.finaljava3;

import com.jahpablo.model.finaljava3.DAOAlbum;
import com.jahpablo.model.finaljava3.DAOArtista;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ControladorAlbum {
    
    @RequestMapping(value = "/album", method = RequestMethod.GET, headers = {"Accept=application/json"})
        public @ResponseBody String album()throws Exception{
             DAOAlbum al = new DAOAlbum();
             return al.obtenerTodos();
        }
    @RequestMapping(value = "/albumdel/{id}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
        public @ResponseBody String albumBorrar(@PathVariable Integer id)throws Exception{
             DAOAlbum al = new DAOAlbum();
             al.borrarAlbum(id);
            return "Borrado con exito";
        }
}
