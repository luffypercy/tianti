package com.jeff.tianti.controller;

import com.jeff.tianti.org.entity.XcRechargeOrderModel;
import com.jeff.tianti.org.service.XcRechargeOrderModelService;
import javax.servlet.http.HttpServletRequest; 
import org.apache.commons.lang3.StringUtils; 
import java.util.Date; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import com.jeff.tianti.common.entity.PageModel; 
import com.jeff.tianti.org.dto.XcRechargeOrderModelQueryDTO;
/**
 * @author percy
 * @desc XcRechargeOrderModelController 
 * @date 2017-04-09
 */
@Controller
@RequestMapping("/boss/xcRechargeOrderModel")
public class XcRechargeOrderModelController{

    @Autowired
    private XcRechargeOrderModelService xcRechargeOrderModelService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request,Model model){
       String currentPageStr = request.getParameter("currentPage");
       String pageSizeStr = request.getParameter("pageSize");
       int currentPage = 1;
       int pageSize = 10;
       if(StringUtils.isNotBlank(currentPageStr)){
             currentPage = Integer.parseInt(currentPageStr);
       }
       if(StringUtils.isNotBlank(pageSizeStr)){
             pageSize = Integer.parseInt(pageSizeStr);
       }
       XcRechargeOrderModelQueryDTO xcRechargeOrderModelQueryDTO = new XcRechargeOrderModelQueryDTO(); 
       xcRechargeOrderModelQueryDTO.setCurrentPage(currentPage);
       xcRechargeOrderModelQueryDTO.setPageSize(pageSize);
       PageModel<XcRechargeOrderModel> page = this.xcRechargeOrderModelService.queryXcRechargeOrderModelPage(xcRechargeOrderModelQueryDTO);
       model.addAttribute("page", page);

       return "/xcRechargeOrderModel/list";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        XcRechargeOrderModel xcRechargeOrderModel = null;
        if(StringUtils.isNotBlank(id)){
             xcRechargeOrderModel = this.xcRechargeOrderModelService.find(id);
        }
        model.addAttribute("xcRechargeOrderModel", xcRechargeOrderModel);
        model.addAttribute("id", id);
        return "/xcRechargeOrderModel/add";
    }

    @RequestMapping("/saveorupdate")
    public String doSaveOrUpdate(HttpServletRequest request){
        String id = request.getParameter("id");
        XcRechargeOrderModel xcRechargeOrderModel = null;
        if(StringUtils.isNotBlank(id)){
             xcRechargeOrderModel = this.xcRechargeOrderModelService.find(id);
             xcRechargeOrderModel.setUpdateDate(new Date());
             this.xcRechargeOrderModelService.update(xcRechargeOrderModel);
        }else{
             xcRechargeOrderModel = new XcRechargeOrderModel();
             xcRechargeOrderModel.setCreateDate(new Date());
             this.xcRechargeOrderModelService.save(xcRechargeOrderModel);
        }
        return "redirect:/xcRechargeOrderModel/list";
    }

    @RequestMapping("/doDelete")
    public String doDelete(HttpServletRequest request){
        String id = request.getParameter("id");
        XcRechargeOrderModel xcRechargeOrderModel = this.xcRechargeOrderModelService.find(id);
        if(xcRechargeOrderModel != null){
           xcRechargeOrderModel.setDeleteFlag("1");
           this.xcRechargeOrderModelService.update(xcRechargeOrderModel);
        }
        return "redirect:/xcRechargeOrderModel/list";
    }



}