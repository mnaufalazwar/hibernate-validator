package com.mnaufalazwar.hibernatejava.service.impl;

import java.util.List;

import com.mnaufalazwar.hibernatejava.dao.MahasiswaDao;
import com.mnaufalazwar.hibernatejava.entity.Mahasiswa;
import com.mnaufalazwar.hibernatejava.service.MahasiswaService;

public class MahasiswaServiceImpl implements MahasiswaService {

	private final MahasiswaDao dao;
	
	public MahasiswaServiceImpl(MahasiswaDao mahasiswaDao) {
        this.dao = mahasiswaDao;
    }

	@Override
	public boolean insert(Mahasiswa m) {
		// TODO Auto-generated method stub
		return dao.insert(m);
	}

	@Override
	public boolean update(Mahasiswa m) {
		// TODO Auto-generated method stub
		return dao.update(m);
	}

	@Override
	public boolean delete(Mahasiswa m) {
		// TODO Auto-generated method stub
		return dao.delete(m);
	}

	@Override
	public Mahasiswa getMahasiswaByNim(String nim) {
		// TODO Auto-generated method stub
		return dao.getMahasiswaByNim(nim);
	}

	@Override
	public List<Mahasiswa> getAllMahasiswa() {
		// TODO Auto-generated method stub
		return dao.getAllMahasiswa();
	}
	
	

}
