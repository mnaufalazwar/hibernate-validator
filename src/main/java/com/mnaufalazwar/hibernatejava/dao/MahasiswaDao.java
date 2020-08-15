package com.mnaufalazwar.hibernatejava.dao;

import java.util.List;

import com.mnaufalazwar.hibernatejava.entity.Mahasiswa;

public interface MahasiswaDao {

	public boolean insert(Mahasiswa m);

    public boolean update(Mahasiswa m);

    public boolean delete(Mahasiswa m);

    public Mahasiswa getMahasiswaByNim(String nim);

    public List<Mahasiswa> getAllMahasiswa();
    
}
