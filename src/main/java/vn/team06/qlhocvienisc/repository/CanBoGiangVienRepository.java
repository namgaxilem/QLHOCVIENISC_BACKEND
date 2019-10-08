package vn.team06.qlhocvienisc.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.team06.qlhocvienisc.entity.CanBoGiangVien;
import vn.team06.qlhocvienisc.entity.HocVien;

@Repository
public interface CanBoGiangVienRepository extends JpaRepository<CanBoGiangVien, String>{
	@Transactional
	@Procedure(name = "sp_delete_giangvien")
	void sp_delete_giangvien(String magv);
	
	@Query(value = "select gv from CanBoGiangVien gv where gv.MACBGV=:MACBGV and gv.PASSWORD=:PASSWORD")
    Page<CanBoGiangVien> timgvTheoUsernameVaPassword(
    		@Param("MACBGV") String macbgv,
    		@Param("PASSWORD") String password,
    		Pageable pageable);
}