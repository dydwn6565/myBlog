package com.yong.blog.dto;

import javax.persistence.Column;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageDto {

	private int id;
	
	private String fileName;
	
	private String fileBase64;

	private String content;
	
}
