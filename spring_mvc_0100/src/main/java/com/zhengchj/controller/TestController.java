package com.zhengchj.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RespectBinding;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhengchj.domain.Student;
import com.zhengchj.service.TestService;

@Controller
@RequestMapping("/hello")
public class TestController {
	
	private static Logger log=LoggerFactory.getLogger(TestController.class);
	
	private TestService testService=null;
	
	@Autowired
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@RequestMapping(value="/mvc",method=RequestMethod.GET)
	public String helloMvc(@RequestParam("id")String id,Model model) {
		Student student=testService.getStu(id);
		log.debug("output id={}",student.getId());
		model.addAttribute(student);
		return "home";
	}
	
	@RequestMapping(value="/mvc2/{id}",method=RequestMethod.GET)
	public String helloMvc2(@PathVariable("id")String id,Model model) {
		Student student=testService.getStu(id);
		log.debug("output id={}",student.getId());
		model.addAttribute(student);
		return "home";
	}
	
	@RequestMapping(value="/mvc3",method=RequestMethod.GET)
	public String helloMvc3(HttpServletRequest request) {
		Student student=testService.getStu((String)request.getParameter("id"));
		log.debug("output id={}",student.getId());
		request.setAttribute("student", student);
		return "home";
	}
	
	@RequestMapping(value="/addStudent",method=RequestMethod.GET)
	public String addStudent() {
		return "admin/addstudent";
	}
	
	@RequestMapping(value="/saveStudent",method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student student) {
		student.setId("444");
		log.debug("start add student!!!!!!!!!!!!!!!!!!!!!");
		log.debug(ReflectionToStringBuilder.toString(student));
		return "redirect:mvc2/"+student.getId();
	}
	
	@RequestMapping(value="/addFile",method=RequestMethod.GET)
	public String addFile(){
		return "admin/addfile";
	}
	
	@RequestMapping(value="/saveFile",method=RequestMethod.POST)
	public String saveFile(@RequestParam("file")MultipartFile file) throws IOException{
		if(!file.isEmpty()){
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("/users/user/Workspaces",System.currentTimeMillis()+file.getOriginalFilename()));
			return "admin/success";
		}else{
			return "admin/error";
		}
	}
	@RequestMapping(value="/tojson1/{id}",method=RequestMethod.GET)
	public @ResponseBody Student getStudentToJson1(@PathVariable("id") String id){
		return testService.getStu(id);
	}
	@RequestMapping(value="/tojson2/{id}",method=RequestMethod.GET)
	public ResponseEntity<Student> getStudentToJson2(@PathVariable("id") String id){
		Student student=testService.getStu(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
}
