package com.auth0.samples.kotlinspringboot.dao.util

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.io.Serializable;

/**
 * Created by SCI on 11/20/2017.
 */

@Repository
class HibernateUtil {


    @Autowired
    private val sessionFactory: SessionFactory? = null

    fun <T> create(entity: T): Serializable {
        return sessionFactory!!.currentSession.save(entity)
    }

    fun <T> update(entity: T): T {
        sessionFactory!!.currentSession.update(entity)
        return entity
    }

    fun <T> delete(entity: T) {
        sessionFactory!!.currentSession.delete(entity)
    }

    fun <T> delete(id: Serializable, entityClass: Class<T>) {
        val entity = fetchById(id, entityClass)
        delete(entity)
    }

    fun <T> fetchAll(entityClass: Class<T>): List<T> {
        return sessionFactory!!.currentSession.createQuery(" FROM " + entityClass.name).list() as List<T>
    }

    fun <T> fetchAll(query: String): List<T> {
        return sessionFactory!!.currentSession.createSQLQuery(query).list() as List<T>
    }

    fun <T> fetchById(id: Serializable, entityClass: Class<T>): T {
        return sessionFactory!!.currentSession.get(entityClass, id) as T
    }
}
