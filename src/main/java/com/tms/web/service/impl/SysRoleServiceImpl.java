package com.tms.web.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tms.web.exception.BusinessException;
import com.tms.web.exception.ErrorCode;
import com.tms.web.mapper.SysRoleMapper;
import com.tms.web.model.dto.role.RoleQueryRequest;
import com.tms.web.model.dto.role.RoleSelectItem;
import com.tms.web.model.entity.SysRole;
import com.tms.web.service.SysRoleService;
import com.tms.web.utils.SqlUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tenyon
 * @description 针对表【sys_role(角色表)】的数据库操作Service实现
 * @createDate 2025-03-03 21:11:05
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {

    @Override
    public QueryWrapper<SysRole> getQueryWrapper(RoleQueryRequest roleQueryRequest) {
        if (roleQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        Long id = roleQueryRequest.getId();
        String roleName = roleQueryRequest.getRoleName();
        String type = roleQueryRequest.getType();
        String remark = roleQueryRequest.getRemark();
        String sortField = roleQueryRequest.getSortField();
        String sortOrder = roleQueryRequest.getSortOrder();
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ObjectUtil.isNotEmpty(id), "id", id);
        queryWrapper.like(StrUtil.isNotBlank(roleName), "roleName", roleName);
        queryWrapper.eq(ObjectUtil.isNotEmpty(type), "type", type);
        queryWrapper.like(StrUtil.isNotBlank(remark), "remark", remark);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals("ascend"), sortField);
        return queryWrapper;
    }

}




