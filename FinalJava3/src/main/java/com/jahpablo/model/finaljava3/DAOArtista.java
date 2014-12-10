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

public class DAOArtista {
    public String obtenerTodos() throws Exception{
        SessionFactory factory = HibernateUtilidades.getSessionFactory();
        Session sesion = factory.openSession();
        Transaction tranza = sesion.beginTransaction();
        Criteria cri = sesion.createCriteria(Artista.class);
        
        ArrayList<Artista> artistas = (ArrayList<Artista>)cri.list();
        Map<String, ArrayList<Artista>> singletonMap = Collections.singletonMap("artistas", artistas);
        ObjectMapper mapper = new ObjectMapper();        
        tranza.commit();
        sesion.close();
        
        return mapper.writeValueAsString(singletonMap);
    }
    
     public String obtenerArtistaPorId(Integer id) throws Exception{
        SessionFactory factory= HibernateUtilidades.getSessionFactory();
        Session sesion=factory.openSession();
        Transaction tranza= sesion.beginTransaction();
  
        Criteria cri=sesion.createCriteria(Artista.class).add(Restrictions.idEq(id));
        Artista a=(Artista)cri.uniqueResult();
        ObjectMapper mapper=new ObjectMapper();
        tranza.commit();
        sesion.close();

        return mapper.writeValueAsString(a);
    }   
     
     public String borrarArtista(Integer id) throws Exception{
        SessionFactory factory= HibernateUtilidades.getSessionFactory();
        Session sesion=factory.openSession();
        Transaction tranza= sesion.beginTransaction();
  
        Criteria cri=sesion.createCriteria(Artista.class).add(Restrictions.idEq(id));
        Artista a=(Artista)cri.uniqueResult();
        
        sesion.delete(a);
        
        tranza.commit();
        sesion.close();
         
        return ("");
     }
}