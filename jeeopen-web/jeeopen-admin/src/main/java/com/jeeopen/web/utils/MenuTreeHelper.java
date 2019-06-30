package com.jeeopen.web.utils;

import com.jeeopen.common.utils.ObjectUtils;
import com.alibaba.fastjson.JSON;
import com.jeeopen.web.modules.sys.entity.Menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.web.utils
 * @title:
 * @description: 解析树
 * @author: wangpf
 * @date: 2018/10/5 13:13
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */

/**
 * 树排序
 *
 * @author wangpf
 *
 */
public class MenuTreeHelper<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 2444638065060902858L;

    private List<Menu> treeNodes;

    public static <T extends Serializable> MenuTreeHelper<T> create() {
        MenuTreeHelper<T> menuTreeHelper = new MenuTreeHelper<T>();
        return menuTreeHelper;
    }

    /**
     * 获得根节点
     *
     */
    public List<MenuNode> getTopNodes() {
        List<MenuNode> list = new ArrayList<MenuNode>();
        for (Menu treeable : treeNodes) {
            if (treeable.isRoot()
                    && !treeable.getType().equals("3")) {
                list.add(menuToNode(treeable));
            }
        }
        return list;
    }

    /**
     * 解析根节点
     *
     * @param node
     */
    public void parseSubNode(MenuNode node) {
        List<MenuNode> menuNodes = new ArrayList<MenuNode>();
        for (Menu treeable : treeNodes) {
            if (!ObjectUtils.isNullOrEmpty(treeable.getParentId())
                    && treeable.getParentId().equals(node.getId())
                    && !treeable.getType().equals("3")) {
                MenuNode menuNode = menuToNode(treeable);
                menuNode.setHasChildren(Boolean.FALSE);
                menuNodes.add(menuNode);
                parseSubNode(menuNode);
                node.setChildrenNode(menuNodes);
                if (menuNodes.size()>0){
                    node.setHasChildren(Boolean.TRUE);
                }else{
                    node.setHasChildren(Boolean.FALSE);
                }
            }
        }
    }

    /**
     * 运行排序
     */
    @SuppressWarnings("unchecked")
    public List<MenuNode> sort(List<?> treeNodes) {
        this.treeNodes = (List<Menu>) treeNodes;
        List<MenuNode> rootNodes = getTopNodes();
        for (MenuNode rootNode : rootNodes) {
            rootNode.setHasChildren(Boolean.FALSE);
            parseSubNode(rootNode);
        }
        // this.treeNodes.clear();
        return rootNodes;
    }

    private MenuNode menuToNode(Menu menu){
        String menuStr = JSON.toJSONString(menu);
        MenuNode menuNode =JSON.parseObject(menuStr, MenuNode.class);
        return menuNode;
    }

    public static class MenuNode extends Menu{

        private List<MenuNode> childrenNode=new ArrayList<>();

        public List<MenuNode> getChildrenNode() {
            return childrenNode;
        }

        public void setChildrenNode(List<MenuNode> childrenNode) {
            this.childrenNode = childrenNode;
        }
    }
}