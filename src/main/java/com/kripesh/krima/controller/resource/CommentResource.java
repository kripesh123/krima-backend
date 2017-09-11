package com.kripesh.krima.controller.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kripesh.krima.model.Comment;
import com.kripesh.krima.model.Photo;
import com.kripesh.krima.service.CommentService;
import com.kripesh.krima.service.PhotoService;

@RestController
@RequestMapping("/rest")
public class CommentResource {

	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/comment/add" , method= RequestMethod.POST)
	public void addComment(@RequestBody Comment comment){
		Photo photo = photoService.findByPhotoId(comment.getPhotoId());
		List<Comment> commentList = commentService.findByPhotoId(photo.getPhotoId());
		comment.setPhoto(photo);
		commentService.save(comment);
	}
}
