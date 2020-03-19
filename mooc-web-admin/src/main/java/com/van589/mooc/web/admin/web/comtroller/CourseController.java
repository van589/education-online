package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.CourseFile;
import com.van589.mooc.web.admin.abstracts.AbstractBaseController;
import com.van589.mooc.web.admin.service.CourseService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "course")
public class CourseController extends AbstractBaseController<Course, CourseService> {

    @Value("${file.image-path}")
    private String filePath;

    /**
     * 跳转 课程列表 界面
     *
     * @return
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "course/course_list";
    }

    /**
     * 跳转 课程 表单页
     *
     * @return
     */
    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model, String id) {
        getCourse(model, id);
        return "course/course_form";
    }

    /**
     * 保存 课程 信息
     *
     * @param entity
     * @param model
     * @param redirectAttributes
     * @return
     */
    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Course entity, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(entity);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "redirect:/course/list";
        }

        // 保存失败
        else {
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "course/course_form";
        }
    }

    /**
     * 显示 课程 详情
     *
     * @param model
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, String id) {
        getCourse(model, id);
        return "includes/course/course_detail";
    }

    /**
     * 删除一条或多条课程信息
     *
     * @param ids
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }

        return baseResult;
    }

    /**
     * 进行课程视频的绑定
     *
     * @return
     */
    @RequestMapping(value = "bind", method = RequestMethod.GET)
    public String bind(Model model, String id) {
        List<CourseFile> courseFiles = null;

        //查询选择的课程是要进行绑定动作
        Course course = getCourse(id);
        String fileId = course.getFileId();

        //做视频绑定请求
        if (fileId == null) {
            courseFiles = service.selectCourseFileForBind();
        } else {
            model.addAttribute(ConstantUtils.SESSION_MESSAGE, "请选择未绑定的视频");
        }
        model.addAttribute(ConstantUtils.SESSION_COURSEFILE, courseFiles);
        model.addAttribute("fileId", fileId);
        return "includes/course/course_file_bind";
    }

    /**
     * 将视频绑定到对应的课程
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "bind", method = RequestMethod.POST)
    public BaseResult bind(String CourseId, String CourseFileId) {
        BaseResult baseResult = null;
        //获取课程的信息
        Course course = getCourse(CourseId);
        //设置绑定的视频ID
        course.setFileId(CourseFileId);
        service.save(course);
        //返回提示信息
        baseResult = BaseResult.success("视频绑定成功");
        return baseResult;
    }

    /**
     * 进行课程视频的解绑
     *
     * @return
     */
    @RequestMapping(value = "unbind", method = RequestMethod.GET)
    public String unbind(Model model, String id) {
        //查询选择的课程是要进行解绑动作
        Course course = getCourse(id);
        String fileId = course.getFileId();
        //如果已绑定则解绑
        if (fileId != null) {
            course.setFileId(null);
            service.save(course);
            model.addAttribute(ConstantUtils.SESSION_MESSAGE, "解绑成功");
        }
        //如果未绑定则返回提示
        else {
            model.addAttribute(ConstantUtils.SESSION_MESSAGE, "请选择已绑定的视频");
        }
        return "includes/course/course_file_bind";
    }

    /**
     * 跳转到绑定封面页面
     *
     * @return
     */
    @RequestMapping(value = "bindImage", method = RequestMethod.GET)
    public String bindImage(Model model, String id) {
        model.addAttribute("courseId", id);
        return "includes/course/course_image_file_bind";
    }

    /**
     * 跳转到绑定封面页面
     *
     * @param image
     * @param model
     * @return
     */
    @RequestMapping(value = "bindImage", method = RequestMethod.POST)
    public String bindImage(String id, MultipartFile image, Model model) {
        //获取图片名称
        String imageName = image.getOriginalFilename();
        BaseResult baseResult = null;
        //如果图片为空则返回错误信息
        if (imageName.isEmpty()) {
            baseResult = BaseResult.fail("请选择绑定的封面");
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "course/course_list";
        }
        //如果图片不为空则保存图片Url信息到数据库
        Course entity =getCourse(id);
        //获取文件的后缀名
        String suffixName = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
        //将文件名改成UUID
        imageName = UUID.randomUUID().toString().replaceAll("-", "")  + suffixName;
        //文件地址的Url
        String ImageUrl = filePath + imageName;
        //设置封面的Url
        entity.setImageUrl(imageName);
        service.save(entity);
        //返回提示信息
        baseResult = BaseResult.success("视频绑定成功");

        // 保存图片文件到本地
        if (baseResult.getStatus() == 200) {
            //成功则保存文件至目录
            File newFile = new File(ImageUrl);
            try {
                image.transferTo(newFile);  //拷贝文件，性能高效，比原先的方便
            } catch (IOException e) {
                e.printStackTrace();
                baseResult = BaseResult.fail("保存失败");
            }
        }
        model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
        return "course/course_list";
    }

    /**
     * 获取单个 课程 信息
     *
     * @param model
     * @param id
     */
    private void getCourse(Model model, String id) {
        Course course = getEntity(id);
        model.addAttribute(ConstantUtils.SESSION_COURSE, course == null ? new Course() : course);
    }

    /**
     * 获取单个 课程 信息
     *
     * @param id
     * @return
     */
    private Course getCourse(String id) {
        return getEntity(id);
    }

}
