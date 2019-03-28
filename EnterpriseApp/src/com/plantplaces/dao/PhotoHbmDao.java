package com.plantplaces.dao;

import javax.inject.Named;

import org.hibernate.Session;

import com.plantplaces.dto.Photo;

@Named
public class PhotoHbmDao extends PlantPlacesDao<Photo> implements IPhotoDao  {

	/* (non-Javadoc)
	 * @see com.plantplaces.dao.IPhotoDao#insert(org.hibernate.Session, com.plantplaces.dto.Photo)
	 */
	@Override
	public void insert(Session session, Photo dto) throws Exception {
		session.save(dto);
	}
	
	
	

}
