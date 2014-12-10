package com.jahpablo.model.finaljava3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DAOCancion {
    public String obtenerTodos() throws Exception{
        SessionFactory factory = HibernateUtilidades.getSessionFactory();
        Session sesion = factory.openSession();
        Transaction tranza = sesion.beginTransaction();
        Criteria cri = sesion.createCriteria(Cancion.class);
        
        ArrayList<Cancion> canciones = (ArrayList<Cancion>)cri.list();
        Map<String, ArrayList<Cancion>> singletonMap = Collections.singletonMap("canciones", canciones);
        ObjectMapper mapper = new ObjectMapper();        
        tranza.commit();
        sesion.close();
        
        return mapper.writeValueAsString(singletonMap);
    }
    
     public String obtenerCancionPorId(Integer id) throws Exception{
        SessionFactory factory= HibernateUtilidades.getSessionFactory();
        Session sesion=factory.openSession();
        Transaction tranza= sesion.beginTransaction();
  
        Criteria cri=sesion.createCriteria(Cancion.class).add(Restrictions.idEq(id));
        Cancion c=(Cancion)cri.uniqueResult();
        ObjectMapper mapper=new ObjectMapper();
        tranza.commit();
        sesion.close();

        return mapper.writeValueAsString(c);
    }   
     
     public String borrarCancion(Integer id) throws Exception{
        SessionFactory factory= HibernateUtilidades.getSessionFactory();
        Session sesion=factory.openSession();
        Transaction tranza= sesion.beginTransaction();
  
        Criteria cri=sesion.createCriteria(Cancion.class).add(Restrictions.idEq(id));
        Cancion c=(Cancion)cri.uniqueResult();
        
        sesion.delete(c);
        
        tranza.commit();
        sesion.close();
         
        return ("");
     }
}
