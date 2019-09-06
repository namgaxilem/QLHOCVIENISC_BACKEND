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

import vn.team06.qlhocvienisc.entity.DaoTao;
import vn.team06.qlhocvienisc.entity.TruongHoc;
import vn.team06.qlhocvienisc.repository.DaoTaoRepository;
import vn.team06.qlhocvienisc.service.DaoTaoService;

@RestController
public class DaoTaoController {
	@Autowired
	DaoTaoService daotaoService;
	
	@Autowired
	DaoTaoRepository daotaoRepository;
	
	@RequestMapping(value = "/daotao")
    public List<DaoTao> daotao() {
        return daotaoService.getAll();
    }
 
    @RequestMapping(value = "/daotao", method = RequestMethod.POST)
    public DaoTao createTruong(@Valid @RequestBody DaoTao daotao)
    {
        return daotaoService.createDaoTao(daotao);
    }
 
    @RequestMapping(value = "/daotao/{id}/{id2}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDaoTao(@PathVariable(value = "id") String id, @PathVariable(value = "id2") Integer id2) 
    {
		return daotaoService.deleteDaoTao(id, id2);
    }
    
    @RequestMapping(value = "/daotao/{id}/{id2}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDaoTao(@PathVariable(value = "id") String id, @PathVariable(value = "id2") Integer id2, @Valid @RequestBody DaoTao daotao)
    {
        return daotaoService.updateDaoTao(id, id2, daotao);
    }
    
    @RequestMapping(value = "/daotao2", method = RequestMethod.GET)
    public ResponseEntity<List<DaoTao>> getAllDaoTao(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "CHUYENNGANH_ID") String sortBy)
    {
        List<DaoTao> list = daotaoService.getAllDaoTao(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<DaoTao>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
