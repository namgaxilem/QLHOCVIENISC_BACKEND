package vn.team06.qlhocvienisc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.team06.qlhocvienisc.entity.DiemMonHoc;

@Repository
public interface DiemMonHocRepository extends CrudRepository<DiemMonHoc, Integer>{
	
}