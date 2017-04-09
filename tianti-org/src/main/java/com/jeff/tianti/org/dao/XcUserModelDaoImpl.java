package com.jeff.tianti.org.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.jeff.tianti.org.entity.User;
import com.jeff.tianti.org.entity.XcUserModel;
import com.jeff.tianti.org.dto.UserQueryDTO;
import com.jeff.tianti.org.dto.XcUserModelQueryDTO;
/**
 * @author percy
 * @desc XcUserModelDaoImpl类 
 * @date 2017-04-09
 */

public class XcUserModelDaoImpl extends CustomBaseSqlDaoImpl implements XcUserModelDaoCustom  {

    public PageModel<XcUserModel> queryXcUserModelPage(XcUserModelQueryDTO xcUserModelQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from XcUserModel t ");
         return this.queryForPageWithParams(hql.toString(),map,xcUserModelQueryDTO.getCurrentPage(),xcUserModelQueryDTO.getPageSize());
    }

    public List<XcUserModel> queryXcUserModelList(XcUserModelQueryDTO xcUserModelQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from XcUserModel t ");
         return this.queryByMapParams(hql.toString(),map);
    }
    
    /**
	 * 根据用户信息查询分页信息
	 * @param userQueryDTO
	 * @return
	 */
	public PageModel<XcUserModel> queryUserPage(XcUserModelQueryDTO xcUserModelQueryDTO){
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuilder hql = new StringBuilder();
		hql.append(" select t from XcUserModel t where 1=1 ");
		if(StringUtils.isNotBlank(xcUserModelQueryDTO.getMobile())){
			hql.append(" and t.mobile like :mobile ");
			params.put("mobile", "%"+xcUserModelQueryDTO.getMobile()+"%");
		}
		hql.append(" order by t.createDate desc ");
		return this.queryForPageWithParams(hql.toString(), params, xcUserModelQueryDTO.getCurrentPage(), xcUserModelQueryDTO.getPageSize());
	}


}