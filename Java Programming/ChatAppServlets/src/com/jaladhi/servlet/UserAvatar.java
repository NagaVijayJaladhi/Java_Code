package com.jaladhi.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jaladhi.entity.MemberDataStructure;

public class UserAvatar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String defaultAvatar = "default.jpg";
			String separator = File.separator;
			String avatarFolder = getServletContext().getRealPath("/");
			avatarFolder = avatarFolder + "WEB-INF" + separator + "avatars" + separator;
			String avatarToDispatch;
			MemberDataStructure mds = (MemberDataStructure) request.getSession().getAttribute("member");
			if (mds == null) {
				avatarToDispatch = avatarFolder + defaultAvatar;
			} else {
				String userAvatar = "__" + mds.getUsername() + "__.jpg";
				avatarToDispatch = avatarFolder + userAvatar;
				File file = new File(avatarToDispatch);
				if (file.exists() == false) {
					avatarToDispatch = avatarFolder + defaultAvatar;
				}
			}
			BufferedImage bi = ImageIO.read(new File(avatarToDispatch));
			OutputStream out = response.getOutputStream();
			response.setContentType("image/jpeg");
			ImageIO.write(bi, "jpg", out);
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}