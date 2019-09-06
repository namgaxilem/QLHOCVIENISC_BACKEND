package vn.team06.qlhocvienisc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import vn.team06.qlhocvienisc.entity.TinhNang;
@Repository
public interface TinhNangRepository extends PagingAndSortingRepository<TinhNang, Integer>{
	
}