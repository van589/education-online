package com.van589.mooc.web.admin.abstracts;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.persistence.BaseService;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.Log;
import com.van589.mooc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/**
 * 所有 Controller 的基类
 *
 * @param <T>
 * @param <S>
 */
public abstract class AbstractBaseController<T extends BaseEntity, S extends BaseService<T>> {

    @Autowired
    protected S service;

    /**
     * 跳转列表页
     *
     * @return
     */
    public abstract String list();

    /**
     * 跳转表单页
     *
     * @param model
     * @param id
     * @return
     */
    public abstract String form(Model model, String id);

    /**
     *保存或更新信息
     *
     * @param entity
     * @param model
     * @param redirectAttributes
     * @return
     */
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);

    /**
     * 显示详情信息
     *
     * @param model
     * @param id
     * @return
     */
    public abstract String detail(Model model, String id);

    /**
     * DateTables 的分页查询
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<T> page(HttpServletRequest request, T entity) {
        //获取 DateTables 的请求的参数
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");

        //设置请求参数
        Map<String, Object> params = new HashMap<>();
        params.put("page", Integer.parseInt(start));
        params.put("pageSize", Integer.parseInt(length));
        params.put("pageParams", entity);

        PageInfo<T> pageInfo = service.page(params);

        pageInfo.setDraw(draw == null ? 0 : Integer.parseInt(draw));

        return pageInfo;
    }

    /**
     * 获取单个实体类信息
     *
     * @param id
     */
    protected T getEntity(String id){
        T entity = null;
        //如果 id 不为空则将用户信息查询出来，否则返回一个空的用户信息
        if (id != null) {
            return service.getById(id);
        }
        return entity;
    }
}
