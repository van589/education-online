package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.utils.ExportPOIUtils;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseController;
import com.van589.mooc.web.admin.service.UserService;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "user")
public class UserController extends AbstractBaseController<User, UserService> {

    @Value("${file.excel-path}")
    private String excelPath;

    /**
     * 跳转到用户列表页面
     *
     * @return
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user/user_list";
    }

    /**
     * 跳转用户表单页
     *
     * @return
     */
    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model, String id) {
        getUser(model, id);
        return "user/user_form";
    }

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(User user, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(user);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "redirect:/user/list";
        }

        // 保存失败
        else {
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "user/user_form";
        }
    }

    /**
     * 删除一条或多条用户信息
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
     * 显示用户详情
     *
     * @param model
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, String id) {
        getUser(model, id);
        return "includes/user/user_detail";
    }

    /**
     * 余额充值处理
     *
     * @param ids
     * @param rechargeInput
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "recharge", method = RequestMethod.POST)
    public BaseResult recharge(String ids, Integer rechargeInput) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            Map params = new HashMap();
            params.put("collect", rechargeInput);
            params.put("ids", idArray);
            service.updateCollectMulti(params);
            baseResult = BaseResult.success("充值成功");
        } else {
            baseResult = BaseResult.fail("充值失败");
        }

        return baseResult;
    }

    /**
     * 跳转模态框的余额充值界面
     *
     * @return
     */
    @RequestMapping(value = "recharge", method = RequestMethod.GET)
    public String recharge() {
        return "includes/user/recharge_default";
    }

    /**
     * VIP 设置处理
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "vipSetting", method = RequestMethod.POST)
    public BaseResult vipSettring(String ids, Integer vipDate) {
        BaseResult baseResult = BaseResult.fail("VIP设置失败");
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            Map params = new HashMap();
            params.put("vipDate", vipDate);
            params.put("ids", idArray);
            service.updateVipSettingDateMulti(params);
            baseResult = BaseResult.success("VIP设置成功");
        }

        return baseResult;
    }

    /**
     * 跳转模态框的 VIP 设置界面
     *
     * @return
     */
    @RequestMapping(value = "vipSetting", method = RequestMethod.GET)
    public String vipSetting() {
        return "includes/user/vip_setting_default";
    }

    /**
     * 跳转导出详细页
     *
     * @return
     */
    @RequestMapping(value = "excelExport", method = RequestMethod.GET)
    public String excelExport() {
        return "includes/user/user_excel_export";
    }

    /**
     * 将表列信息查询并导出
     *
     * @param ids
     * @param excelName
     * @param excelPath
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "excelExport", method = RequestMethod.POST)
    public BaseResult excelExport(HttpServletResponse response, String ids, String excelName, String excelPath) {
        BaseResult baseResult = BaseResult.fail("导出失败");
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<User> users = service.selectByMultiId(idArray);

            // 列名
            String columnNames[] = {"ID", "账号", "呢称", "密码", "性别", "手机", "邮箱", "微信", "学历"};
            // map中的key,即实体类中的字段名
            String keys[] = {"id", "name", "nickname", "password", "sex", "phone", "email", "wechar", "education"};

            /**
             * 创建文件输出流，并构建excel,最终写出并关闭
             */
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(excelPath + excelName + ".xls");
                Workbook workbook = ExportPOIUtils.start_download(users, columnNames, keys);
                workbook.write(fos);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
                return baseResult;
            }
            baseResult = BaseResult.success("导出成功", users);
        }

        return baseResult;
    }

    /**
     * 跳转导入信息详细页
     *
     * @return
     */
    @RequestMapping(value = "excelInput", method = RequestMethod.GET)
    public String excelInput() {
        return "includes/user/user_excel_input";
    }

    /**
     * 将excel信息读取并导入数据库
     *
     * @param excelFile
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "excelInput", method = RequestMethod.POST)
    public String excelInput(MultipartFile excelFile, Model model) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        List<Map<String, Object>> readExcelFile = ExportPOIUtils.readExcelFile(list, excelFile.getInputStream(), excelFile.getOriginalFilename());
        BaseResult baseResult = service.excelInputByList(readExcelFile);
        if (baseResult.getStatus() == 200) {
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, "导入成功");
        }
        return "redirect:/user/list";
    }

    /**
     * 获取单个用户信息
     *
     * @param model
     * @param id
     */
    private void getUser(Model model, String id) {
        User user = getEntity(id);
        model.addAttribute(ConstantUtils.SESSION_USER, user == null ? new User() : user);
    }
}
