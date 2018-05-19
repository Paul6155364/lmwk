package com.bootdo.usermanage.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import com.bootdo.common.utils.UuidUtils;
import com.bootdo.usermanage.domain.Company;


import com.bootdo.usermanage.service.CompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * create with idea
 * author: xiaoniao
 * Date: 2018/5/17
 * Time: 12:54
 */
@Controller
@RequestMapping("/user/com")
public class ComyanyController extends BaseController {
    String prefix = "usermanage/company";
    @Autowired
    CompanyService companyService;

    //@RequiresPermissions("sys:menu:menu")
    @GetMapping()
    String company(Model model) {
        return prefix+"/company";
    }
    @ResponseBody
    @GetMapping("/list")
    PageUtils list(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Company> companies = companyService.list(query);
        int count = companyService.count(query);
        PageUtils pageUtils = new PageUtils(companies,count);
        return pageUtils;
    }
    //@ResponseBody
    @GetMapping("/add")
    String add(Model model){
        return  prefix+"/add";
    }
    @ResponseBody
    @GetMapping("/eidt/{id}")
    String eidt(Model model,@PathVariable("id") String id){
        Company  company  = companyService.get(id);
        model.addAttribute("entity",company);
        return prefix+"/edit";
    }

    @ResponseBody
    @PostMapping("/update")
    public R update(Company company) {
        try {
            companyService.update(company);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(1, "未修改成功请稍后再试");
        }
    }
    @ResponseBody
    @PostMapping("/save")
    public R add(Company company){
        try {
            companyService.add(company);
            return  R.ok();
        }catch (Exception e)
        {
            e.printStackTrace();
            return  R.error(1,"未添加成功请重新操作");
        }
    }
    @ResponseBody
    @RequestMapping("/lock")
    public R lock(String id){
        try{
            return  R.ok();
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
    }
    @ResponseBody
    @RequestMapping("/delete")
    public R delete(String id){
        try{
            companyService.delete(id);
            return  R.ok();
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
    }
}