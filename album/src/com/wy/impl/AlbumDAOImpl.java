package com.wy.impl;

import javax.annotation.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.wy.dao.AlbumDAO;
import com.wy.entity.Album;

@Component(value="albumDAO")
public class AlbumDAOImpl implements AlbumDAO{
	
	private HibernateTemplate hibernateTemplate;
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

    @Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public void save(Album album) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(album);
	}
}
