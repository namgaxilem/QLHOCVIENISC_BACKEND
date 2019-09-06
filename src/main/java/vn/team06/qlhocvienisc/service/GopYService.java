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

import vn.team06.qlhocvienisc.entity.CanBoGiangVien;
import vn.team06.qlhocvienisc.entity.GopY;
import vn.team06.qlhocvienisc.repository.GopYRepository;

@Service
public class GopYService {
	@Autowired
	GopYRepository GopYRepository;
 
       
        
    public List<GopY> getAll() {
        return (List<GopY>) GopYRepository.findAll();
    }
    
    public Optional<GopY> getGopYId(int Id) {
        return  GopYRepository.findById(Id);
    }
     
    public GopY createGopY(GopY gopy) {
        return GopYRepository.save(gopy);
    }
     
    public GopY updateGopY(int Id, GopY gopy)
    {
    	GopY updatedGY;
        Optional<GopY> searchEntity = GopYRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	GopY gy = searchEntity.get();
            gy.setNGAYNHAN(gopy.getNGAYNHAN());
            gy.setNOIDUNG(gopy.getNOIDUNG());
            updatedGY = GopYRepository.save(gy);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedGY;
       }
     
      public ResponseEntity<Object> deleteGopY(int Id) 
      {
        Optional<GopY> gopy = GopYRepository.findById(Id);
        if (gopy.isPresent()) {
        	GopY gy = gopy.get();
           GopYRepository.delete(gy);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }    
    
      public List<GopY> getAllGopY(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<GopY> pagedResult = GopYRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<GopY>();
          }
      }
}