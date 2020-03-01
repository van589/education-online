package com.van589.mooc.web.admin.abstracts;

import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.persistence.BaseService;
import com.van589.mooc.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
}
