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

import vn.team06.qlhocvienisc.entity.DoanhNghiep;
import vn.team06.qlhocvienisc.repository.DoanhNghiepRepository;


@Service
public class DoanhNghiepService {
	
	@Autowired
	DoanhNghiepRepository doanhnghiepRepository;
	
	public List<DoanhNghiep> getAll() {
        return (List<DoanhNghiep>) doanhnghiepRepository.findAll();
    }
     
    public DoanhNghiep createDoanhNghiep(DoanhNghiep doanhnghiep) {
        return doanhnghiepRepository.save(doanhnghiep);
    }
     
    public DoanhNghiep updateDoanhNghiep(int Id, DoanhNghiep doanhnghiep)
    {
    	DoanhNghiep updatedDoanhNghiep;
        Optional<DoanhNghiep> searchEntity = doanhnghiepRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	DoanhNghiep dn = searchEntity.get();
        	dn.setTENDOANHNGHIEP(doanhnghiep.getTENDOANHNGHIEP());
        	dn.setDIACHI(doanhnghiep.getDIACHI());
        	dn.setSDT(doanhnghiep.getSDT());
        	updatedDoanhNghiep = doanhnghiepRepository.save(dn);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedDoanhNghiep;
       }
     
      public ResponseEntity<Object> deleteDoanhNghiep(int Id) 
      {
        Optional<DoanhNghiep> doanhnghiep = doanhnghiepRepository.findById(Id);
        if (doanhnghiep.isPresent()) {
        	DoanhNghiep dn = doanhnghiep.get();
        	doanhnghiepRepository.delete(dn);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<DoanhNghiep> getAllDoanhNghiep(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<DoanhNghiep> pagedResult = doanhnghiepRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<DoanhNghiep>();
          }
      }

}