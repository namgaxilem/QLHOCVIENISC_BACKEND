package vn.team06.qlhocvienisc.repository;

import javax.transaction.Transactional;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import vn.team06.qlhocvienisc.entity.CanBoGiangVien;

@Repository
public interface CanBoGiangVienRepository extends PagingAndSortingRepository<CanBoGiangVien, String>{
	@Transactional
	@Procedure(name = "sp_delete_giangvien")
	void sp_delete_giangvien(String magv);
}