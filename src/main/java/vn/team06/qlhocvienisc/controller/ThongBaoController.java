package vn.team06.qlhocvienisc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.team06.qlhocvienisc.entity.ThongBao;
import vn.team06.qlhocvienisc.service.ThongBaoService;

@RestController
public class ThongBaoController {
	@Autowired
	ThongBaoService thongbaoService;
	
	@RequestMapping(value = "/thongbao",
			method = RequestMethod.GET)
    public List<ThongBao> truonghoc() {
        return thongbaoService.getAll();
    }
 
    @RequestMapping(value = "/thongbao", 
    		method = RequestMethod.POST,
    		produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ThongBao createThongBao(@Valid @RequestBody ThongBao thongbao)
    {
    	System.out.print(thongbao);
        return thongbaoService.createThongBao(thongbao);
    }
 
    @RequestMapping(value = "/thongbao/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteThongBao(@PathVariable(value = "id") Integer id) 
    {
        return thongbaoService.deleteThongBao(id);
    }
 
    @RequestMapping(value = "/thongbao/{id}", method = RequestMethod.PUT)
    public ThongBao updateThongBao(@PathVariable(value = "id") Integer id, @Valid @RequestBody ThongBao thongbao) 
    {
        return thongbaoService.updateThongBao(id, thongbao);
    }
    
    @RequestMapping(value = "/thongbao2", method = RequestMethod.GET)
    public ResponseEntity<List<ThongBao>> getAllTruongHoc(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "ID") String sortBy)
    {
        List<ThongBao> list = thongbaoService.getAllThongBao(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<ThongBao>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}