package com.kripesh.krima.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kripesh.krima.model.Photo;
import com.kripesh.krima.model.User;

@Repository
public interface PhotoDao extends CrudRepository<Photo, Long>{

	List<Photo> findAllByOrderByPhotoIdDesc();
	
	List<Photo> findByUser(User user);
	
	Photo findByPhotoId(Long photoId);
	
	Photo save(Photo photo);
	
	
}
