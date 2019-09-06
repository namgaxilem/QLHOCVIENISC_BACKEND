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

import vn.team06.qlhocvienisc.entity.KhoaHoc;
import vn.team06.qlhocvienisc.service.KhoaHocService;

@RestController
public class KhoaHocController {
	@Autowired
	KhoaHocService khoahocService;
	@RequestMapping(value = "/khoahoc")
    public List<KhoaHoc> khoahoc() {
        return khoahocService.getAll();
    }
 
    @RequestMapping(value = "/khoahoc", method = RequestMethod.POST)
    public KhoaHoc createKhoahoc(@Valid @RequestBody KhoaHoc khoahoc)
    {
        return khoahocService.createKhoahoc(khoahoc);
    }
 
    @RequestMapping(value = "/khoahoc/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteKhoahoc(@PathVariable(value = "id") String id) 
    {
        return khoahocService.deleteKhoahoc(id);
    }
 
    @RequestMapping(value = "/khoahoc/{id}", method = RequestMethod.PUT)
    public KhoaHoc updateKhoahoc(@PathVariable(value = "id") String id, @Valid @RequestBody KhoaHoc khoahoc) 
    {
        return khoahocService.updateKhoahoc(id, khoahoc);
    }
    
    @RequestMapping(value = "/khoahoc2", method = RequestMethod.GET)
    public ResponseEntity<List<KhoaHoc>> getAllKhoaHoc(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "MAKHOAHOC") String sortBy)
    {
        List<KhoaHoc> list = khoahocService.getAllKhoaHoc(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<KhoaHoc>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
