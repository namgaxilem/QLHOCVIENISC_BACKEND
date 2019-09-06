package vn.team06.qlhocvienisc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.team06.qlhocvienisc.entity.LoaiTaiKhoan;
import vn.team06.qlhocvienisc.service.LoaiTaiKhoanService;

@RestController
public class LoaiTaiKhoanController {
	@Autowired
	LoaiTaiKhoanService loaitaikhoanService;
	@RequestMapping(value = "/loaitaikhoan")
    public List<LoaiTaiKhoan> loaitaikhoan() {
        return loaitaikhoanService.getAll();
    }
 
    @RequestMapping(value = "/loaitaikhoan", method = RequestMethod.POST)
    public LoaiTaiKhoan createLoaitaikhoan(@Valid @RequestBody LoaiTaiKhoan loaitaikhoan)
    {
        return loaitaikhoanService.createLoaitaikhoan(loaitaikhoan);
    }
 
    @RequestMapping(value = "/loaitaikhoan/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteLoaitaikhoan(@PathVariable(value = "id") int id) 
    {
        return loaitaikhoanService.deleteLoaitaikhoan(id);
    }
 
    @RequestMapping(value = "/loaitaikhoan/{id}", method = RequestMethod.PUT)
    public LoaiTaiKhoan updateLoaitaikhoan(@PathVariable(value = "id") int id, @Valid @RequestBody LoaiTaiKhoan loaitaikhoan) 
    {
        return loaitaikhoanService.updateLoaitaikhoan(id, loaitaikhoan);
    }
}
