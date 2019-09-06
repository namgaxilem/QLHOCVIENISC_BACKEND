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

import vn.team06.qlhocvienisc.entity.ChuyenNganh;
import vn.team06.qlhocvienisc.service.ChuyenNganhService;

@RestController
public class ChuyenNganhController {
	@Autowired
	ChuyenNganhService chuyennganhService;
	@RequestMapping(value = "/chuyennganh")
    public List<ChuyenNganh> chuyennganh() {
        return chuyennganhService.getAll();
    }
 
    @RequestMapping(value = "/chuyennganh", method = RequestMethod.POST)
    public ChuyenNganh createChuyennganh(@Valid @RequestBody ChuyenNganh chuyennganh)
    {
        return chuyennganhService.createChuyennganh(chuyennganh);
    }
 
    @RequestMapping(value = "/chuyennganh/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteChuyennganh(@PathVariable(value = "id") int id) 
    {
        return chuyennganhService.deleteChuyennganh(id);
    }
 
    @RequestMapping(value = "/chuyennganh/{id}", method = RequestMethod.PUT)
    public ChuyenNganh updateChuyennganh(@PathVariable(value = "id") int id, @Valid @RequestBody ChuyenNganh chuyennganh) 
    {
        return chuyennganhService.updateChuyennganh(id, chuyennganh);
    }
    
    @RequestMapping(value = "/chuyennganh2", method = RequestMethod.GET)
    public ResponseEntity<List<ChuyenNganh>> getAllChuyenNganh(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "1") int idChuyennganh,
                        @RequestParam(defaultValue = "ID") String sortBy)
    {
        List<ChuyenNganh> list = chuyennganhService.getAllChuyenNganh(pageNo, pageSize, idChuyennganh, sortBy);
 
        return new ResponseEntity<List<ChuyenNganh>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/chuyennganh3", method = RequestMethod.GET)
    public ResponseEntity<List<ChuyenNganh>> getAllChuyenNganh2(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "ID") String sortBy)
    {
        List<ChuyenNganh> list = chuyennganhService.getAllChuyenNganh2(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<ChuyenNganh>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
