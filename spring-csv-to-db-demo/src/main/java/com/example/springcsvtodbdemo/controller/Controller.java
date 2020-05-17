package com.example.springcsvtodbdemo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springcsvtodbdemo.Dao.MyRepository;
import com.example.springcsvtodbdemo.entity.Person;

@RestController
@RequestMapping("/app/")
public class Controller {
	
	@Autowired
	private MyRepository myRepo;
	static Logger LOG = Logger.getLogger(Controller.class.getName());

	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Person> showAll() {
		LOG.info("in show all");
		return myRepo.findAll();
	}
	
	
	
	@RequestMapping(value="/file",method=RequestMethod.POST)
	public void saveCSVtoDb(@RequestPart("file") MultipartFile file) throws IOException  {
		LOG.info("inside file save to DB");
		Scanner sc=new Scanner(file.getInputStream());
		sc.nextLine();
		while(sc.hasNext()) {
			String arr[]=sc.nextLine().split(",");
			Person person=new Person(arr[0],Integer.parseInt(arr[1]),Long.parseLong(arr[2]),arr[3]);
			myRepo.save(person);
			
	}
	
}
}
