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

import vn.team06.qlhocvienisc.entity.KhoaHoc;
import vn.team06.qlhocvienisc.repository.KhoaHocRepository;

@Service
public class KhoaHocService {
	@Autowired
	KhoaHocRepository khoahocRepository;
	
	public List<KhoaHoc> getAll() {
        return (List<KhoaHoc>) khoahocRepository.findAll();
    }
     
    public KhoaHoc createKhoahoc(KhoaHoc khoahoc) {
        return khoahocRepository.save(khoahoc);
    }
     
    public KhoaHoc updateKhoahoc(String Id, KhoaHoc khoahoc)
    {
    	KhoaHoc updatedKH;
        Optional<KhoaHoc> searchEntity = khoahocRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	KhoaHoc kh = searchEntity.get();
        	kh.setTENKHOAHOC(khoahoc.getTENKHOAHOC());
        	kh.setNGAYBD(khoahoc.getNGAYBD());
        	kh.setNGAYKT(khoahoc.getNGAYKT());
        	kh.setCHUYENNGANH_ID(khoahoc.getCHUYENNGANH_ID());
            updatedKH = khoahocRepository.save(kh);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedKH;
       }
     
      public ResponseEntity<Object> deleteKhoahoc(String Id) 
      {
        Optional<KhoaHoc> khoahoc = khoahocRepository.findById(Id);
        if (khoahoc.isPresent()) {
        	KhoaHoc kh = khoahoc.get();
        	khoahocRepository.delete(kh);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<KhoaHoc> getAllKhoaHoc(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<KhoaHoc> pagedResult = khoahocRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<KhoaHoc>();
          }
      }
}
