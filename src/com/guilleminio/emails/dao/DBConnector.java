/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Guille
 */
public class DBConnector {
    
    Session dbSession;
    
    private static DBConnector instance;
 
    public  static DBConnector getInstance() {
 
        if (instance==null) {
            instance = new DBConnector();
        }
        
        return instance;
    }
 
    private DBConnector(){
        try{/*
            SessionFactory factory = HibernateUtil.getSessionFactory();
            this.dbSession = factory.openSession();*/
            flushSession();
        }catch( ExceptionInInitializerError e){
            
        }
    }
    
    private void flushSession(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        this.dbSession = factory.openSession();
    }
    
    public boolean connectionOk(){
        if (this.dbSession != null)
            return true;
        return false;
    }
    
    public void finalize(){
        try{
            this.dbSession.close();
        }catch( Exception e){
            System.out.println(e.toString());
        }
    }
 
    public synchronized Query executeQuery(String aQuery){
        try{
            flushSession();
            Query query = this.dbSession.createQuery(aQuery);
            
            return query;
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
    
    public synchronized int getLastId( String aQuery ){
        try{
            return   ((Integer) this.dbSession.createSQLQuery(aQuery).uniqueResult());
        }catch( Exception e ){
            return 0;
        }
    }
    
    public synchronized void executeInsert(Object aObject){
        try{
            this.dbSession.beginTransaction();
                this.dbSession.save(aObject);
            this.dbSession.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public synchronized void executeUpdate(Object aObject){
        try{
            this.dbSession.beginTransaction();
                this.dbSession.saveOrUpdate(aObject);
            this.dbSession.getTransaction().commit();
        }catch( Exception e){
            System.out.println(e.toString());
        }
    }
    
    public synchronized void executeDelete(Object aObject){
        try{
            this.dbSession.beginTransaction();
                this.dbSession.delete(aObject);
            this.dbSession.getTransaction().commit();
        }catch( Exception e){
            System.out.println(e.toString());
        }
    }
    
    public Session getSession(){
        return this.dbSession;
    }
    
    
}
