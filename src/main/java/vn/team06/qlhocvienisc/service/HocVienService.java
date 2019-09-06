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

import vn.team06.qlhocvienisc.entity.HocVien;
import vn.team06.qlhocvienisc.repository.HocVienRepository;

@Service
public class HocVienService {
	@Autowired
	HocVienRepository hocvienRepository;
 
       
        
    public List<HocVien> getAll() {
        return (List<HocVien>) hocvienRepository.findAll();
    }
     
    public HocVien createHocvien(HocVien hocvien) {
        return hocvienRepository.save(hocvien);
    }
     
    public HocVien updateHocvien(String Id, HocVien hocvien)
    {
    	HocVien updatedHV;
        Optional<HocVien> searchEntity = hocvienRepository.findById(Id);
        if (searchEntity.isPresent()) {
            HocVien sv = searchEntity.get();
            sv.setHO(hocvien.getHO());
            sv.setTENLOT(hocvien.getTENLOT());
            sv.setTEN(hocvien.getTEN());
            sv.setGIOITINH(hocvien.getGIOITINH());
            sv.setNGAYSINH(hocvien.getNGAYSINH());
            sv.setNOISINH(hocvien.getNOISINH());
            sv.setCMND(hocvien.getCMND());
            sv.setSDT(hocvien.getSDT());
            sv.setEMAIL(hocvien.getEMAIL());
            sv.setDIACHI(hocvien.getDIACHI());
            sv.setPASSWORD(hocvien.getPASSWORD());
            sv.setMATRUONG(hocvien.getMATRUONG());
            sv.setACCOUNTTYPE(hocvien.getACCOUNTTYPE());
            sv.setMAKHOAHOC(hocvien.getMAKHOAHOC());
            sv.setTYPE(hocvien.getTYPE());
            sv.setANHDAIDIEN(hocvien.getANHDAIDIEN());
            sv.setTGCOTHEDILAM(hocvien.getTGCOTHEDILAM());
            updatedHV = hocvienRepository.save(sv);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedHV;
       }
     
      public ResponseEntity<Object> deleteHocvien(String Id) 
      {
        Optional<HocVien> hocvien = hocvienRepository.findById(Id);
        if (hocvien.isPresent()) {
           HocVien hv = hocvien.get();
           hocvienRepository.delete(hv);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }    
    
      public List<HocVien> getAllHocVien(Integer pageNo, Integer pageSize,int typeSort, String maKH, String sortBy)
      {
    	  if(typeSort==1)
    	  {
    		  Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, sortBy));
    		   
              Page<HocVien> pagedResult = hocvienRepository.findCourse(maKH,paging);
               
              if(pagedResult.hasContent()) {
                  return pagedResult.getContent();
              } else {
                  return new ArrayList<HocVien>();
              }
    	  }
    	  else
    	  {
    		  Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));
    		   
              Page<HocVien> pagedResult = hocvienRepository.findAll(paging);
               
              if(pagedResult.hasContent()) {
                  return pagedResult.getContent();
              } else {
                  return new ArrayList<HocVien>();
              }
    	  }
          
      }
      
	public HocVien timkiemHocvien(String Id) 
      {
        Optional<HocVien> hocvien = hocvienRepository.findById(Id);
        if (hocvien.isPresent()) {
           HocVien hv = hocvien.get();
           return  hv;
         } else {
                throw new EntityNotFoundException();
         }
      }
}
