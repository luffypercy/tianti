package com.jeff.tianti.org.service;

import com.jeff.tianti.org.entity.XcRechargeOrderModel;
import com.jeff.tianti.org.dao.XcRechargeOrderModelDao;
import com.jeff.tianti.org.dto.XcRechargeOrderModelQueryDTO;
import com.jeff.tianti.common.service.CommonService;
import com.jeff.tianti.common.entity.PageModel;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author percy
 * @desc XcRechargeOrderModelService类 
 * @date 2017-04-09
 */
@Service
public class XcRechargeOrderModelService extends CommonService< XcRechargeOrderModel,String >  {

    @Autowired
    private XcRechargeOrderModelDao xcRechargeOrderModelDao;

    @Autowired
    public void setXcRechargeOrderModelDao(XcRechargeOrderModelDao xcRechargeOrderModelDao){
      super.setCommonDao(xcRechargeOrderModelDao);
    }

    public PageModel<XcRechargeOrderModel> queryXcRechargeOrderModelPage(XcRechargeOrderModelQueryDTO xcRechargeOrderModelQueryDTO){
           return this.xcRechargeOrderModelDao.queryXcRechargeOrderModelPage(xcRechargeOrderModelQueryDTO);
    }

    public List<XcRechargeOrderModel> queryXcRechargeOrderModelList(XcRechargeOrderModelQueryDTO xcRechargeOrderModelQueryDTO){
           return this.xcRechargeOrderModelDao.queryXcRechargeOrderModelList(xcRechargeOrderModelQueryDTO);
    }


}