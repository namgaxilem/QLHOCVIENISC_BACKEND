package vn.team06.qlhocvienisc.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vn.team06.qlhocvienisc.entity.NguoiHuongDan;
import vn.team06.qlhocvienisc.repository.NguoiHuongDanRepository;

@Service
public class NguoiHuongDanService {
	@Autowired
	NguoiHuongDanRepository nguoihuongdanRepository;
	
	public List<NguoiHuongDan> getAll() {
        return (List<NguoiHuongDan>) nguoihuongdanRepository.findAll();
    }
     
    public NguoiHuongDan createNguoihuongdan(NguoiHuongDan nguoihuongdan) {
        return nguoihuongdanRepository.save(nguoihuongdan);
    }
     
    public NguoiHuongDan updateNguoihuongdan(int Id, NguoiHuongDan nguoihuongdan)
    {
    	NguoiHuongDan updatedNGHD;
        Optional<NguoiHuongDan> searchEntity = nguoihuongdanRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	NguoiHuongDan nghd = searchEntity.get();
        	nghd.setHO(nguoihuongdan.getHO());
        	nghd.setTENLOT(nguoihuongdan.getTENLOT());
        	nghd.setTEN(nguoihuongdan.getTEN());
        	nghd.setSDT(nguoihuongdan.getSDT());
        	nghd.setEMAIL(nguoihuongdan.getEMAIL());
        	nghd.setTruonghoc(nguoihuongdan.getTruonghoc());
            updatedNGHD = nguoihuongdanRepository.save(nghd);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedNGHD;
       }
     
      public ResponseEntity<Object> deleteNguoihuongdan(int Id) 
      {
        Optional<NguoiHuongDan> nguoihuongdan = nguoihuongdanRepository.findById(Id);
        if (nguoihuongdan.isPresent()) {
        	NguoiHuongDan nghd = nguoihuongdan.get();
        	nguoihuongdanRepository.delete(nghd);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
}
