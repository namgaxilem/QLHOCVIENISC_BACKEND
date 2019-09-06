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

import vn.team06.qlhocvienisc.entity.ThoiKhoaBieu;
import vn.team06.qlhocvienisc.repository.ThoiKhoaBieuRepository;

@Service
public class ThoiKhoaBieuService {
	@Autowired
	ThoiKhoaBieuRepository thoikhoabieuRepository;
	
	public List<ThoiKhoaBieu> getAll() {
        return (List<ThoiKhoaBieu>) thoikhoabieuRepository.findAll();
    }
     
    public ThoiKhoaBieu createThoiKhoaBieu(ThoiKhoaBieu thoikhoabieu) {
        return thoikhoabieuRepository.save(thoikhoabieu);
    }
     
    public ThoiKhoaBieu updateThoiKhoaBieu(Integer Id, ThoiKhoaBieu thoikhoabieu)
    {
    	ThoiKhoaBieu updatedTKB;
        Optional<ThoiKhoaBieu> searchEntity = thoikhoabieuRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	ThoiKhoaBieu tkb = searchEntity.get();
        	tkb.setGIOBD(thoikhoabieu.getGIOBD());
        	tkb.setGIOKT(thoikhoabieu.getGIOKT());
        	tkb.setNGAYHOC(thoikhoabieu.getNGAYHOC());
        	tkb.setMacbgv(thoikhoabieu.getMacbgv());
        	tkb.setMakhoahoc(thoikhoabieu.getMakhoahoc());
        	tkb.setMamh(thoikhoabieu.getMamh());
        	tkb.setMaphg(thoikhoabieu.getMaphg());
            updatedTKB = thoikhoabieuRepository.save(tkb);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedTKB;
       }
     
      public ResponseEntity<Object> deleteThoiKhoaBieu(Integer Id) 
      {
        Optional<ThoiKhoaBieu> thoikhoabieu = thoikhoabieuRepository.findById(Id);
        if (thoikhoabieu.isPresent()) {
        	ThoiKhoaBieu tkb = thoikhoabieu.get();
        	thoikhoabieuRepository.delete(tkb);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<ThoiKhoaBieu> getAllThoiKhoaBieu(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<ThoiKhoaBieu> pagedResult = thoikhoabieuRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<ThoiKhoaBieu>();
          }
      }
}