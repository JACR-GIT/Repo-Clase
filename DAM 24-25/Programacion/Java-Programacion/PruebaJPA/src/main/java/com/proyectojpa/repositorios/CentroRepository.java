package com.proyectojpa.repositorios;

import com.proyectojpa.config.HibernateConfig;
import com.proyectojpa.modelos.Centro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

public class CentroRepository {

    public void save(Centro centro) {
        EntityManager em = HibernateConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(centro);
            tx.commit();
        }catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            em.close();
        }
    }

    public List<Centro> getAll() {
        EntityManager em = HibernateConfig.getEntityManagerFactory().createEntityManager();
        List<Centro> salida = em.createQuery("from Centro", Centro.class).getResultList();
        em.close();
        return salida;
    }

    public Centro getByName(String name) {
        EntityManager em = HibernateConfig.getEntityManagerFactory().createEntityManager();
        //TypedQuery<Centro> query = em.createQuery("Select c FROM Centro c where nombre = :nombre", Centro.class);
        TypedQuery<Centro> query = em.createQuery("from Centro where nombre = :vNombre", Centro.class);
        query.setParameter("vNombre", name);
        //return query.getSingleResult();
        Centro salida = query.getResultList().stream().findFirst().orElse(null);
        em.close();
        return salida;
    }

    public Centro getById(Long id) {
        EntityManager em = HibernateConfig.getEntityManagerFactory().createEntityManager();
        Centro salida = em.find(Centro.class, id);
        em.close();
        return salida;
    }
}

