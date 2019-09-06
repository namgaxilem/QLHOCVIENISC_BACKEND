package vn.team06.qlhocvienisc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vn.team06.qlhocvienisc.entity.ChuyenNganh;
import vn.team06.qlhocvienisc.repository.ChuyenNganhRepository;

@Service
public class ChuyenNganhService {
	@Autowired
	ChuyenNganhRepository chuyennganhRepository;
	
	public List<ChuyenNganh> getAll() {
        return (List<ChuyenNganh>) chuyennganhRepository.findAll();
    }
     
    public ChuyenNganh createChuyennganh(ChuyenNganh chuyennganh) {
        return chuyennganhRepository.save(chuyennganh);
    }
     
    public ChuyenNganh updateChuyennganh(int Id, ChuyenNganh chuyennganh)
    {
    	ChuyenNganh updatedCN;
        Optional<ChuyenNganh> searchEntity = chuyennganhRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	ChuyenNganh cn = searchEntity.get();
        	cn.setTENCN(chuyennganh.getTENCN());
            updatedCN = chuyennganhRepository.save(cn);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedCN;
       }
     
      public ResponseEntity<Object> deleteChuyennganh(int Id) 
      {
        Optional<ChuyenNganh> chuyennganh = chuyennganhRepository.findById(Id);
        if (chuyennganh.isPresent()) {
        	ChuyenNganh cn = chuyennganh.get();
        	chuyennganhRepository.delete(cn);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<ChuyenNganh> getAllChuyenNganh(Integer pageNo, Integer pageSize, int id, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<ChuyenNganh> pagedResult = chuyennganhRepository.findMajor(id,paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<ChuyenNganh>();
          }
      }
      
      public List<ChuyenNganh> getAllChuyenNganh2(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<ChuyenNganh> pagedResult = chuyennganhRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<ChuyenNganh>();
          }
      }
}
