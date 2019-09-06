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

import vn.team06.qlhocvienisc.entity.MonHoc;
import vn.team06.qlhocvienisc.repository.MonHocRepository;

@Service
public class MonHocService {
	@Autowired
	MonHocRepository monhocRepository;
	
	public List<MonHoc> getAll() {
        return (List<MonHoc>) monhocRepository.findAll();
    }
     
    public MonHoc createMonhoc(MonHoc monhoc) {
        return monhocRepository.save(monhoc);
    }
     
    public MonHoc updateMonhoc(String Id, MonHoc monhoc)
    {
    	MonHoc updatedMH;
        Optional<MonHoc> searchEntity = monhocRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	MonHoc mh = searchEntity.get();
            mh.setTENMH(monhoc.getTENMH());
            mh.setSOGIO(monhoc.getSOGIO());
            mh.setSOTC(monhoc.getSOTC());
            updatedMH = monhocRepository.save(mh);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedMH;
       }
     
      public ResponseEntity<Object> deleteMonhoc(String Id) 
      {
        Optional<MonHoc> monhoc = monhocRepository.findById(Id);
        if (monhoc.isPresent()) {
        	MonHoc mh = monhoc.get();
        	monhocRepository.delete(mh);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<MonHoc> getAllMonHoc(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<MonHoc> pagedResult = monhocRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<MonHoc>();
          }
      }
}
