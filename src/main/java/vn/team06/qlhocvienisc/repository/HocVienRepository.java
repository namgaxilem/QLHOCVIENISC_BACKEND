package vn.team06.qlhocvienisc.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.team06.qlhocvienisc.entity.HocVien;;

@Repository
public interface HocVienRepository extends JpaRepository<HocVien, String>{
	@Query(value = "select hv from HocVien hv where hv.MAKHOAHOC=:MAKHOAHOC")
    Page<HocVien> findCourse(@Param("MAKHOAHOC") String makhoahoc, Pageable pageable);
}
