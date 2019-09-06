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

import vn.team06.qlhocvienisc.entity.DoanhNghiep;
import vn.team06.qlhocvienisc.entity.HocVien;
import vn.team06.qlhocvienisc.service.DoanhNghiepService;

@RestController
public class DoanhNghiepController {

	@Autowired
	DoanhNghiepService doanhnghiepService;
 
    @RequestMapping(value = "/doanhnghiep")
    public List<DoanhNghiep> sample() {
        return doanhnghiepService.getAll();
    }
 
    @RequestMapping(value = "/createdoanhnghiep", method = RequestMethod.POST)
    public DoanhNghiep createSample(@Valid @RequestBody DoanhNghiep doanhnghiep)
    {
        return doanhnghiepService.createDoanhNghiep(doanhnghiep);
    }
 
    @RequestMapping(value = "/deletedoanhnghiep/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") Integer id) 
    {
        return doanhnghiepService.deleteDoanhNghiep(id);
    }
 
    @RequestMapping(value = "/updatedoanhnghiep/{id}", method = RequestMethod.PUT)
    public DoanhNghiep updateSample(@PathVariable(value = "id") Integer id, @Valid @RequestBody DoanhNghiep doanhnghiep) 
    {
        return doanhnghiepService.updateDoanhNghiep(id, doanhnghiep);
    }
    
    @RequestMapping(value = "/doanhnghiep2", method = RequestMethod.GET)
    public ResponseEntity<List<DoanhNghiep>> getAllHocVien(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "ID") String sortBy)
    {
        List<DoanhNghiep> list = doanhnghiepService.getAllDoanhNghiep(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<DoanhNghiep>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
