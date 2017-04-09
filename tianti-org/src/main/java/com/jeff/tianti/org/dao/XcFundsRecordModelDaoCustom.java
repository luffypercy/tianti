package com.jeff.tianti.org.dao;

import com.jeff.tianti.common.entity.PageModel;
import java.util.List;
import com.jeff.tianti.org.entity.XcFundsRecordModel;
import com.jeff.tianti.org.dto.XcFundsRecordModelQueryDTO;
/**
 * @author percy
 * @desc XcFundsRecordModelDaoCustom接口 
 * @date 2017-04-09
 */
public interface XcFundsRecordModelDaoCustom {

      PageModel<XcFundsRecordModel> queryXcFundsRecordModelPage(XcFundsRecordModelQueryDTO xcFundsRecordModelQueryDTO);

      List<XcFundsRecordModel> queryXcFundsRecordModelList(XcFundsRecordModelQueryDTO xcFundsRecordModelQueryDTO);



}