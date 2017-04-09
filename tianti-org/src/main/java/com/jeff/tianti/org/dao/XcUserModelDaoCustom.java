package com.jeff.tianti.org.dao;

import com.jeff.tianti.common.entity.PageModel;
import java.util.List;
import com.jeff.tianti.org.entity.XcUserModel;
import com.jeff.tianti.org.dto.XcUserModelQueryDTO;
/**
 * @author percy
 * @desc XcUserModelDaoCustom接口 
 * @date 2017-04-09
 */
public interface XcUserModelDaoCustom {

      PageModel<XcUserModel> queryXcUserModelPage(XcUserModelQueryDTO xcUserModelQueryDTO);

      List<XcUserModel> queryXcUserModelList(XcUserModelQueryDTO xcUserModelQueryDTO);



}