package vn.team06.qlhocvienisc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
import vn.team06.qlhocvienisc.service.HocVienService;

@RestController
public class HocVienController {
	@Autowired
	HocVienService hocvienService;
	@RequestMapping(value = "/hocvien")
    public List<HocVien> hocvien() {
        return hocvienService.getAll();
    }
 
    @RequestMapping(value = "/hocvien", method = RequestMethod.POST)
    public HocVien createHocvien(@Valid @RequestBody HocVien hocvien)
    {
        return hocvienService.createHocvien(hocvien);
    }
 
    @RequestMapping(value = "/hocvien/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteHocvien(@PathVariable(value = "id") String id) 
    {
        return hocvienService.deleteHocvien(id);
    }
 
    @RequestMapping(value = "/hocvien/{id}", method = RequestMethod.PUT)
    public HocVien updateHocvien(@PathVariable(value = "id") String id, @Valid @RequestBody HocVien hocvien) 
    {
        return hocvienService.updateHocvien(id, hocvien);
    }
    
    @RequestMapping(value = "/hocvien2", method = RequestMethod.GET)
    public ResponseEntity<List<HocVien>> getAllHocVien(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "1") int typeSort,
                        @RequestParam(defaultValue = "ISC09") String maKH,
                        @RequestParam(defaultValue = "MAHV") String sortBy)
    {
        List<HocVien> list = hocvienService.getAllHocVien(pageNo, pageSize, typeSort, maKH, sortBy);
 
        return new ResponseEntity<List<HocVien>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/timkiemhocvien/{id}", method = RequestMethod.GET)
    public HocVien timkiemHocvien(@PathVariable(value = "id") String id) 
    {
        return hocvienService.timkiemHocvien(id);
    }
}
