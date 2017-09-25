package com.wy.action;

import java.io.File;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.wy.entity.Album;
import com.wy.entity.User;
import com.wy.service.AlbumService;
import com.wy.service.UserService;

public class AlbumAction {
	private Album album;
	private File myfile;
	private String myfileFileName;
	private String myfileContentType;
	private UserService userService;
	private AlbumService albumService;
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public File getMyfile() {
		return myfile;
	}
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	
	public String getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	public String getMyfileContentType() {
		return myfileContentType;
	}
	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}
	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public AlbumService getAlbumService() {
		return albumService;
	}
	@Resource
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}
	/**
	 * upload作用：将上传文件存起来，将上传文件信息(照片名称，封面地址)存入到数据库
	 * @return
	 * @throws IOException
	 */
	public String upload() throws IOException{
		String realpath=ServletActionContext.getServletContext().getRealPath(myfileFileName);
		if(myfile!=null){
			File savefile=new File(new File(realpath),myfileFileName);
			if(!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(myfile, savefile);
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		album.setCover(request.getContextPath()+"/images/"+myfileFileName);
		User user=(User) ServletActionContext.getContext().getSession().get("USER");
		user=userService.get(user);
		album.setUser(user);
		albumService.add(album);
		return "album";
	}
}
