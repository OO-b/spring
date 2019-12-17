package com.controller;


import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.model.Photo;



@Controller
@RequestMapping("/image/upload.do")    //Get, Post 나눠쓸거예요. 
public class ImageController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "image/image";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(Photo photo, HttpServletRequest request) throws IOException {  // request는 realpath로 뽑기위해 
		/*
		 
		  1. Photo DTO 타입으로 받기 
		  1.1 자동화 <input 태그 name속성 값이 dto Photo의 memberfield명과 같다.
		  1.2 submit(Photo photo 자동화 되는 작업
		  Photo photo = new Photo();
		  photo.setName("홍길동") 
		  photo.setAge(100)
		  Photo.setImage("업로드한 파일명"); // 자동주입 안돼요. 
		    파일명은 CommonsMultipartFile file (dto)얘가 가지고 있어요. 
		    그래서 CommonsMultipartFile file 에서 파일의 이름을 추출해서 
		  Photo.setImage() 은 함수의 로직으로 처리 
		  
		  Dto 클래스의 내용 
		  ------------------------------------------ 
		  private CommonsMultipartFile file;
		  public CommonsMultipartFile getFile() {return file;}
		  public void setFile(CommonsMultipartFile file) {this.file = file;}  
		  ------------------------------------------
		   별도의 추가 작업 : 파일의 이름 뽑아내고, 파일의 크기 추출, 원본이름   ★별도로 해야해요.
		   코드작업 해볼게요! 
		   
		 */
		
		CommonsMultipartFile imagefile = photo.getFile();
		
		System.out.println("파일이름 :" + imagefile.getName());
		System.out.println("파일타입 : "+ imagefile.getContentType());
		System.out.println("파일오리지널네임 : " + imagefile.getOriginalFilename());
		System.out.println("파일크기 : " +imagefile.getBytes());
		System.out.println("파일길이 : " +imagefile.getBytes().length);
		
		
		//POINT 
		//추출해준 이름을 DB에 넣는 작업을 해야해요! 그래야 DB에 들어가요. 
		
		photo.setImage(imagefile.getName());
		
		
		//실 파일 업로드 (write 하는 작업 : 웹서버에 특정 경로에 File Write)/////////////////////////
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload");
		
		String fpath = path +"\\" + filename;
		//C:\smartWeb...\a.jpg
		
		/*
		try(FileOutputStream fs = new FileOutputStream(fpath)) {
			fs.write(imagefile.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/                                                                                                                                                                                                                                                                                                                                                                                              
		FileOutputStream fs = new FileOutputStream(fpath); //파일이 없으면 자동으로 파일 만듦 
		fs.write(imagefile.getBytes());
		fs.close();
		///////////////////////////////////////////////////////////////////////////////
		
		
		/* 만약 DB작업이 필요하다면, 
		BoardDao dao = new BoardDao();
		dao.insert(photo);
		*/		
		return "image/image";
		
	}
	
}

 