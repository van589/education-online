package com.van589.mooc.web.api.web.controller.v1;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.utils.BeanCopyUtil;
import com.van589.mooc.web.api.Service.CourseService;
import com.van589.mooc.web.api.web.dto.CourseDTO;
import com.van589.mooc.web.api.web.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 获取精品课程
     * @return
     */
    @RequestMapping(value = "getBoutiqueCourse" ,method = RequestMethod.GET)
    public List<CourseDTO> showsBoutiqueCourse(){
        List allBoutique = courseService.selectAllBoutique();
        //未查找到用户则返回错误信息
        if (allBoutique == null){
            return null;
        }
        //查早到则返回用户的DTO
        else{
            //将 List里的数据复制到 DTO 里
            List list = BeanCopyUtil.copyListProperties(allBoutique, CourseDTO::new);
            return list;
        }
    }
}
