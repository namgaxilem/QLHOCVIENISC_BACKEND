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

import vn.team06.qlhocvienisc.entity.CanBoGiangVien;
import vn.team06.qlhocvienisc.entity.ChuyenNganh;
import vn.team06.qlhocvienisc.entity.HocVien;
import vn.team06.qlhocvienisc.entity.NguoiQuanLy;
import vn.team06.qlhocvienisc.repository.CanBoGiangVienRepository;
import vn.team06.qlhocvienisc.repository.ChuyenNganhRepository;
import vn.team06.qlhocvienisc.repository.HocVienRepository;
import vn.team06.qlhocvienisc.repository.NguoiQuanLyRepository;

@Service
public class DangNhapService {
	
	@Autowired
	HocVienRepository hocvienRepository;
	
	@Autowired
	NguoiQuanLyRepository nguoiquanlyRepository;
	
	@Autowired
	CanBoGiangVienRepository canbogiangvienRepository;
	
	public boolean dangnhap(Integer loaitaikhoan, String username, String password) {
		try {
			password = MaHoaMD5.convertHashToString(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		if (loaitaikhoan == 0) {
			Pageable paging = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "PASSWORD"));
 		   
            Page<HocVien> pagedResult = hocvienRepository.timhocvienTheoUsernameVaPassword(username, password, paging);
             
            if(pagedResult.hasContent()) {
                return true;
            } else {
                return false;
            }
		}
		else if (loaitaikhoan == 1) {
			Pageable paging = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "PASSWORD"));
	 		   
            Page<CanBoGiangVien> pagedResult = canbogiangvienRepository.timgvTheoUsernameVaPassword(username, password, paging);
             
            if(pagedResult.hasContent()) {
                return true;
            } else {
                return false;
            }
		}
		else if (loaitaikhoan == 2) {
			Pageable paging = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "PASSWORD"));
	 		   
            Page<NguoiQuanLy> pagedResult = nguoiquanlyRepository.timnqlTheoUsernameVaPassword(username, password, paging);
             
            if(pagedResult.hasContent()) {
                return true;
            } else {
                return false;
            }
		}
		return false;
	}
}
