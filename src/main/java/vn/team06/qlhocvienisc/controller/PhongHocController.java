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

import vn.team06.qlhocvienisc.entity.HocVien;
import vn.team06.qlhocvienisc.entity.PhongHoc;
import vn.team06.qlhocvienisc.service.PhongHocService;

@RestController
public class PhongHocController {
	
	@Autowired
	PhongHocService phonghocService;
 
    @RequestMapping(value = "/phonghoc")
    public List<PhongHoc> sample() {
        return phonghocService.getAll2();
    }
 
    @RequestMapping(value = "/createphonghoc", method = RequestMethod.POST)
    public PhongHoc createSample(@Valid @RequestBody PhongHoc phonghoc)
    {
        return phonghocService.createPhongHoc(phonghoc);
    }
 
    @RequestMapping(value = "/deletephonghoc/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") String id) 
    {
        return phonghocService.deletePhongHoc(id);
    }
 
    @RequestMapping(value = "/updatephonghoc/{id}", method = RequestMethod.PUT)
    public PhongHoc updateSample(@PathVariable(value = "id") String id, @Valid @RequestBody PhongHoc phonghoc) 
    {
        return phonghocService.updatePhongHoc(id, phonghoc);
    }
    
    @RequestMapping(value = "/phonghoc2", method = RequestMethod.GET)
    public ResponseEntity<List<PhongHoc>> getAllPhongHoc(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "MAPHG") String sortBy)
    {
        List<PhongHoc> list = phonghocService.getAllPhongHoc(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<PhongHoc>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
}
