package com.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.model.User;

public class UserService {
		
	List<User> list =  new ArrayList<>();
	UserDao userDao = new UserDao();
	
	
	public boolean login(User user) throws IOException{
		
		try {
			list =  userDao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ж��û����������Ƿ���ȷ
		if(!list.isEmpty()){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getUserName().equals(user.getUserName())&&list.get(i).getPassWord().equals(user.getPassWord())){
					 Integer str = list.get(i).getUserId();
					String s = String.valueOf(str);
					 File file;//�����ļ���
				     FileOutputStream stream = null;//new�ļ���
				     try {
				    file = new File("D:/Id.txt");
				    stream = new FileOutputStream (file);//���ļ��з����ļ�����
				   if (!file.exists()) { 
				     file.createNewFile();
				      }
				    byte[] contentInBytes = s.getBytes();//ת�����ֽ���
    			    stream.write(contentInBytes);//д��
				    stream.flush(); //д��֮��ˢ��
				    stream.close();//�ر���
				  } catch (FileNotFoundException e) {
				   e.printStackTrace();
				  }
					return true;	
				}
			}
		}
		return false;
	}

	public boolean register(User user) throws SQLException {
		boolean b = false,c=true;
		try {
			list =  userDao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ж��û����Ƿ�Ψһ
		if(list.isEmpty()){
		 b = UserDao.register(user);
		}else{
			for(int i=0;i<list.size();i++){
				if(list.get(i).getUserName().equals(user.getUserName())){
					c=false;
					b=false;
				}
			}
			if(c==true){
				b = UserDao.register(user);
			}
		}
		 if(c==true){
			 return b;
		 }else{
			return c;
		}
		
	}
}
