package com.yong.blog.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yong.blog.model.MyPhoto;
import com.yong.blog.model.MyStory;
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
	
	@Transactional( readOnly = true)
	public List<MyPhoto> readyMyphoto() {
		
		return myphotorespository.findAll();
	}
//	@Transactional( readOnly = true)
//	public Page<MyPhoto> readyMyphoto(Pageable pageable) {
//		
//		return myphotorespository.findAll(pageable);
//	}
	
}
