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

public class DAOAlbum {
    
    public String obtenerTodos() throws Exception{
        SessionFactory factory = HibernateUtilidades.getSessionFactory();
        Session sesion = factory.openSession();
        Transaction tranza = sesion.beginTransaction();
        Criteria cri = sesion.createCriteria(Album.class);
        
        ArrayList<Album> albumes = (ArrayList<Album>)cri.list();
        Map<String, ArrayList<Album>> singletonMap = Collections.singletonMap("albumes", albumes);
        ObjectMapper mapper = new ObjectMapper();        
        tranza.commit();
        sesion.close();
        
        return mapper.writeValueAsString(singletonMap);
    }
    
     public String obtenerArtistaPorId(Integer id) throws Exception{
        SessionFactory factory= HibernateUtilidades.getSessionFactory();
        Session sesion=    factory.openSession();
        Transaction tranza= sesion.beginTransaction();
  
        Criteria cri=sesion.createCriteria(Album.class).add(Restrictions.idEq(id));
        Album a=(Album)cri.uniqueResult();
        ObjectMapper mapper=new ObjectMapper();
        tranza.commit();
        sesion.close();

        return mapper.writeValueAsString(a);
    }
        public String borrarAlbum(Integer id) throws Exception{
        SessionFactory factory= HibernateUtilidades.getSessionFactory();
        Session sesion=    factory.openSession();
        Transaction tranza= sesion.beginTransaction();
  
        Criteria cri=sesion.createCriteria(Album.class).add(Restrictions.idEq(id));
        Album a=(Album)cri.uniqueResult();
        sesion.delete(a);
        tranza.commit();
        sesion.close();
        return ("");
        }
}
