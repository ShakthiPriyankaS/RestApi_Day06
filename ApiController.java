package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Childentity;
import com.example.demo.service.Childservice;

@RestController
public class ApiController {
		
	@Autowired
	Childservice cs;	
	@PostMapping("addchild")
	public Childentity add(@RequestBody Childentity ss) {		
		return cs.saveinfo(ss);
	}
	
	@PostMapping("addnchild")
	public List<Childentity> addndetails(@RequestBody List<Childentity> ss)
	{
		return cs.savedetails(ss);
	}
	@GetMapping("showdetails")
	public List<Childentity> show()
	{
		return cs.showinfo();
	}
	
	@GetMapping("pagimg/{pageno}/{pagesize}")
	public List<Childentity> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
	{
		return cs.getbypage(pageno, pagesize);
	}
	
	@GetMapping("/children")
	public List<Childentity> getSortedAndPagedStudents(
	        @RequestParam(name = "sortField", defaultValue = "id") String sortField,
	        @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
	        @RequestParam(name = "pageSize", required = false) Integer pageSize) {
	    
	    Page<Childentity> page = cs.sortAndPage(sortField, pageNo, pageSize);
	    return page.getContent();
	}

}
