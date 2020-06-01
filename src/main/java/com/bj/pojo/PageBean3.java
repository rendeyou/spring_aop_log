package com.bj.pojo;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

public class PageBean3<T> implements Serializable{
    //必须传递的参数
    private Integer page;//当前页
    private Integer size;//每页显示的记录数
    private Integer totalCount;//总记录数
    private List<T> list;//每页结果集
    //可以计算出来的参数
    private Integer start;//开始角标
    private Integer totalPage;//总页数
    private Integer firstPage;//首页
    private Integer lastPage;//尾页
    private Boolean hasPrev;//是否有上一页
    private Boolean hasNext;//是否有下一页
    private Integer prevPage;//上一页
    private Integer nextPage;//下一页
    //导航条（参考百度）
    private Integer navPage;//导航条页数
    private Integer navStart;//导航条开始页
    private Integer navEnd;//导航条结束页

    public PageBean3() {
    }
/*
    //必须传递的参数
    public PageBean3(String page, String size, Integer totalCount) {
        this.page = StringUtils.isBlank( page )==true?1:Integer.parseInt( page );
        this.size = StringUtils.isBlank( size )==true?5:Integer.parseInt( size );
        this.totalCount = totalCount;
        //可以计算出来的参数
        this.start=(this.page-1)*this.size;
//        this.totalPage=this.totalCount%this.size==0?this.totalCount/this.size:this.totalCount/this.size+1;
        this.totalPage=(int)Math.ceil( this.totalCount*1.0/this.size );
        this.firstPage=1;
        this.lastPage=this.totalPage;
//        if(this.page>1){
//            this.hasPrev=true;
//        }else {
//            this.hasPrev=false;
//        }
        this.hasPrev=this.page>1;
        this.hasNext=this.page<this.totalPage;
        if(hasPrev){
            this.prevPage=this.page-1;
        }
        if(hasNext){
            this.nextPage=this.page+1;
        }
        //导航条
        this.navPage=this.navPage>10?10:this.totalPage;
        this.navStart=this.page-this.navPage/2<=0?1:this.page-this.navPage/2;
        if(this.navStart>this.totalPage-this.navPage+1){
            this.navStart=this.totalPage-this.navPage+1;
        }
        this.navEnd=this.navStart+this.navPage-1;
    }
*/
    //必须传递的参数001
    public PageBean3(String page, String size) {
        this.page = StringUtils.isBlank( page )==true?1:Integer.parseInt( page );
        this.size = StringUtils.isBlank( size )==true?3:Integer.parseInt( size );
        //可以计算出来的参数
        this.start=(this.page-1)*this.size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalCount() {
        return totalCount;
    }
    //必须传递的参数002
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        //可以计算出来的参数
//        this.totalPage=this.totalCount%this.size==0?this.totalCount/this.size:this.totalCount/this.size+1;
        this.totalPage=(int)Math.ceil( this.totalCount*1.0/this.size );
        this.firstPage=1;
        this.lastPage=this.totalPage;
//        if(this.page>1){
//            this.hasPrev=true;
//        }else {
//            this.hasPrev=false;
//        }
        this.hasPrev=this.page>1;
        this.hasNext=this.page<this.totalPage;
        if(hasPrev){
            this.prevPage=this.page-1;
        }
        if(hasNext){
            this.nextPage=this.page+1;
        }
        //导航条(参考百度)
        this.navPage=this.totalPage>10?10:this.totalPage;
        this.navStart=this.page-this.navPage/2<=0?1:this.page-this.navPage/2;
        if(this.navStart>this.totalPage-this.navPage+1){
            this.navStart=this.totalPage-this.navPage+1;
        }
        this.navEnd=this.navStart+this.navPage-1;
    }

    public List<T> getList() {
        return list;
    }
    //必须传递的参数003
    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Boolean getHasPrev() {
        return hasPrev;
    }

    public void setHasPrev(Boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Integer getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getNavPage() {
        return navPage;
    }

    public void setNavPage(Integer navPage) {
        this.navPage = navPage;
    }

    public Integer getNavStart() {
        return navStart;
    }

    public void setNavStart(Integer navStart) {
        this.navStart = navStart;
    }

    public Integer getNavEnd() {
        return navEnd;
    }

    public void setNavEnd(Integer navEnd) {
        this.navEnd = navEnd;
    }
}
