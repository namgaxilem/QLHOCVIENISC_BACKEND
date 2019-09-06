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

import vn.team06.qlhocvienisc.entity.HocVien;
import vn.team06.qlhocvienisc.entity.PhongHoc;
import vn.team06.qlhocvienisc.repository.PhongHocRepository;


@Service
public class PhongHocService {
	
	@Autowired
	PhongHocRepository phonghocRepository;
       
        
    public List<PhongHoc> getAll2() {
        return (List<PhongHoc>) phonghocRepository.findAll();
    }
     
    public PhongHoc createPhongHoc(PhongHoc phonghoc) {
        return phonghocRepository.save(phonghoc);
    }
     
    public PhongHoc updatePhongHoc(String id, PhongHoc phonghoc)
    {
    	PhongHoc updatedPhongHoc;
        Optional<PhongHoc> searchEntity = phonghocRepository.findById(id);
        if (searchEntity.isPresent()) {
        	PhongHoc ph = searchEntity.get();
        	ph.setMAPHG(phonghoc.getMAPHG());
        	ph.setTENPHG(phonghoc.getTENPHG());
        	updatedPhongHoc = phonghocRepository.save(ph);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedPhongHoc;
       }
     
      public ResponseEntity<Object> deletePhongHoc(String id) 
      {
        Optional<PhongHoc> phonghoc = phonghocRepository.findById(id);
        if (phonghoc.isPresent()) {
           PhongHoc ph = phonghoc.get();
           phonghocRepository.delete(ph);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<PhongHoc> getAllPhongHoc(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<PhongHoc> pagedResult = phonghocRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<PhongHoc>();
          }
      }
}