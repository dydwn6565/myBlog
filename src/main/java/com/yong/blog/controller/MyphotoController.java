package com.yong.blog.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
//import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yong.blog.model.MyPhoto;
import com.yong.blog.service.MyphotoService;

@Controller
public class MyphotoController {
	
	@Autowired
	MyphotoService myphotoservice;
	
	@GetMapping("/myphoto")
	public String myphoto(Model model, @PageableDefault(size=4,sort="id",direction=Sort.Direction.DESC) Pageable pageable) throws IOException {
//		System.out.println(myphotoservice.readyMyphoto().get(0).getPhoto());
		  List<MyPhoto> postList = new ArrayList<MyPhoto>();
		  Base64 base64;  
		for(MyPhoto myphoto:myphotoservice.readyMyphoto() ) {
			
			int index = myphotoservice.readyMyphoto().indexOf(myphoto);
			String imageId = Integer.toString(myphotoservice.readyMyphoto().get(index).getUserid());
			String photoName = myphotoservice.readyMyphoto().get(index).getPhoto();
		
			String fileName ="c:\\Users\\Lee yong Ju\\Desktop\\app\\resources\\"+imageId+"\\"+photoName;
			byte[] fileContent = FileUtils.readFileToByteArray(new File(fileName));
			String encodedString = Base64.getEncoder().encodeToString(fileContent);
			System.out.println("encodedString"+encodedString);
			
			MyPhoto pegeableMyphoto = new MyPhoto();
			pegeableMyphoto.setId(myphoto.getId());
			pegeableMyphoto.setContent(myphoto.getContent());
			pegeableMyphoto.setPhoto(encodedString);
			pegeableMyphoto.setUserid(myphoto.getUserid());
			postList.add(pegeableMyphoto);
		}
		

		Page<MyPhoto> page = new PageImpl(postList);
//		System.out.println("page"+page);
		model.addAttribute("myphoto",page);
		
//		model.addAttribute("myphoto",myphotoservice.readyMyphoto(pageable));
		
		return "myphoto/myphoto";
	}
	
	@GetMapping("/myphoto/write")
	public String myphotoWrite() {
		return "myphoto/write";
	}
	
}
