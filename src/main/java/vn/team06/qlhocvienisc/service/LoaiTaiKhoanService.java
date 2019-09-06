package vn.team06.qlhocvienisc.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vn.team06.qlhocvienisc.entity.LoaiTaiKhoan;
import vn.team06.qlhocvienisc.repository.LoaiTaiKhoanRepository;

@Service
public class LoaiTaiKhoanService {
	@Autowired
	LoaiTaiKhoanRepository loaitaikhoanRepository;
	
	public List<LoaiTaiKhoan> getAll() {
        return (List<LoaiTaiKhoan>) loaitaikhoanRepository.findAll();
    }
     
    public LoaiTaiKhoan createLoaitaikhoan(LoaiTaiKhoan loaitaikhoan) {
        return loaitaikhoanRepository.save(loaitaikhoan);
    }
     
    public LoaiTaiKhoan updateLoaitaikhoan(int Id, LoaiTaiKhoan loaitaikhoan)
    {
    	LoaiTaiKhoan updatedLTK;
        Optional<LoaiTaiKhoan> searchEntity = loaitaikhoanRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	LoaiTaiKhoan ltk = searchEntity.get();
        	ltk.setTENLOAI(loaitaikhoan.getTENLOAI());
            updatedLTK = loaitaikhoanRepository.save(ltk);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedLTK;
       }
     
      public ResponseEntity<Object> deleteLoaitaikhoan(int Id) 
      {
        Optional<LoaiTaiKhoan> loaitaikhoan = loaitaikhoanRepository.findById(Id);
        if (loaitaikhoan.isPresent()) {
        	LoaiTaiKhoan ltk = loaitaikhoan.get();
        	loaitaikhoanRepository.delete(ltk);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
}
