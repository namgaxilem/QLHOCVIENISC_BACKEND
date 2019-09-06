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

import vn.team06.qlhocvienisc.entity.MonHoc;
import vn.team06.qlhocvienisc.service.MonHocService;

@RestController
public class MonHocController {
	@Autowired
	MonHocService monhocService;
	@RequestMapping(value = "/monhoc")
    public List<MonHoc> monhoc() {
        return monhocService.getAll();
    }
 
    @RequestMapping(value = "/monhoc", method = RequestMethod.POST)
    public MonHoc createMonhoc(@Valid @RequestBody MonHoc monhoc)
    {
        return monhocService.createMonhoc(monhoc);
    }
 
    @RequestMapping(value = "/monhoc/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteMonhoc(@PathVariable(value = "id") String id) 
    {
        return monhocService.deleteMonhoc(id);
    }
 
    @RequestMapping(value = "/monhoc/{id}", method = RequestMethod.PUT)
    public MonHoc updateMonhoc(@PathVariable(value = "id") String id, @Valid @RequestBody MonHoc monhoc) 
    {
        return monhocService.updateMonhoc(id, monhoc);
    }
    
    @RequestMapping(value = "/monhoc2", method = RequestMethod.GET)
    public ResponseEntity<List<MonHoc>> getAllMonHoc(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "MAMH") String sortBy)
    {
        List<MonHoc> list = monhocService.getAllMonHoc(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<MonHoc>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
