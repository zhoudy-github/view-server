package com.synway.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface ViewMapper {

    int saveIntroduction(Map<String,Object> params);

    int saveBackground(Map<String,Object> params);

    int saveData(Map<String,Object> params);

    int saveProgram(Map<String,Object> params);

    int saveCode(Map<String,Object> params);

    void saveFile(Map<String,Object> params);

    List<Map<String,Object>> listThemeData();

    Map<String,Object> getThemeContent(String theme_id);

    Map<String,Object> getBackgroundContent(String theme_id);

    Map<String,Object> findAttachment(Map<String,String> params);

    Map<String,Object> getDataByThemeId(String theme_id);

    Map<String,Object> getProgramByThemeId(String theme_id);

    Map<String,Object> getCodeByThemeId(String theme_id);

    List<Map<String,Object>> getAttachmentByBusinessId(int business_id);

    List<Map<String,Object>> getAttachmentByBusinessIdAndType(@Param("business_id")int business_id,
                                                              @Param("business_name")String business_name);

    List<Map<String,Object>> listView();

    List<Map<String,Object>> getFileByType(@Param("themeId") String themeId,
                                           @Param("type") String type);

    int delFileById(int id);

    int updateTheme(Map<String,Object> params);

    int updateBackground(Map<String,Object> params);

    int updateData(Map<String,Object> params);

    int updateProgram(Map<String,Object> params);

    int updateCode(Map<String,Object> params);

    int delThemeById(int id);

    Map<String,Object> getDefaultThemeId();
}
