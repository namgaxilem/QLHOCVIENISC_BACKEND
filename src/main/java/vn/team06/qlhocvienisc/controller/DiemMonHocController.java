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


import vn.team06.qlhocvienisc.entity.DiemMonHoc;
import vn.team06.qlhocvienisc.service.DiemMonHocService;

@RestController
public class DiemMonHocController {
	@Autowired
	DiemMonHocService diemmonhocService;
	
	@RequestMapping(value = "/diemmonhoc")
    public List<DiemMonHoc> diemmonhoc() {
        return diemmonhocService.getAll();
    }
 
    @RequestMapping(value = "/diemmonhoc", 
    		method = RequestMethod.POST)
    public DiemMonHoc createHocvien(@Valid @RequestBody DiemMonHoc diemmonhoc)
    {
        return diemmonhocService.createDiemMonHoc(diemmonhoc);
    }
 
    @RequestMapping(value = "/diemonhoc/{id}", 
    		method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDiemMonHoc(@PathVariable(value = "id") Integer id) 
    {
        return diemmonhocService.deleteDiemMonHoc(id);
    }
 
    @RequestMapping(value = "/diemmonhoc/{id}", 
    		method = RequestMethod.PUT)
    public DiemMonHoc updateDiemMonHoc(@PathVariable(value = "id") Integer id, @Valid @RequestBody DiemMonHoc diemmonhoc) 
    {
        return diemmonhocService.updateDiemMonHoc(id, diemmonhoc);
    }
}