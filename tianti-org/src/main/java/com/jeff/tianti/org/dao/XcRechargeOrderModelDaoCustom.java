package com.jeff.tianti.org.dao;

import com.jeff.tianti.common.entity.PageModel;
import java.util.List;
import com.jeff.tianti.org.entity.XcRechargeOrderModel;
import com.jeff.tianti.org.dto.XcRechargeOrderModelQueryDTO;
/**
 * @author percy
 * @desc XcRechargeOrderModelDaoCustom接口 
 * @date 2017-04-09
 */
public interface XcRechargeOrderModelDaoCustom {

      PageModel<XcRechargeOrderModel> queryXcRechargeOrderModelPage(XcRechargeOrderModelQueryDTO xcRechargeOrderModelQueryDTO);

      List<XcRechargeOrderModel> queryXcRechargeOrderModelList(XcRechargeOrderModelQueryDTO xcRechargeOrderModelQueryDTO);



}