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

import vn.team06.qlhocvienisc.entity.TruongHoc;
import vn.team06.qlhocvienisc.service.TruongHocService;

@RestController
public class TruongHocController {
	@Autowired
	TruongHocService truonghocService;
	@RequestMapping(value = "/truonghoc")
    public List<TruongHoc> truonghoc() {
        return truonghocService.getAll();
    }
 
    @RequestMapping(value = "/truonghoc", method = RequestMethod.POST)
    public TruongHoc createTruong(@Valid @RequestBody TruongHoc truonghoc)
    {
        return truonghocService.createTruong(truonghoc);
    }
 
    @RequestMapping(value = "/truonghoc/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTruong(@PathVariable(value = "id") String id) 
    {
        return truonghocService.deleteTruong(id);
    }
 
    @RequestMapping(value = "/truonghoc/{id}", method = RequestMethod.PUT)
    public TruongHoc updateTruong(@PathVariable(value = "id") String id, @Valid @RequestBody TruongHoc truonghoc) 
    {
        return truonghocService.updateTruong(id, truonghoc);
    }
    
    @RequestMapping(value = "/truonghoc2", method = RequestMethod.GET)
    public ResponseEntity<List<TruongHoc>> getAllTruongHoc(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "MATRUONG") String sortBy)
    {
        List<TruongHoc> list = truonghocService.getAllTruongHoc(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<TruongHoc>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
