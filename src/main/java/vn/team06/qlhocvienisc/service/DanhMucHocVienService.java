package vn.team06.qlhocvienisc.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vn.team06.qlhocvienisc.entity.DanhMucHocVien;
import vn.team06.qlhocvienisc.repository.DanhMucHocVienRepository;

@Service
public class DanhMucHocVienService {
	@Autowired
	DanhMucHocVienRepository danhmuchocvienRepository;
	public List<DanhMucHocVien> getAll() {
        return (List<DanhMucHocVien>) danhmuchocvienRepository.findAll();
    }
     
    public DanhMucHocVien createDanhmuchocvien(DanhMucHocVien danhmuchocvien) {
        return danhmuchocvienRepository.save(danhmuchocvien);
    }
     
    public DanhMucHocVien updateDanhmuchocvien(int Id, DanhMucHocVien danhmuchocvien)
    {
    	DanhMucHocVien updatedDMHV;
        Optional<DanhMucHocVien> searchEntity = danhmuchocvienRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	DanhMucHocVien dmhv = searchEntity.get();
        	dmhv.setTENLOAI(danhmuchocvien.getTENLOAI());
            updatedDMHV = danhmuchocvienRepository.save(dmhv);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedDMHV;
       }
     
      public ResponseEntity<Object> deleteDanhmuchocvien(int Id) 
      {
        Optional<DanhMucHocVien> danhmuchocvien = danhmuchocvienRepository.findById(Id);
        if (danhmuchocvien.isPresent()) {
        	DanhMucHocVien dmhv = danhmuchocvien.get();
        	danhmuchocvienRepository.delete(dmhv);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
}
