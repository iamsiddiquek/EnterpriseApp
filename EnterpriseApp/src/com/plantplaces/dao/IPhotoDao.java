package com.plantplaces.dao;

import org.hibernate.Session;

import com.plantplaces.dto.Photo;

public interface IPhotoDao {

	public void insert(Session session, Photo dto) throws Exception;

}