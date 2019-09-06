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

import vn.team06.qlhocvienisc.entity.ThongBao;
import vn.team06.qlhocvienisc.repository.ThongBaoRepository;

@Service
public class ThongBaoService {
	@Autowired
	ThongBaoRepository thongbaoRepository;
	
	public List<ThongBao> getAll() {
        return (List<ThongBao>) thongbaoRepository.findAll();
    }
     
    public ThongBao createThongBao(ThongBao thongbao) {
        return thongbaoRepository.save(thongbao);
    }
     
    public ThongBao updateThongBao(Integer Id, ThongBao thongbao)
    {
    	ThongBao updatedTB;
        Optional<ThongBao> searchEntity = thongbaoRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	ThongBao tb = searchEntity.get();
            updatedTB = thongbaoRepository.save(tb);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedTB;
       }
     
      public ResponseEntity<Object> deleteThongBao(Integer Id) 
      {
        Optional<ThongBao> thongbao = thongbaoRepository.findById(Id);
        if (thongbao.isPresent()) {
        	ThongBao tb = thongbao.get();
        	thongbaoRepository.delete(tb);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<ThongBao> getAllThongBao(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<ThongBao> pagedResult = thongbaoRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<ThongBao>();
          }
      }
}