package vn.team06.qlhocvienisc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;

import vn.team06.qlhocvienisc.entity.PhongHoc;

public interface PhongHocRepository extends PagingAndSortingRepository<PhongHoc, String>{
	@Transactional
	@Procedure(name = "sp_delete_phonghoc")
	void sp_delete_phonghoc(String maphong);
}