package com.kripesh.krima.service;

import java.util.List;

import com.kripesh.krima.model.Photo;
import com.kripesh.krima.model.User;

public interface PhotoService {

	List<Photo> findAll();

	List<Photo> findByUser(User user);

	Photo findByPhotoId(Long photoId);

	Photo save(Photo photo);

}
