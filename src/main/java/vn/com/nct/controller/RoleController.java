package vn.com.nct.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.com.nct.model.Roles;
import vn.com.nct.model.response.RoleResponse;
import vn.com.nct.model.response.SelectResponse;
import vn.com.nct.service.objectservice.ObjectService;

@RestController
public class RoleController {
	
	@Autowired
	private ObjectService<Roles, RoleResponse> roleService;
	
	@RequestMapping(value = "manager/role/select", method = RequestMethod.GET)
	public ResponseEntity<List<SelectResponse>> getRoleForSelect(){
		List<RoleResponse> lis = roleService.parseAll(roleService.getAll());
		return new ResponseEntity<List<SelectResponse>>(this.parseSelect(lis), HttpStatus.OK);
	}
	
	private List<SelectResponse> parseSelect(List<RoleResponse> lis){
		List<SelectResponse> l = new ArrayList<>();
		
		for (int i = 0; i < lis.size(); i++) {
			l.add(new SelectResponse(lis.get(i).getId(),lis.get(i).getRole()));
		}
		
		return l;
	}
}
