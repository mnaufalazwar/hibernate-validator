package com.mnaufalazwar.hibernatejava.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mnaufalazwar.hibernatejava.entity.Mahasiswa;
import com.mnaufalazwar.hibernatejava.service.MahasiswaService;
import com.mnaufalazwar.hibernatejava.service.impl.MahasiswaServiceImpl;
import com.mnaufalazwar.hibernatejava.util.HibernateUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

@RestController
@RequestMapping(value="/con")
public class Controller {
	
	private MahasiswaService mahasiswaService = new MahasiswaServiceImpl(HibernateUtil.getMahasiswaDao());

	@RequestMapping(value="/insert", method=RequestMethod.PUT)
	public String insertMahasiswa(@RequestBody Mahasiswa mahasiswa) {

		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		Set<ConstraintViolation<Mahasiswa>> validate = validator.validate(mahasiswa);

		Iterator<ConstraintViolation<Mahasiswa>> iterator = validate.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next().getMessage());
		}

		if(validate.size() == 0){
			if(mahasiswaService.insert(mahasiswa)) {
				return "insert success";
			}
			else {
				return "insert failsed";
			}
		}
		else{
			return "insert failsed";
		}

//		if(mahasiswaService.insert(mahasiswa)) {
//			return "insert success";
//		}
//		else {
//			return "insert failsed";
//		}
		
//		return "insert failsed";
		
	}
	
}
