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

import vn.team06.qlhocvienisc.entity.DaoTao;
import vn.team06.qlhocvienisc.repository.DaoTaoRepository;

@Service
public class DaoTaoService {
	@Autowired
	DaoTaoRepository daotaoRepository;
	
	public List<DaoTao> getAll() {
        return (List<DaoTao>) daotaoRepository.findAll();
    }
     
    public DaoTao createDaoTao(DaoTao daotao) {
        return daotaoRepository.save(daotao);
    }
     
    public ResponseEntity<Object> updateDaoTao(String Id, Integer Id2, DaoTao daotao)
    {
    	Integer ktra = daotaoRepository.updateDaoTao(Id, Id2);
        if (ktra>0) {
        	daotao.setMAMH_ID(daotao.getMAMH_ID());
        	daotao.setCHUYENNGANH_ID(daotao.getCHUYENNGANH_ID());
        	daotaoRepository.save(daotao);
        	System.out.println("Cap nhat thanh cong!");
         } else {
             throw new EntityNotFoundException();
         }
        return ResponseEntity.ok().build();
       }
     
      public ResponseEntity<Object> deleteDaoTao(String Id, Integer Id2) 
      {
        Integer daotao = daotaoRepository.deleteDaoTao(Id, Id2);
        if (daotao>0) {
        	System.out.println("Xoa thanh cong!");
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<DaoTao> getAllDaoTao(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<DaoTao> pagedResult = daotaoRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<DaoTao>();
          }
      }
}
