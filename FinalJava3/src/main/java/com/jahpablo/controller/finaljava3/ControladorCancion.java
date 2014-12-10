package com.jahpablo.controller.finaljava3;

import com.jahpablo.model.finaljava3.DAOArtista;
import com.jahpablo.model.finaljava3.DAOCancion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ControladorCancion {
     @RequestMapping(value = "/cancion", method = RequestMethod.GET, headers = {"Accept=application/json"})
        public @ResponseBody String cancion()throws Exception{
             DAOCancion ca = new DAOCancion();
             
            return ca.obtenerTodos();
        }
        @RequestMapping(value = "/canciondel/{id}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
        public @ResponseBody String cancionBorrar(@PathVariable Integer id)throws Exception{
             DAOCancion ca = new DAOCancion();
             ca.borrarCancion(id);
            return "Borrado con exito";
        }
}
