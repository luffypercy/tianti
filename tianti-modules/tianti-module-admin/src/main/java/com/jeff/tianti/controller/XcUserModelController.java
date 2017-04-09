package com.jeff.tianti.controller;

import com.jeff.tianti.org.entity.User;
import com.jeff.tianti.org.entity.XcUserModel;
import com.jeff.tianti.org.service.XcUserModelService;
import com.jeff.tianti.util.Constants;

import javax.servlet.http.HttpServletRequest; 
import org.apache.commons.lang3.StringUtils; 
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.tianti.common.dto.AjaxResult;
import com.jeff.tianti.common.entity.PageModel;
import com.jeff.tianti.org.dto.XcUserModelQueryDTO;
/**
 * @author percy
 * @desc XcUserModelController 
 * @date 2017-04-09
 */
@Controller
@RequestMapping("/xcUserModel")
public class XcUserModelController{

    @Autowired
    private XcUserModelService xcUserModelService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request,Model model){
		String mobile = request.getParameter("mobile");

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
       XcUserModelQueryDTO xcUserModelQueryDTO = new XcUserModelQueryDTO(); 
       xcUserModelQueryDTO.setMobile(mobile);
       xcUserModelQueryDTO.setCurrentPage(currentPage);
       xcUserModelQueryDTO.setPageSize(pageSize);
       PageModel<XcUserModel> page = this.xcUserModelService.queryUserPage(xcUserModelQueryDTO);
       model.addAttribute("page", page);
       model.addAttribute("xcUserModelQueryDTO", xcUserModelQueryDTO);
		model.addAttribute(Constants.MENU_NAME, "会员列表");
		
       return "/xcUserModel/list";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        XcUserModel xcUserModel = null;
        if(StringUtils.isNotBlank(id)){
             xcUserModel = this.xcUserModelService.find(id);
        }
        model.addAttribute("xcUserModel", xcUserModel);
        model.addAttribute("id", id);
        return "/xcUserModel/add";
    }

    @RequestMapping("/saveorupdate")
    public String doSaveOrUpdate(HttpServletRequest request){
        String id = request.getParameter("id");
        XcUserModel xcUserModel = null;
        if(StringUtils.isNotBlank(id)){
             xcUserModel = this.xcUserModelService.find(id);
             xcUserModel.setUpdateDate(new Date());
             this.xcUserModelService.update(xcUserModel);
        }else{
             xcUserModel = new XcUserModel();
             xcUserModel.setCreateDate(new Date());
             this.xcUserModelService.save(xcUserModel);
        }
        return "redirect:/xcUserModel/list";
    }

    @RequestMapping("/doDelete")
    public String doDelete(HttpServletRequest request){
        String id = request.getParameter("id");
        XcUserModel xcUserModel = this.xcUserModelService.find(id);
        if(xcUserModel != null){
           xcUserModel.setDeleteFlag("1");
           this.xcUserModelService.update(xcUserModel);
        }
        return "redirect:/xcUserModel/list";
    }
    

	
	/**
	 * 用户保存操作
	 * @param request
	 * @return
	 */
	@RequestMapping("/ajax/save")
	@ResponseBody
	public AjaxResult ajaxSave(HttpServletRequest request){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setSuccess(false);
		
		try {
			
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			String mobile = request.getParameter("mobile");
			
			
			XcUserModel user = null;
			if(StringUtils.isNotBlank(id)){
				user = xcUserModelService.find(id);
			}else{
				user = new XcUserModel();
				user.setUsername(StringUtils.trim(username));
				user.setStatus(User.STATUS_YES);
			}
			long now=new Date().getTime()/1000;
			user.setMobile(StringUtils.trim(mobile));
			user.setUptime(now);
			
			if(StringUtils.isNotBlank(id)){
				xcUserModelService.update(user);
			}else{
				user.setAddtime(now);
				user.setBalance(0.0);
				user.setFrozen(0.0);
				xcUserModelService.save(user);
			}
			ajaxResult.setSuccess(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ajaxResult;
	}
	

	/**
	 * 修改用户状态
	 * @param request
	 * @return
	 */
	@RequestMapping("/ajax/upd/status")
	@ResponseBody
	public AjaxResult ajaxUpdStatus(HttpServletRequest request){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setSuccess(false);
		
		try {
			String[] ids = request.getParameterValues("ids");
			String status = request.getParameter("status");
			
			xcUserModelService.updateStatus(ids, Integer.parseInt(status));
			
			ajaxResult.setSuccess(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ajaxResult;
	}
	
	/**
	 * 跳转到用户编辑页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/dialog/edit")
	public String dialogEdit(HttpServletRequest request, Model model){
		String id = request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
			XcUserModel user = xcUserModelService.find(id);
			model.addAttribute("user", user);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleteFlag", "0");
		
		
		return "xcUserModel/dialog/user_edit";
	}


}