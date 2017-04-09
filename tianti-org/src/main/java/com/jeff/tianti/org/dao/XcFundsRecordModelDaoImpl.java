package com.jeff.tianti.org.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jeff.tianti.org.entity.XcFundsRecordModel;
import com.jeff.tianti.org.dto.XcFundsRecordModelQueryDTO;
/**
 * @author percy
 * @desc XcFundsRecordModelDaoImpl类 
 * @date 2017-04-09
 */

public class XcFundsRecordModelDaoImpl extends CustomBaseSqlDaoImpl implements XcFundsRecordModelDaoCustom  {

    public PageModel<XcFundsRecordModel> queryXcFundsRecordModelPage(XcFundsRecordModelQueryDTO xcFundsRecordModelQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from XcFundsRecordModel t ");
         return this.queryForPageWithParams(hql.toString(),map,xcFundsRecordModelQueryDTO.getCurrentPage(),xcFundsRecordModelQueryDTO.getPageSize());
    }

    public List<XcFundsRecordModel> queryXcFundsRecordModelList(XcFundsRecordModelQueryDTO xcFundsRecordModelQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from XcFundsRecordModel t ");
         return this.queryByMapParams(hql.toString(),map);
    }


}