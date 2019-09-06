package vn.team06.qlhocvienisc.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import vn.team06.qlhocvienisc.entity.DaoTao;

public interface DaoTaoRepository extends PagingAndSortingRepository<DaoTao, Integer>{
	@Modifying
	@Transactional
	@Query("delete from DaoTao b where b.MAMH_ID=:MAMH_ID and b.CHUYENNGANH_ID=:CHUYENNGANH_ID")
	int deleteDaoTao(@Param("MAMH_ID") String MAMH_ID, @Param("CHUYENNGANH_ID") Integer CHUYENNGANH_ID);
	
	@Modifying
	@Transactional
	@Query("UPDATE DaoTao b SET b.MAMH_ID=:MAMH_ID, b.CHUYENNGANH_ID=:CHUYENNGANH_ID where b.MAMH_ID=:MAMH_ID and b.CHUYENNGANH_ID=:CHUYENNGANH_ID")
	int updateDaoTao(@Param("MAMH_ID") String MAMH_ID, @Param("CHUYENNGANH_ID") Integer CHUYENNGANH_ID);
}
