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
import org.springframework.web.bind.annotation.RestController;

import vn.team06.qlhocvienisc.entity.ThoiKhoaBieu;
import vn.team06.qlhocvienisc.service.ThoiKhoaBieuService;

@RestController
public class ThoiKhoaBieuController {
	@Autowired
	ThoiKhoaBieuService thoikhoabieuService;
	
	@RequestMapping(value = "/thoikhoabieu",
			method = RequestMethod.GET)
    public List<ThoiKhoaBieu> truonghoc() {
        return thoikhoabieuService.getAll();
    }
 
    @RequestMapping(value = "/thoikhoabieu", 
    		method = RequestMethod.POST,
    		produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
    public ThoiKhoaBieu createThoiKhoaBieu(@Valid @RequestBody ThoiKhoaBieu thoikhoabieu)
    {
        return thoikhoabieuService.createThoiKhoaBieu(thoikhoabieu);
    }
 
    @RequestMapping(value = "/thoikhoabieu/{id}",
    		method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteThoiKhoaBieu(@PathVariable(value = "id") Integer id) 
    {
        return thoikhoabieuService.deleteThoiKhoaBieu(id);
    }
 
    @RequestMapping(value = "/thoikhoabieu/{id}", 
    		method = RequestMethod.PUT)
    public ThoiKhoaBieu updateThoiKhoaBieu(@PathVariable(value = "id") Integer id, @Valid @RequestBody ThoiKhoaBieu thoikhoabieu) 
    {
        return thoikhoabieuService.updateThoiKhoaBieu(id, thoikhoabieu);
    }
    
    @RequestMapping(value = "/thoikhoabieu2",
    		method = RequestMethod.GET)
    public ResponseEntity<List<ThoiKhoaBieu>> getAllThoiKhoaBieu(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "ID") String sortBy)
    {
        List<ThoiKhoaBieu> list = thoikhoabieuService.getAllThoiKhoaBieu(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<ThoiKhoaBieu>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}