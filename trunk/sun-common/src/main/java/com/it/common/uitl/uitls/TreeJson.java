package com.it.common.uitl.uitls;
import java.util.ArrayList;
import java.util.List;

public class TreeJson {
	  /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id ; 
    private String pid ; 
    private String text ; 
    private String type;
    private List<TreeJson> childrens = new ArrayList<TreeJson>() ;
    private boolean expanded=true;
    private boolean menu=true;
    
  
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isMenu() {
		return menu;
	}

	public void setMenu(boolean menu) {
		this.menu = menu;
	}
	 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	 


public List<TreeJson> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<TreeJson> childrens) {
		this.childrens = childrens;
	}

public  static  List  formatTree(List<TreeJson> list) {
        
	TreeJson root = new TreeJson();
	TreeJson node = new TreeJson();
	List<TreeJson> treelist = new ArrayList<TreeJson>();// 拼凑好的json格式的数据
	List<TreeJson> parentnodes = new ArrayList<TreeJson>();// parentnodes存放所有的父节点

	if (list != null && list.size() > 0) {
	 root = list.get(0) ;
	 //循环遍历oracle树查询的所有节点
	 for (int i = 1; i < list.size(); i++) {
	     node = list.get(i);
	     if(node.getPid().trim().equals(root.getId().trim())){
	         //为tree root 增加子节点
	         parentnodes.add(node) ;
	         root.getChildrens().add(node) ;
	     }else{//获取root子节点的孩子节点
	         getChildrenNodes(parentnodes, node);
	         parentnodes.add(node) ;
	     }
	 }    
	}
	treelist.add(root) ;
    return treelist ;
    }
    public static   void getChildrenNodes(List<TreeJson> parentnodes, TreeJson node) {
        //循环遍历所有父节点和node进行匹配，确定父子关系
        for (TreeJson pnode:parentnodes) {
        	
            //TreeJson pnode = parentnodes.get(i);
            //如果是父子关系，为父节点增加子节点，退出for循环
            //System.out.println("试卷结构信息：【"+pnode.getId()+"_"+node.getPid()+"_"+pnode.getText()+"_"+node.getText()+"】");
            if (pnode.getId().trim().equals(node.getPid().trim())) {
             
                //pnode.setState("closed") ;//关闭二级树
                pnode.getChildrens().add(node) ;
                return ;
            } 
//            else {
//                //如果不是父子关系，删除父节点栈里当前的节点，
//                //继续此次循环，直到确定父子关系或不存在退出for循环
//                parentnodes.remove(i) ;
//            }
        }
    }

}
