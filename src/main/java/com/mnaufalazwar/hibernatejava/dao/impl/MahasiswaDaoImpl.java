package com.mnaufalazwar.hibernatejava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mnaufalazwar.hibernatejava.dao.MahasiswaDao;
import com.mnaufalazwar.hibernatejava.entity.Mahasiswa;

public class MahasiswaDaoImpl implements MahasiswaDao {
	
	private final Session session;
	
    public MahasiswaDaoImpl(Session session) {
        this.session = session;
    }

	@Override
	public boolean insert(Mahasiswa m) {
		
		try {

//			if(!session.isOpen()){
//				session = new
//			}

			session.beginTransaction();
			String nim = (String) session.save(m);
			session.getTransaction().commit();
			return nim != null;
		}
		catch (Exception e) {
            Logger.getLogger(MahasiswaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } 
		finally {
//            session.close();
        }
        return false;
		
	}

	@Override
	public boolean update(Mahasiswa m) {
		
		try {
			session.beginTransaction();
			session.update(m);
			session.getTransaction().commit();
			return true;
		}
		catch (Exception e) {
            Logger.getLogger(MahasiswaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } 
		finally {
            session.close();
        }
        return false;
		
	}

	@Override
	public boolean delete(Mahasiswa m) {
		
		try {
			session.beginTransaction();
			session.delete(m);
			session.getTransaction().commit();
			return true;
		}
		catch (Exception e) {
            Logger.getLogger(MahasiswaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } 
		finally {
            session.close();
        }
        return false;
		
	}

	@Override
	public Mahasiswa getMahasiswaByNim(String nim) {
		
		try {
			Query query = session.createQuery("FROM Mahasiswa m WHERE m.nim=:nim");
			query.setParameter("nim", nim);
            return (Mahasiswa) query.uniqueResult();
		}
		catch (Exception e) {
            Logger.getLogger(MahasiswaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } 
		finally {
            session.close();
        }
        return null;
		
	}

	@Override
	public List<Mahasiswa> getAllMahasiswa() {
		
		try {
            return session.createQuery("FROM Mahasiswa", Mahasiswa.class).list();
        } 
		catch (Exception e) {
            Logger.getLogger(MahasiswaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } 
		finally {
            session.close();
        }
        return null;
		
	}

}
