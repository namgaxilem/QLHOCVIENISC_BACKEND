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

import vn.team06.qlhocvienisc.entity.NguoiHuongDan;
import vn.team06.qlhocvienisc.service.NguoiHuongDanService;

@RestController
public class NguoiHuongDanController {
	@Autowired
	NguoiHuongDanService nguoihuongdanService;
	@RequestMapping(value = "/nguoihuongdan")
    public List<NguoiHuongDan> nguoihuongdan() {
        return nguoihuongdanService.getAll();
    }
 
    @RequestMapping(value = "/nguoihuongdan", method = RequestMethod.POST)
    public NguoiHuongDan createNguoihuongdan(@Valid @RequestBody NguoiHuongDan nguoihuongdan)
    {
        return nguoihuongdanService.createNguoihuongdan(nguoihuongdan);
    }
 
    @RequestMapping(value = "/nguoihuongdan/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteNguoihuongdan(@PathVariable(value = "id") int id) 
    {
        return nguoihuongdanService.deleteNguoihuongdan(id);
    }
 
    @RequestMapping(value = "/nguoihuongdan/{id}", method = RequestMethod.PUT)
    public NguoiHuongDan updateNguoihuongdan(@PathVariable(value = "id") int id, @Valid @RequestBody NguoiHuongDan nguoihuongdan) 
    {
        return nguoihuongdanService.updateNguoihuongdan(id, nguoihuongdan);
    }
}
