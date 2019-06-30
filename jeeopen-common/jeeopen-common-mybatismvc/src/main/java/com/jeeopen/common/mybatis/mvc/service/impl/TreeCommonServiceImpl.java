package com.jeeopen.common.mybatis.mvc.service.impl;

import java.io.Serializable;
import java.util.List;
import com.jeeopen.common.mvc.entity.tree.TreeNode;
import com.jeeopen.common.query.data.Queryable;
import com.jeeopen.common.utils.ObjectUtils;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jeeopen.common.mybatis.mvc.mapper.BaseTreeMapper;
import com.jeeopen.common.mybatis.mvc.parse.QueryToWrapper;
import com.jeeopen.common.mybatis.mvc.service.ITreeCommonService;

@Transactional
public class TreeCommonServiceImpl<M extends BaseTreeMapper<T>, T extends Serializable & TreeNode<ID>, ID extends Serializable>
		extends CommonServiceImpl<M, T> implements ITreeCommonService<T, ID> {

	@Override
	public T selectById(Serializable id) {
		return baseMapper.selectByTreeId(id);
	}

	@Override
	public List<T> selectTreeList(Queryable queryable, Wrapper<T> wrapper) {
		// 保证有where字句
		QueryToWrapper<T> queryToWrapper = new QueryToWrapper<T>();
		wrapper.eq("1", "1");
		queryToWrapper.parseCondition(wrapper, queryable);
		// 排序问题
		queryToWrapper.parseSort(wrapper, queryable);
		List<T> content = baseMapper.selectTreeList(wrapper);
		return content;
	}

	@Override
	public List<T> selectTreeList(Wrapper<T> wrapper) {
		// 保证有where字句
		wrapper.eq("1", "1");
		List<T> content = baseMapper.selectTreeList(wrapper);
		return content;
	}

	@Override
	public boolean insert(T entity) {
		if (!ObjectUtils.isNullOrEmpty(entity.getParentId())) {
			T parent = selectById(entity.getParentId());
			entity.setParentId(parent.getId());
			entity.setParentIds(parent.makeSelfAsNewParentIds());
		} else {
			entity.setParentId(null);
		}
		return super.insert(entity);
	}

	@Override
	public boolean insertOrUpdate(T entity) {
		if (!ObjectUtils.isNullOrEmpty(entity.getParentId())) {
			T parent = selectById(entity.getParentId());
			updateSelftAndChild(entity, parent.getId(), parent.makeSelfAsNewParentIds());
		} else {
			entity.setParentId(null);
			updateSelftAndChild(entity, null, null);
		}
		return true;
	}

	private void updateSelftAndChild(T entity, ID newParentId, String newParentIds) {
		T oldEntity = selectById(entity.getId());
		String oldChildrenParentIds = oldEntity.makeSelfAsNewParentIds();
		entity.setParentId(newParentId);
		entity.setParentIds(newParentIds);
		super.insertOrUpdate(entity);
		String newChildrenParentIds = entity.makeSelfAsNewParentIds();
		baseMapper.updateSunTreeParentIds(newChildrenParentIds, oldChildrenParentIds);
	}
	
	/*// 只允许单个删除
	@Override
	public boolean deleteById(Serializable id) {
		T entity = selectById(id);
		baseMapper.deleteSunTree(entity.makeSelfAsNewParentIds());
		return super.deleteById(id);
	}

	@Override
	public boolean deleteBatchIds(List<? extends Serializable> idList) {
		for (Serializable  treeId: idList) {
			deleteById(treeId);
		}
		return true;
	}*/
}