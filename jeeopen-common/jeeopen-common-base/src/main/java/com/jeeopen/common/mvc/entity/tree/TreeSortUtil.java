package com.jeeopen.common.mvc.entity.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jeeopen.common.utils.ObjectUtils;

/**
 * 树排序
 * 
 * @author wangpf
 *
 */
public class TreeSortUtil<ID extends Serializable> implements Serializable {

	private static final long serialVersionUID = 2444638065060902858L;

	private List<TreeNode<ID>> treeNodes;

	private List<TreeNode<ID>> newTreeNodes;

	public static <T extends Serializable> TreeSortUtil<T> create() {
		TreeSortUtil<T> treeSortUtil = new TreeSortUtil<T>();
		return treeSortUtil;
	}

	public TreeSortUtil() {
		this.newTreeNodes = new ArrayList<TreeNode<ID>>();
	}

	/**
	 * 获得根节点
	 *
	 */
	public List<TreeNode<ID>> getTopNodes() {
		List<TreeNode<ID>> list = new ArrayList<TreeNode<ID>>();
		for (TreeNode<ID> treeable : treeNodes) {
			if (treeable.isRoot()) {
				list.add(treeable);
			}
		}
		return list;
	}

	/**
	 * 解析根节点
	 * 
	 * @param node
	 */
	public void parseSubNode(TreeNode<ID> node) {
		for (TreeNode<ID> treeable : treeNodes) {
			if (!ObjectUtils.isNullOrEmpty(treeable.getParentId()) && treeable.getParentId().equals(node.getId())) {
				newTreeNodes.add(treeable);
				parseSubNode(treeable);
			}
		}
	}

	/**
	 * 运行排序
	 */
	@SuppressWarnings("unchecked")
	public TreeSortUtil<ID> sort(List<?> treeNodes) {
		this.treeNodes = (List<TreeNode<ID>>) treeNodes;
		List<TreeNode<ID>> rootNodes = getTopNodes();
		for (TreeNode<ID> rootNode : rootNodes) {
			newTreeNodes.add(rootNode);
			parseSubNode(rootNode);
		}
		this.treeNodes.clear();
		this.treeNodes.addAll(newTreeNodes);
		return this;
	}

	/**
	 * 运行排序
	 */
	public TreeSortUtil<ID> async(List<?> treeNodes) {
		this.treeNodes = (List<TreeNode<ID>>) treeNodes;
		for (TreeNode<ID> treeNode : this.treeNodes) {
			treeNode.setLoaded(true);
		}
		return this;
	}

	public TreeSortUtil<ID> sync(List<?> treeNodes) {
		this.treeNodes = (List<TreeNode<ID>>) treeNodes;
		for (TreeNode<ID> treeNode : this.treeNodes) {
			treeNode.setLoaded(false);
		}
		return this;
	}

}
