package com.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/*
 
  Create table photo(
  name
  age
  image   >> 업로드한 파일명 : 우리가 업로드한건 웹서버에 특정경로로가고, db에는 파일명만 들어가는 것 
             ex. inyoung.jpg, a.jpg 
               
  )
  
 */


public class Photo {  
	//여기 멤버필드명은 image.jsp파일에 있는거랑 맞춰줘야함
	private String name;
	private int age;
	private String image;  // 이건 업로드한 파일 객체에서 별도로 추출해야함. 별도로 setter를 통해서 이름을 설정해야함 ★★
	
	///////////////////////////////////////////////////////
    //DTO 단위로 업로드할 수 잇는 코드 부분 
	//Point★
	private CommonsMultipartFile file;   //스프링이 제공함 (cos.jar파일 받아서 이전엔 썼는데)
	                                     // Point!!! 여기 변수명은  <input type="file" name="file">
	                                     // image.jsp의 변수명과 같아야함 !!!!!!!!!!!!!!!!!!!
	                                     //이건 디비에 넣는게 아니예요!!! 뽑아서 넣어야해요. 

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	///////////////////////////////////////////////////////
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	
	
	
	
}
