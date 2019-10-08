package vn.team06.qlhocvienisc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;

import vn.team06.qlhocvienisc.entity.TruongHoc;

public interface TruongHocRepository extends PagingAndSortingRepository<TruongHoc, String>{
	@Transactional
	@Procedure(name = "sp_delete_truonghoc")
	void sp_delete_truonghoc(String matruong);
}
