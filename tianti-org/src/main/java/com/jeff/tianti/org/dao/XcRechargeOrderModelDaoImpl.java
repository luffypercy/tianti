package com.jeff.tianti.org.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jeff.tianti.org.entity.XcRechargeOrderModel;
import com.jeff.tianti.org.dto.XcRechargeOrderModelQueryDTO;
/**
 * @author percy
 * @desc XcRechargeOrderModelDaoImpl类 
 * @date 2017-04-09
 */

public class XcRechargeOrderModelDaoImpl extends CustomBaseSqlDaoImpl implements XcRechargeOrderModelDaoCustom  {

    public PageModel<XcRechargeOrderModel> queryXcRechargeOrderModelPage(XcRechargeOrderModelQueryDTO xcRechargeOrderModelQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from XcRechargeOrderModel t ");
         return this.queryForPageWithParams(hql.toString(),map,xcRechargeOrderModelQueryDTO.getCurrentPage(),xcRechargeOrderModelQueryDTO.getPageSize());
    }

    public List<XcRechargeOrderModel> queryXcRechargeOrderModelList(XcRechargeOrderModelQueryDTO xcRechargeOrderModelQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from XcRechargeOrderModel t ");
         return this.queryByMapParams(hql.toString(),map);
    }


}