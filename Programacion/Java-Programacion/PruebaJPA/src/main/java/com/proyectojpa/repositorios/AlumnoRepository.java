package com.proyectojpa.repositorios;

import com.proyectojpa.config.HibernateConfig;
import com.proyectojpa.modelos.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

public class AlumnoRepository {

    public void save(Alumno alumno) {
        EntityManager em = HibernateConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(alumno);
            tx.commit();
        }catch(Exception e){
            if(tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            em.close();
        }
    }

    public List<Alumno> getAll() {
        EntityManager em = HibernateConfig.getEntityManagerFactory().createEntityManager();
        try{
            return em.createQuery("from Alumno", Alumno.class).getResultList();
        }finally {
            em.close();
        }
    }
}


