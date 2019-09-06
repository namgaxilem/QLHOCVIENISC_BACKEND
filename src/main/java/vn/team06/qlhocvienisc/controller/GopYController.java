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
import vn.team06.qlhocvienisc.entity.GopY;
import vn.team06.qlhocvienisc.service.GopYService;

@RestController
public class GopYController {
	@Autowired
	GopYService GopYService;
	
	@RequestMapping(value = "/gopy")
    public List<GopY> hocvien() {
        return GopYService.getAll();
    }
	
	@RequestMapping(value = "/gopy/{Id}", method = RequestMethod.GET)
    public Optional<GopY> getGopYId(@PathVariable(value = "Id") int Id ){
        return GopYService.getGopYId(Id);
    }
 
    @RequestMapping(value = "/add_gopy", method = RequestMethod.POST)
    public GopY createGopY(@Valid @RequestBody GopY gopy)
    {
        return GopYService.createGopY(gopy);
    }
 
    @RequestMapping(value = "/delete_gopy/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteGopY(@PathVariable(value = "id") Integer id) 
    {
        return GopYService.deleteGopY(id);
    }
 
    @RequestMapping(value = "/update_gopy/{id}", method = RequestMethod.PUT)
    public GopY updateGopY(@PathVariable(value = "id") Integer id, @Valid @RequestBody GopY gopy) 
    {
        return GopYService.updateGopY(id, gopy);
    }
    
    @RequestMapping(value = "/gopy2", method = RequestMethod.GET)
    public ResponseEntity<List<GopY>> getAllGopY(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "MAHV") String sortBy)
    {
        List<GopY> list = GopYService.getAllGopY(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<GopY>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
