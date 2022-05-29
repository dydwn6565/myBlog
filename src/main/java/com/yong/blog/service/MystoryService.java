package com.yong.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yong.blog.model.MyStory;
import com.yong.blog.repository.MystoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MystoryService {

	private final MystoryRepository mystoryrepository;

	@Transactional
	public void writeMystory(MyStory mystory) {
		System.out.println("mystory" + mystory);
		mystoryrepository.save(mystory);
	}

	@Transactional(readOnly = true)
	public Page<MyStory> readyMystory(Pageable pageable) {

		return mystoryrepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public MyStory readyOneMystory(int id) {

		return mystoryrepository.findById(id).orElseThrow();

	}

	@Transactional
	public void modifyMystory(int id, MyStory requestedMystory) {

		MyStory mystory = mystoryrepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("can not find id");
		});

		mystory.setTitle(requestedMystory.getTitle());
		mystory.setContent(requestedMystory.getContent());

	}

	@Transactional
	public void deleteMystory(int id) {
		mystoryrepository.deleteById(id);

	}
}
