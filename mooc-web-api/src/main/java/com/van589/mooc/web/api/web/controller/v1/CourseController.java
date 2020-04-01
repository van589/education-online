package com.van589.mooc.web.api.web.controller.v1;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.utils.BeanCopyUtil;
import com.van589.mooc.domain.Course;
import com.van589.mooc.web.api.Service.CourseService;
import com.van589.mooc.web.api.web.dto.CourseDTO;
import com.van589.mooc.web.api.web.dto.CourseDetailDTO;
import com.van589.mooc.web.api.web.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
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
        //未查找到视频则返回错误信息
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

    /**
     * 查询课程及其视频链接
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public BaseResult getCourseDetail(String id){
        BaseResult baseResult = BaseResult.fail("查找失败");
        CourseDetailDTO courseDetailDTO = courseService.selectCourseById(id);

        //如果课程不为空，且存在视频则返回成功
        if(courseDetailDTO != null){
            if (!StringUtils.isEmpty(courseDetailDTO.getUrl())){
                baseResult = BaseResult.success("查找成功", courseDetailDTO);
            }
        }

        return baseResult;
    }

    @RequestMapping(value = "searchName",method = RequestMethod.GET)
    public List<CourseDTO> searchName(String name){
        List courseByName = courseService.selectAllCourseByName(name);
        //未查找到视频则返回错误信息
        if (courseByName == null){
            return null;
        }
        //查早到则返回用户的DTO
        else{
            //将 List里的数据复制到 DTO 里
            List list = BeanCopyUtil.copyListProperties(courseByName, CourseDTO::new);
            return list;
        }
    }
}
