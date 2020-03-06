package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.domain.CourseFile;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseController;
import com.van589.mooc.web.admin.service.CourseFileService;
import com.van589.mooc.web.admin.service.CourseService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "file")
public class CourseFileController extends AbstractBaseController<CourseFile, CourseFileService> {

    @Value("${file.path}")
    private String filePath;

    /**
     * 跳转到 视频列表 页面
     *
     * @return
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "course/file_list";
    }

    /**
     * 跳转到 新增或编辑视频 页面
     *
     * @param model
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model, String id) {
        getCourseFile(model, id);
        return "/course/file_form";
    }

    @Override
    public String save(CourseFile entity, Model model, RedirectAttributes redirectAttributes) {
        return null;
    }

    /**
     * 新增视频信息
     *
     * @param courseFileName
     * @param courseFile
     * @param url
     * @param model
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(String courseFileName, MultipartFile courseFile,String url, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = null;
        //当为新建的时候做判断
        if (courseFile == null && url == null){
            baseResult = BaseResult.fail("请选择上传的文件");
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "course/file_list";
        }

        /**
         * 覆盖和不覆盖暂时不处理
         */
        //当为编辑的时候，且不覆盖原有视频
        else if(courseFile == null && url != null){

        }
        //当为编辑的时候覆盖原有视频
        else{

        }
        CourseFile entity = new CourseFile();
        //获取文件的后缀名
        String suffixName = courseFile.getOriginalFilename().substring(courseFile.getOriginalFilename().lastIndexOf("."));
        //设置视频的名称
        entity.setFilename(courseFileName);
        //设置视频的URL
        entity.setUrl(filePath + courseFileName + suffixName);

        baseResult = service.save(entity);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            //成功则保存文件至目录
            File newFile = new File(filePath + courseFileName + suffixName);
            try {
                courseFile.transferTo(newFile);  //拷贝文件，性能高效，比原先的方便
            } catch (IOException e) {
                e.printStackTrace();
                baseResult = BaseResult.fail("保存失败");
                model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
                return "course/file_form";
            }
            redirectAttributes.addFlashAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "redirect:/file/list";
        }

        // 保存失败
        else {
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "course/file_form";
        }
    }

    @Override
    public String detail(Model model, String id) {
        return null;
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
            //获取要删除字段的基本信息
            List<CourseFile> courseFiles = service.selectMultiById(idArray);
            //根据ULR删除本地文件
            for (CourseFile courseFile : courseFiles) {
                File file = new File(courseFile.getUrl());
                file.delete();
            }
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除视频成功");
        } else {
            baseResult = BaseResult.fail("删除视频失败");
        }

        return baseResult;
    }

    /**
     * 获取单个视频信息
     *
     * @param model
     * @param id
     */
    private void getCourseFile(Model model, String id) {
        CourseFile entity = getEntity(id);
        model.addAttribute(ConstantUtils.SESSION_COURSEFILE, entity == null ? new CourseFile() : entity);
    }
}
