package com.yong.blog.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.swing.filechooser.FileSystemView;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yong.blog.dto.ImageDto;
import com.yong.blog.dto.ResponseDto;
import com.yong.blog.model.MyPhoto;
import com.yong.blog.service.MyphotoService;

@RestController
public class MyphotoAPIController {

	@Autowired
	private MyphotoService myphotoservice;

	@PostMapping("/api/myphoto/write")
	public ResponseDto<Integer> writeMyphoto(@RequestBody ImageDto imageData) throws IOException {
		System.out.println("api" + imageData);

		Map<String, Object> result = new HashMap<>();

		String fileBase64 = imageData.getFileBase64();
		// 파일이 업로드되지 않았거나 사이즈가 큰 경우를 체크합니다.
		// 사이즈는 일반 바이트에서 1.33을 곱하면 BASE64 사이즈가 대략 나옵니다.
//		    if(fileBase64 == null || fileBase64.equals("")) {
//		        result.put("isFileInserted", false);
//		        result.put("uploadStatus", "FileIsNull");
//		        return result;
//		    } else if(fileBase64.length() > 400000) {
//		        result.put("isFileInserted", false);
//		        result.put("uploadStatus", "FileIsTooBig");
//		        return result;
//		    }

		try {
			String fileName = imageData.getFileName(); // 파일네임은 서버에서 결정하거나 JSON에서 받아옵니다.
			// 저장할 파일 경로를 지정합니다.

			File pathsAsFile = new File(FileSystemView.getFileSystemView().getHomeDirectory() + "/app/resources/"
					+ Integer.toString(imageData.getId()) + "/");

			if (!Files.exists(Paths.get(FileSystemView.getFileSystemView().getHomeDirectory() + "/app/resources/"
					+ Integer.toString(imageData.getId())))) {
				pathsAsFile.mkdir();

				saveImageToMyPath(fileBase64, imageData);
				saveImageFileToDB(fileName, imageData);
				return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
			} else {

				saveImageToMyPath(fileBase64, imageData);
				saveImageFileToDB(fileName, imageData);

				return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseDto<Integer>(HttpStatus.BAD_REQUEST.value(), 0);
	}

	public void saveImageToMyPath(String fileBase64, ImageDto imageData) throws IOException {
		String fileName = imageData.getFileName();

		File file = new File(FileSystemView.getFileSystemView().getHomeDirectory() + "/app/resources/"
				+ Integer.toString(imageData.getId()) + "/" + fileName);
		Base64.Decoder decoder = Base64.getDecoder();

		byte[] decodedBytes = decoder.decode(fileBase64.split(",")[1]);
//		System.out.println("decodedBytes" + decodedBytes);

		try {
			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(decodedBytes);
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void saveImageFileToDB(String fileName, ImageDto imageData) {
		MyPhoto myphoto = new MyPhoto();
		myphoto.setPhoto(fileName);
		myphoto.setUserid(imageData.getId());
		myphoto.setContent(imageData.getContent());
		myphotoservice.writeMyphoto(myphoto);
	}
	
	public void modifyImageFileToDB(String fileName, ImageDto imageData) {
		MyPhoto myphoto = new MyPhoto();
		myphoto.setId(imageData.getId());
		myphoto.setPhoto(fileName);
		myphoto.setUserid(imageData.getId());
		myphoto.setContent(imageData.getContent());
		myphotoservice.modifyMyPhoto(myphoto);
	}
	
	@PutMapping("/api/myphoto/modify")
	public ResponseDto<Integer> modifyMyPhoto(@RequestBody ImageDto imageData) throws Exception {
		
		String fileBase64 = imageData.getFileBase64();
		
		try {
			String fileName = imageData.getFileName(); // 파일네임은 서버에서 결정하거나 JSON에서 받아옵니다.
			// 저장할 파일 경로를 지정합니다.

			File pathsAsFile = new File(FileSystemView.getFileSystemView().getHomeDirectory() + "/app/resources/"
					+ Integer.toString(imageData.getId()) + "/");

			if (!Files.exists(Paths.get(FileSystemView.getFileSystemView().getHomeDirectory() + "/app/resources/"
					+ Integer.toString(imageData.getId())))) {
				pathsAsFile.mkdir();
				System.out.println("id"+imageData.getId());
				saveImageToMyPath(fileBase64, imageData);
				
				modifyImageFileToDB(fileName,imageData);
				
				return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
			} else {

				saveImageToMyPath(fileBase64, imageData);
				modifyImageFileToDB(fileName,imageData);

				return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
}
