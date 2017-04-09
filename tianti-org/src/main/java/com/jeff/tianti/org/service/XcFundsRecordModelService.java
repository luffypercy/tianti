package com.jeff.tianti.org.service;

import com.jeff.tianti.org.entity.XcFundsRecordModel;
import com.jeff.tianti.org.dao.XcFundsRecordModelDao;
import com.jeff.tianti.org.dto.XcFundsRecordModelQueryDTO;
import com.jeff.tianti.common.service.CommonService;
import com.jeff.tianti.common.entity.PageModel;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author percy
 * @desc XcFundsRecordModelService类 
 * @date 2017-04-09
 */
@Service
public class XcFundsRecordModelService extends CommonService< XcFundsRecordModel,String >  {

    @Autowired
    private XcFundsRecordModelDao xcFundsRecordModelDao;

    @Autowired
    public void setXcFundsRecordModelDao(XcFundsRecordModelDao xcFundsRecordModelDao){
      super.setCommonDao(xcFundsRecordModelDao);
    }

    public PageModel<XcFundsRecordModel> queryXcFundsRecordModelPage(XcFundsRecordModelQueryDTO xcFundsRecordModelQueryDTO){
           return this.xcFundsRecordModelDao.queryXcFundsRecordModelPage(xcFundsRecordModelQueryDTO);
    }

    public List<XcFundsRecordModel> queryXcFundsRecordModelList(XcFundsRecordModelQueryDTO xcFundsRecordModelQueryDTO){
           return this.xcFundsRecordModelDao.queryXcFundsRecordModelList(xcFundsRecordModelQueryDTO);
    }


}