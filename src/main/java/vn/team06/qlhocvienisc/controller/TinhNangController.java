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

import vn.team06.qlhocvienisc.entity.TinhNang;
import vn.team06.qlhocvienisc.service.TinhNangService;

@RestController
public class TinhNangController {
	@Autowired
	TinhNangService TinhNangService;
	
	@RequestMapping(value = "/tinhnang")
    public List<TinhNang> tinhnang() {
        return TinhNangService.getAll();
    }
	
	@RequestMapping(value = "/tinhnang/{Id}", method = RequestMethod.GET)
    public Optional<TinhNang> getTinhNangId(@PathVariable(value = "Id") int Id ){
        return TinhNangService.getTinhNangId(Id);
    }
 
    @RequestMapping(value = "/add_tinhnang", method = RequestMethod.POST)
    public TinhNang createTinhNang(@Valid @RequestBody TinhNang tinhnang)
    {
        return TinhNangService.createTinhNang(tinhnang);
    }
 
    @RequestMapping(value = "/delete_tinhnang/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTinhNang(@PathVariable(value = "id") Integer id) 
    {
        return TinhNangService.deleteTinhNang(id);
    }
 
    @RequestMapping(value = "/update_tinhnang/{id}", method = RequestMethod.PUT)
    public TinhNang updateTinhNanng(@PathVariable(value = "id") Integer id, @Valid @RequestBody TinhNang tinhnang) 
    {
        return TinhNangService.updateTinhNang(id, tinhnang);
    }
    
    @RequestMapping(value = "/tinhnang2", method = RequestMethod.GET)
    public ResponseEntity<List<TinhNang>> getAllTinhNang(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "MAHV") String sortBy)
    {
        List<TinhNang> list = TinhNangService.getAllTinhNang(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<TinhNang>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
