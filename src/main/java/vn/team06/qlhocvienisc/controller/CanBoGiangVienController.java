package vn.team06.qlhocvienisc.controller;

import java.util.List;
import java.util.Optional;

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

import vn.team06.qlhocvienisc.entity.CanBoGiangVien;
import vn.team06.qlhocvienisc.service.CanBoGiangVienService;

@RestController
public class CanBoGiangVienController {
	@Autowired
	CanBoGiangVienService CanBoGiangVienService;
	
	@RequestMapping(value = "/canbogiangvien")
    public List<CanBoGiangVien> canbogiangvien() {
        return CanBoGiangVienService.getAll();
    }
	@RequestMapping(value = "/canbogiangvien/{Id}", method = RequestMethod.GET)
    public Optional<CanBoGiangVien> getCanBoGiangVienId(@PathVariable(value = "Id") String Id ){
        return CanBoGiangVienService.getCanBoGiangVienId(Id);
    }
	
    @RequestMapping(value = "/add_canbogiangvien", method = RequestMethod.POST)
    public CanBoGiangVien createCanBoGiangVien(@Valid @RequestBody CanBoGiangVien canbogiangvien)
    {
        return CanBoGiangVienService.createCanBoGiangVien(canbogiangvien);
    }
    
    @RequestMapping(value = "/delete_canbogiangvien/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCanBoGiangVien(@PathVariable(value = "id") String id) 
    {
        return CanBoGiangVienService.deleteCanBoGiangVien(id);
    }
    
    @RequestMapping(value = "/update_canbogiangvien/{id}", method = RequestMethod.PUT)
    public CanBoGiangVien updateCanBoGiangVien(@PathVariable(value = "id") String id, @Valid @RequestBody CanBoGiangVien canbogiangvien) 
    {
        return CanBoGiangVienService.updateCanBoGiangVien(id, canbogiangvien);
    }
    
    @RequestMapping(value = "/canbogiangvien2", method = RequestMethod.GET)
    public ResponseEntity<List<CanBoGiangVien>> getAllCanBoGiangVien(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "1") int typeSort,
                        @RequestParam(defaultValue = "MACBGV") String sortBy)
    {
        List<CanBoGiangVien> list = CanBoGiangVienService.getAllCanBoGiangVien(pageNo, pageSize,typeSort , sortBy);
 
        return new ResponseEntity<List<CanBoGiangVien>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
