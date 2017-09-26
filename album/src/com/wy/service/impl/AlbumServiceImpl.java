package com.wy.service.impl;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wy.dao.AlbumDAO;
import com.wy.entity.Album;
import com.wy.service.AlbumService;

@Component(value="albumService")
@Scope("singleton")
public class AlbumServiceImpl implements AlbumService{
	
	AlbumDAO albumDAO;

	public AlbumDAO getAlbumDAO() {
		return albumDAO;
	}

	@Resource
	public void setAlbumDAO(AlbumDAO albumDAO) {
		this.albumDAO = albumDAO;
	}


	@Override
	public void add(Album album) {
		// TODO Auto-generated method stub
		albumDAO.save(album);
	}
}
