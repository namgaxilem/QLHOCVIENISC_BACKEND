package vn.team06.qlhocvienisc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

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
	CanBoGiangVienRepository canBoGiangVienRepository;

	public List<CanBoGiangVien> getAll() {
		return (List<CanBoGiangVien>) canBoGiangVienRepository.findAll();
	}

	public Optional<CanBoGiangVien> getCanBoGiangVienId(String Id) {
		return canBoGiangVienRepository.findById(Id);
	}

	public CanBoGiangVien createCanBoGiangVien(CanBoGiangVien canbogiangvien) {
		return canBoGiangVienRepository.save(canbogiangvien);
	}

	public ResponseEntity<Object> deleteCanBoGiangVien(String Id) {
//		StoredProcedureQuery query = entityManager
//				.createStoredProcedureQuery("count_comments")
//				.registerStoredProcedureParameter(
//				    "postId",
//				    Long.class,
//				    ParameterMode.IN
//				)
//				.registerStoredProcedureParameter(
//				    "commentCount",
//				    Long.class,
//				    ParameterMode.OUT
//				)
//				.setParameter("postId", 1L);
//				 
//				query.execute();
		Optional<CanBoGiangVien> canbogiangvien = canBoGiangVienRepository.findById(Id);
		if (canbogiangvien.isPresent()) {
			CanBoGiangVien cbgv = canbogiangvien.get();
//			CanBoGiangVienRepository.delete(cbgv);
			canBoGiangVienRepository.sp_delete_giangvien(Id);

		} else {
			throw new EntityNotFoundException();
		}
		return ResponseEntity.ok().build();
	}

	public List<CanBoGiangVien> getAllCanBoGiangVien(Integer pageNo, Integer pageSize, int typeSort, String sortBy) {
		if (typeSort == 1) {
			Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));

			Page<CanBoGiangVien> pagedResult = canBoGiangVienRepository.findAll(paging);

			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				return new ArrayList<CanBoGiangVien>();
			}
		} else {
			Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, sortBy));

			Page<CanBoGiangVien> pagedResult = canBoGiangVienRepository.findAll(paging);

			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				return new ArrayList<CanBoGiangVien>();
			}
		}

	}

	public CanBoGiangVien updateCanBoGiangVien(String Id, CanBoGiangVien canbogiangvien) {
		CanBoGiangVien updatedCBGV;
		Optional<CanBoGiangVien> searchEntity = canBoGiangVienRepository.findById(Id);
		if (searchEntity.isPresent()) {
			CanBoGiangVien cbgv = searchEntity.get();
			cbgv.setHO(canbogiangvien.getHO());
			cbgv.setTENLOT(canbogiangvien.getTENLOT());
			cbgv.setTEN(canbogiangvien.getTEN());
			cbgv.setGIOITINH(canbogiangvien.getGIOITINH());
			cbgv.setNGAYSINH(canbogiangvien.getNGAYSINH());
			cbgv.setSDT(canbogiangvien.getSDT());
			cbgv.setEMAIL(canbogiangvien.getEMAIL());
			cbgv.setDIACHI(canbogiangvien.getDIACHI());
			cbgv.setPASSWORD(canbogiangvien.getPASSWORD());
			cbgv.setACCOUNTTYPE(canbogiangvien.getACCOUNTTYPE());
			updatedCBGV = canBoGiangVienRepository.save(cbgv);
		} else {
			throw new EntityNotFoundException();
		}
		return updatedCBGV;
	}
}