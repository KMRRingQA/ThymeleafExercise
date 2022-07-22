package com.example.demo.services;

import com.example.demo.dtos.TopicDto;
import com.example.demo.entities.Topic;
import com.example.demo.repositories.TopicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {
	
	public TopicRepository repo;

	ModelMapper mapper = new ModelMapper();

	private TopicDto mapToDTO(Topic topic) {
		return this.mapper.map(topic, TopicDto.class);
	}

	public TopicService(TopicRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<TopicDto> findAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).sorted(Comparator.comparing(TopicDto::getSequence)).collect(Collectors.toList());
	}
}

