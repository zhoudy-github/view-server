package com.synway.controller;

import com.synway.service.ViewService;
import com.synway.utils.JsonData;
import com.synway.utils.JwtUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Api")
public class ViewController {
    @Autowired
    private ViewService viewService;

    @PostMapping("/saveThemeContent")
    @RequiresRoles(value = "admin")
    public JsonData saveThemeContent(@RequestParam Map<String, Object> params,
                                     HttpServletRequest request) {
        //这里先直接从请求头获取token,后面改为redis
        String token = request.getHeader("token");
        int user_id = JwtUtils.getUserId(token);
        String user_name = JwtUtils.getUserName(token);

        params.put("user_id", user_id);
        params.put("user_name", user_name);
        boolean result = viewService.saveThemeContent(params);
        if (result) {
            return JsonData.buildSuccess("保存主题成功");
        } else {
            return JsonData.buildError("保存主题失败");
        }
    }

    @PostMapping("/listThemeData")
    public JsonData listThemeData() {
        List<Map<String, Object>> list = viewService.listThemeData();
        if (list.size() > 0) {
            return JsonData.buildSuccess("查询成功", list);
        } else {
            return JsonData.buildError("查询失败");
        }
    }

    @PostMapping("/getThemeContent")
    public JsonData getThemeContent(@RequestParam String theme_id){
        Map<String, Object> themeContent = viewService.getThemeContent(theme_id);
        if(!themeContent.isEmpty()){
            return JsonData.buildSuccess("查询主题id:"+theme_id+"成功",themeContent);
        }else{
            return JsonData.buildError("查询主题id:"+theme_id+"失败");
        }
    }

    @PostMapping("/getBackgroundContent")
    public JsonData getBackgroundContent(@RequestParam String theme_id){
        Map<String, Object> backgroundContent = viewService.getBackgroundContent(theme_id);
        if(!backgroundContent.isEmpty()){
            return JsonData.buildSuccess("查询背景内容成功-----主题id:"+theme_id,backgroundContent);
        }else{
            return JsonData.buildError("查询背景内容-----主题id:"+theme_id+"失败");
        }
    }

    @PostMapping("/getDataContent")
    public JsonData getDataContent(@RequestParam String theme_id){
        Map<String, Object> dataContent = viewService.getDataContent(theme_id);
        if(!dataContent.isEmpty()){
            return JsonData.buildSuccess("查询数据集内容成功-----主题id:"+theme_id,dataContent);
        }else{
            return JsonData.buildError("查询数据集内容-----主题id:"+theme_id+"失败");
        }
    }

    @PostMapping("/getProgramContent")
    public JsonData getProgramContent(@RequestParam String theme_id){
        Map<String, Object> programContent = viewService.getProgramContent(theme_id);
        if(!programContent.isEmpty()){
            return JsonData.buildSuccess("查询程序设计内容成功-----主题id:"+theme_id,programContent);
        }else{
            return JsonData.buildError("查询程序设计-----主题id:"+theme_id+"失败");
        }
    }

    @PostMapping("/getCodeContent")
    public JsonData getCodeContent(@RequestParam String theme_id){
        Map<String, Object> codeContent = viewService.getCodeContent(theme_id);
        if(!codeContent.isEmpty()){
            return JsonData.buildSuccess("查询代码内容成功-----主题id:"+theme_id,codeContent);
        }else{
            return JsonData.buildError("查询代码内容-----主题id:"+theme_id+"失败");
        }
    }
}
