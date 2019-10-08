package vn.team06.qlhocvienisc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.team06.qlhocvienisc.entity.HocVien;
import vn.team06.qlhocvienisc.service.DangNhapService;

@RestController
public class DangNhapController {
	@Autowired
	DangNhapService dangnhapService;
    
    @RequestMapping(value = "/dangnhap/{loaitaikhoan}",
    		method = RequestMethod.POST)
    @ResponseBody
    public boolean dangnhap(
    		@PathVariable(value = "loaitaikhoan") Integer loaitaikhoan,
    		@Valid @RequestBody HocVien hocvien) 
    {
    	return dangnhapService.dangnhap(loaitaikhoan, hocvien.getMAHV(), hocvien.getPASSWORD());
    }
}

