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

import vn.team06.qlhocvienisc.entity.TruongHoc;
import vn.team06.qlhocvienisc.repository.TruongHocRepository;

@Service
public class TruongHocService {
	@Autowired
	TruongHocRepository truonghocRepository;
	
	public List<TruongHoc> getAll() {
        return (List<TruongHoc>) truonghocRepository.findAll();
    }
     
    public TruongHoc createTruong(TruongHoc truonghoc) {
        return truonghocRepository.save(truonghoc);
    }
     
    public TruongHoc updateTruong(String Id, TruongHoc truonghoc)
    {
    	TruongHoc updatedTH;
        Optional<TruongHoc> searchEntity = truonghocRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	TruongHoc th = searchEntity.get();
            th.setMATRUONG(truonghoc.getMATRUONG());
            th.setTENTRUONG(truonghoc.getTENTRUONG());
            th.setDIACHI(truonghoc.getDIACHI());
            th.setSDT(truonghoc.getSDT());
            updatedTH = truonghocRepository.save(th);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedTH;
       }
     
      public ResponseEntity<Object> deleteTruong(String Id) 
      {
        Optional<TruongHoc> truonghoc = truonghocRepository.findById(Id);
        if (truonghoc.isPresent()) {
        	TruongHoc hv = truonghoc.get();
           truonghocRepository.delete(hv);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<TruongHoc> getAllTruongHoc(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<TruongHoc> pagedResult = truonghocRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<TruongHoc>();
          }
      }
}
