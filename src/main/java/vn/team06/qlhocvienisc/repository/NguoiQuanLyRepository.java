package vn.team06.qlhocvienisc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import vn.team06.qlhocvienisc.entity.NguoiQuanLy;

public interface NguoiQuanLyRepository extends JpaRepository<NguoiQuanLy, String>{
	@Query(value = "select nql from NguoiQuanLy nql where nql.MANQL=:MANQL and nql.PASSWORD=:PASSWORD")
    Page<NguoiQuanLy> timnqlTheoUsernameVaPassword(
    		@Param("MANQL") String manql,
    		@Param("PASSWORD") String password,
    		Pageable pageable);
}