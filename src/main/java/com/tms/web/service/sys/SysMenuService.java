package com.tms.web.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tms.web.common.BaseResponse;
import com.tms.web.model.dto.sys.menu.MenuQueryRequest;
import com.tms.web.model.entity.sys.SysMenu;
import com.tms.web.model.vo.sys.menu.SysMenuVO;

import java.util.List;

/**
 * @author tenyon
 * @description 针对表【sys_menu(菜单表)】的数据库操作Service
 * @createDate 2025-03-03 21:44:45
 */
public interface SysMenuService extends IService<SysMenu> {


    /**
     * 获取脱敏的用户信息
     *
     * @param sysMenu
     * @return
     */
    SysMenuVO getMenuVO(SysMenu sysMenu);

    /**
     * 获取脱敏的用户信息
     *
     * @param sysMenuList
     * @return
     */
    List<SysMenuVO> getMenuVOList(List<SysMenu> sysMenuList);

    /**
     * 获取查询条件
     *
     * @param userQueryRequest
     * @return
     */
    QueryWrapper<SysMenu> getQueryWrapper(MenuQueryRequest userQueryRequest);

    /**
     * 获取父菜单资源
     *
     * @return
     */
    List<SysMenuVO> getParentMenuList();

}
