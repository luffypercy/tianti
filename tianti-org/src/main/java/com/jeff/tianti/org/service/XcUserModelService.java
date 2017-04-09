package com.jeff.tianti.org.service;

import com.jeff.tianti.org.entity.User;
import com.jeff.tianti.org.entity.XcUserModel;
import com.jeff.tianti.org.dao.XcUserModelDao;
import com.jeff.tianti.org.dto.UserQueryDTO;
import com.jeff.tianti.org.dto.XcUserModelQueryDTO;
import com.jeff.tianti.common.service.CommonService;
import com.jeff.tianti.common.entity.PageModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author percy
 * @desc XcUserModelService类 
 * @date 2017-04-09
 */
@Service
public class XcUserModelService extends CommonService< XcUserModel,String >  {

    @Autowired
    private XcUserModelDao xcUserModelDao;

    @Autowired
    public void setXcUserModelDao(XcUserModelDao xcUserModelDao){
      super.setCommonDao(xcUserModelDao);
    }

    public PageModel<XcUserModel> queryXcUserModelPage(XcUserModelQueryDTO xcUserModelQueryDTO){
           return this.xcUserModelDao.queryXcUserModelPage(xcUserModelQueryDTO);
    }

    public List<XcUserModel> queryXcUserModelList(XcUserModelQueryDTO xcUserModelQueryDTO){
           return this.xcUserModelDao.queryXcUserModelList(xcUserModelQueryDTO);
    }

    public List<XcUserModel> updateStatus(String[] ids, Integer status){
		List<XcUserModel> users = new ArrayList<XcUserModel>();
		if(ids != null){
			for(String id : ids){
				XcUserModel user = this.find(id);
				user.setStatus(status);
				this.update(user);
				users.add(user);
			}
		}
		return users;
	}
    /**
	 * 根据用户信息查询分页信息
	 * @param userQueryDTO
	 * @return
	 */
	public PageModel<XcUserModel> queryUserPage(XcUserModelQueryDTO userQueryDTO){
		return this.xcUserModelDao.queryUserPage(userQueryDTO);
	}
}