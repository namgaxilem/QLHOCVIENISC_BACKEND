package vn.team06.qlhocvienisc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.team06.qlhocvienisc.entity.NguoiQuanLy;
import vn.team06.qlhocvienisc.service.NguoiQuanLyService;


@RestController
public class NguoiQuanLyController {
	
	@Autowired
	NguoiQuanLyService nguoiquanlyService;
	
	@RequestMapping(value = "/nguoiquanly")
    public List<NguoiQuanLy> monhoc() {
        return nguoiquanlyService.getAll();
    }
 
    @RequestMapping(value = "/createnguoiquanly", method = RequestMethod.POST)
    public NguoiQuanLy createNguoiQuanly(@Valid @RequestBody NguoiQuanLy nguoiquanly)
    {
        return nguoiquanlyService.createNguoiQuanLy(nguoiquanly);
    }
 
    @RequestMapping(value = "/daletenguoiquanly/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") String id) 
    {
        return nguoiquanlyService.deleteNguoiQuanLy(id);
    }
 
    @RequestMapping(value = "/updatenguoiquanly/{id}", method = RequestMethod.PUT)
    public NguoiQuanLy updateNguoiQuanLy(@PathVariable(value = "id") String id, @Valid @RequestBody NguoiQuanLy nguoiquanly) 
    {
        return nguoiquanlyService.updateNguoiQuanLy(id, nguoiquanly);
    }
    
    @RequestMapping(value = "/nguoiquanly2", method = RequestMethod.GET)
    public ResponseEntity<List<NguoiQuanLy>> getAllNguoiQuanLy(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "MANQL") String sortBy)
    {
        List<NguoiQuanLy> list = nguoiquanlyService.getAllNguoiQuanLy(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<NguoiQuanLy>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
