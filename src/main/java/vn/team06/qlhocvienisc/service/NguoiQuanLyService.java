package vn.team06.qlhocvienisc.service;

import java.security.NoSuchAlgorithmException;
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

import vn.team06.qlhocvienisc.entity.NguoiQuanLy;
import vn.team06.qlhocvienisc.repository.NguoiQuanLyRepository;


@Service
public class NguoiQuanLyService {
	@Autowired
	NguoiQuanLyRepository nguoiquanlyRepository;
	
	public List<NguoiQuanLy> getAll() {
        return (List<NguoiQuanLy>) nguoiquanlyRepository.findAll();
    }
     
    public NguoiQuanLy createNguoiQuanLy(NguoiQuanLy nguoiquanly) {
    	try {
			nguoiquanly.setPASSWORD(MaHoaMD5.convertHashToString(nguoiquanly.getPASSWORD()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return nguoiquanlyRepository.save(nguoiquanly);
    }
     
    public NguoiQuanLy updateNguoiQuanLy(String Id, NguoiQuanLy nguoiquanly)
    {
    	NguoiQuanLy updatedNQL;
        Optional<NguoiQuanLy> searchEntity = nguoiquanlyRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	NguoiQuanLy nql = searchEntity.get();
        	nql.setMANQL(nguoiquanly.getMANQL());
            nql.setHO(nguoiquanly.getHO());
            nql.setTENLOT(nguoiquanly.getTENLOT());
            nql.setTEN(nguoiquanly.getTEN());
            nql.setNGAYSINH(nguoiquanly.getNGAYSINH());
            nql.setGIOITINH(nguoiquanly.getGIOITINH());
            nql.setSDT(nguoiquanly.getSDT());
            nql.setEMAIL(nguoiquanly.getEMAIL());
            nql.setDIACHI(nguoiquanly.getDIACHI());
            try {
				nql.setPASSWORD(MaHoaMD5.convertHashToString(nguoiquanly.getPASSWORD()));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            nql.setACCOUNTTYPE(nguoiquanly.getACCOUNTTYPE());
            updatedNQL = nguoiquanlyRepository.save(nql);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedNQL;
       }
     
      public ResponseEntity<Object> deleteNguoiQuanLy(String Id) 
      {
        Optional<NguoiQuanLy> nguoiquanly = nguoiquanlyRepository.findById(Id);
        if (nguoiquanly.isPresent()) {
        	NguoiQuanLy nql = nguoiquanly.get();
        	nguoiquanlyRepository.delete(nql);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<NguoiQuanLy> getAllNguoiQuanLy(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<NguoiQuanLy> pagedResult = nguoiquanlyRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<NguoiQuanLy>();
          }
      }
}