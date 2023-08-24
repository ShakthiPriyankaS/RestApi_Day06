package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Childentity;
import com.example.demo.repository.Childrepo;

@Service
public class Childservice {
	
	@Autowired
	Childrepo cr;
	
	public Childentity saveinfo(Childentity ss)
	{
		return cr.save(ss);
	}
	
	public List<Childentity> savedetails(List<Childentity> ss){
		
		return (List<Childentity>)cr.saveAll(ss);
	}
  
	public List<Childentity> showinfo()
	{
	      return cr.findAll();
	}
	
	public List<Childentity> getbypage(int pageno,int pagesize)
	{
		Page<Childentity>  p = cr.findAll(PageRequest.of(pageno, pagesize));
		return p.getContent();
	}
	public Page<Childentity> sortAndPage(String sortField, int pageNo, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, sortField);
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);

        return cr.findAll(pageRequest);
    }

}
