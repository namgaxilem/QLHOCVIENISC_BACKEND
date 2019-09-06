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
import vn.team06.qlhocvienisc.entity.HocVien;
import vn.team06.qlhocvienisc.repository.CanBoGiangVienRepository;

@Service
public class CanBoGiangVienService {
	@Autowired
	CanBoGiangVienRepository CanBoGiangVienRepository;
	
    public List<CanBoGiangVien> getAll() {
        return (List<CanBoGiangVien>) CanBoGiangVienRepository.findAll();
    }
    
    public Optional<CanBoGiangVien> getCanBoGiangVienId(String Id) {
        return  CanBoGiangVienRepository.findById(Id);
    }
    
    public CanBoGiangVien createCanBoGiangVien(CanBoGiangVien canbogiangvien) {
        return CanBoGiangVienRepository.save(canbogiangvien);
    }
    
    public ResponseEntity<Object> deleteCanBoGiangVien(String Id) 
    {
      Optional<CanBoGiangVien> canbogiangvien = CanBoGiangVienRepository.findById(Id);
      if (canbogiangvien.isPresent()) {
    	  CanBoGiangVien cbgv = canbogiangvien.get();
    	  CanBoGiangVienRepository.delete(cbgv);
       } else {
              throw new EntityNotFoundException();
       }
       return ResponseEntity.ok().build();
    }    
    
    public List<CanBoGiangVien> getAllCanBoGiangVien(Integer pageNo, Integer pageSize, int typeSort, String sortBy)
    {
    	if (typeSort == 1)
    	{
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));
            
            Page<CanBoGiangVien> pagedResult = CanBoGiangVienRepository.findAll(paging);
             
            if(pagedResult.hasContent()) {
                return pagedResult.getContent();
            } else {
                return new ArrayList<CanBoGiangVien>();
            }
    	}
    	else
    	{
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, sortBy));
            
            Page<CanBoGiangVien> pagedResult = CanBoGiangVienRepository.findAll(paging);
             
            if(pagedResult.hasContent()) {
                return pagedResult.getContent();
            } else {
                return new ArrayList<CanBoGiangVien>();
            }
    	}
  
    }
    
    
    public CanBoGiangVien updateCanBoGiangVien(String Id, CanBoGiangVien canbogiangvien)
    {
    	CanBoGiangVien updatedCBGV;
        Optional<CanBoGiangVien> searchEntity = CanBoGiangVienRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	CanBoGiangVien cbgv = searchEntity.get();
        	cbgv.setHO(canbogiangvien.getHO());
        	cbgv.setTENLOT(canbogiangvien.getTENLOT());
        	cbgv.setTEN(canbogiangvien.getTEN());
        	cbgv.setGIOITINH(canbogiangvien.getGIOITINH());
        	cbgv.setNGAYSINH(canbogiangvien.getNGAYSINH());
        	cbgv.setNOISINH(canbogiangvien.getNOISINH());
        	cbgv.setCMND(canbogiangvien.getCMND());
        	cbgv.setSDT(canbogiangvien.getSDT());
        	cbgv.setEMAIL(canbogiangvien.getEMAIL());
        	cbgv.setDIACHI(canbogiangvien.getDIACHI());
        	cbgv.setLUONG(canbogiangvien.getLUONG());
        	cbgv.setHSLUONG(canbogiangvien.getHSLUONG());
        	cbgv.setNGAYVAOLAM(canbogiangvien.getNGAYVAOLAM());
        	cbgv.setPASSWORD(canbogiangvien.getPASSWORD());
        	cbgv.setACCOUNTTYPE(canbogiangvien.getACCOUNTTYPE());
            updatedCBGV = CanBoGiangVienRepository.save(cbgv);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedCBGV;
       }
}