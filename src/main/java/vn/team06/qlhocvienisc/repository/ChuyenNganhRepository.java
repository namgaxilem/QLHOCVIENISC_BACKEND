package vn.team06.qlhocvienisc.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import vn.team06.qlhocvienisc.entity.ChuyenNganh;

public interface ChuyenNganhRepository extends JpaRepository<ChuyenNganh, Integer>{
	@Query(value = "select cn from ChuyenNganh cn where cn.ID=:ID")
    Page<ChuyenNganh> findMajor(@Param("ID") int ID, Pageable pageable);
	
	@Transactional
	@Procedure(name = "sp_delete_ChuyenNganh")
	void sp_delete_chuyennganh(Integer macn);
}
