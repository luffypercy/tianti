package com.jeff.tianti.org.dao;

import com.jeff.tianti.org.dto.XcUserModelQueryDTO;
import com.jeff.tianti.org.entity.XcUserModel;
import com.jeff.tianti.common.dao.CommonDao;
import com.jeff.tianti.common.entity.PageModel;

/**
 * @author percy
 * @desc XcUserModelDao接口 
 * @date 2017-04-09
 */
public interface XcUserModelDao extends XcUserModelDaoCustom,CommonDao<XcUserModel,String>{
	public PageModel<XcUserModel> queryUserPage(XcUserModelQueryDTO xcUserModelQueryDTO);
}