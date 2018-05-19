package com.bootdo.usermanage.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.usermanage.domain.Applyuser;
import com.bootdo.usermanage.service.ApplyUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

/**
 * create with idea
 * author: xiaoniao
 * Date: 2018/5/18
 * Time: 15:26
 */
@RequestMapping("/apply/user")
@Controller
public class ApplyuserContrller extends BaseController {
      String prefix = "usermanage/applyuser";
      @Autowired
     ApplyUserService applyUserService;

    @GetMapping()
    String applyuser(Model model){
        return  prefix+"/applyuser";
    }

    @ResponseBody
    @GetMapping("/list")
    PageUtils  list(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        List<Applyuser> list= applyUserService.list(query);
        int count = applyUserService.count(query);
        PageUtils pageUtils = new PageUtils(list,count);
        return  pageUtils;
    }
    @GetMapping("/add")
    String add(Model model)
    {
        return prefix+"/add";
    }
    @ResponseBody
    @PostMapping("/save")
    R save(Applyuser applyuser){
        try{
           applyUserService.add(applyuser);
           return R.ok();
        }catch (Exception e){
            e.printStackTrace();
            return R.error(1,"添加失败");
        }

    }
    @ResponseBody
    @PostMapping("/lock")
    R lock(String id){
        try{
            applyUserService.lock(id);
            return R.ok("操作成功");
        }catch (Exception e){
            e.printStackTrace();
            return  R.error(1,"操作失败");
        }
    }
    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") String id ,Model model){
        Applyuser applyuser = applyUserService.find(id);
        if(applyuser!=null&&!("").equals(applyuser)){
            model.addAttribute("applyuser",applyuser);
        }
        return prefix+"/edit";
    }

}
