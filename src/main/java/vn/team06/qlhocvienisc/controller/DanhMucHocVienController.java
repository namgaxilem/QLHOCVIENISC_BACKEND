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

import vn.team06.qlhocvienisc.entity.DanhMucHocVien;
import vn.team06.qlhocvienisc.service.DanhMucHocVienService;

@RestController
public class DanhMucHocVienController {
	@Autowired
	DanhMucHocVienService danhmuchocvienService;
	@RequestMapping(value = "/danhmuchocvien")
    public List<DanhMucHocVien> danhmuchocvien() {
        return danhmuchocvienService.getAll();
    }
 
    @RequestMapping(value = "/danhmuchocvien", method = RequestMethod.POST)
    public DanhMucHocVien createDanhmuchocvien(@Valid @RequestBody DanhMucHocVien danhmuchocvien)
    {
        return danhmuchocvienService.createDanhmuchocvien(danhmuchocvien);
    }
 
    @RequestMapping(value = "/danhmuchocvien/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDanhmuchocvien(@PathVariable(value = "id") int id) 
    {
        return danhmuchocvienService.deleteDanhmuchocvien(id);
    }
 
    @RequestMapping(value = "/danhmuchocvien/{id}", method = RequestMethod.PUT)
    public DanhMucHocVien updateDanhmuchocvien(@PathVariable(value = "id") int id, @Valid @RequestBody DanhMucHocVien danhmuchocvien) 
    {
        return danhmuchocvienService.updateDanhmuchocvien(id, danhmuchocvien);
    }
}
