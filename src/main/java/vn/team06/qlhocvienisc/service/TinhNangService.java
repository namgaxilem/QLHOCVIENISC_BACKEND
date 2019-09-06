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


import vn.team06.qlhocvienisc.entity.TinhNang;
import vn.team06.qlhocvienisc.repository.TinhNangRepository;

@Service
public class TinhNangService {
	@Autowired
	TinhNangRepository TinhNangRepository;
	
    public List<TinhNang> getAll() {
        return (List<TinhNang>) TinhNangRepository.findAll();
    }
    
    public Optional<TinhNang> getTinhNangId(int Id) {
        return  TinhNangRepository.findById(Id);
    }
     
    public TinhNang createTinhNang(TinhNang tinhnang) {
        return TinhNangRepository.save(tinhnang);
    }
     
    public TinhNang updateTinhNang(int Id, TinhNang tinhnang)
    {
    	TinhNang updatedTN;
        Optional<TinhNang> searchEntity = TinhNangRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	TinhNang tn = searchEntity.get();
        	tn.setTENMENU(tinhnang.getTENMENU());
        	tn.setLINK(tinhnang.getLINK());
        	tn.setType(tinhnang.getType());
            updatedTN = TinhNangRepository.save(tn);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedTN;
       }
     
      public ResponseEntity<Object> deleteTinhNang(int Id) 
      {
        Optional<TinhNang> tinhnang = TinhNangRepository.findById(Id);
        if (tinhnang.isPresent()) {
        	TinhNang tn = tinhnang.get();
        	TinhNangRepository.delete(tn);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }    
    
      public List<TinhNang> getAllTinhNang(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<TinhNang> pagedResult = TinhNangRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<TinhNang>();
          }
      }
}