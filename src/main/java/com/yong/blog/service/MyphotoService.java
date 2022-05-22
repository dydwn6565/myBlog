package com.yong.blog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yong.blog.model.MyPhoto;
import com.yong.blog.repository.MyphotoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyphotoService {
	
	
	private final MyphotoRepository myphotorespository;
	
	@Transactional
	public void writeMyphoto(MyPhoto myphoto) {
		System.out.println("myphoto"+myphoto);
		myphotorespository.save(myphoto);
	}
}
