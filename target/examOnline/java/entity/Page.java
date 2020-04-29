package entity;

import java.util.List;

public class Page {
    private int totalPageCount;// 总页数
    private int pageSize;// 页面大小
    private int totalCount;// 数据库总行数
    private int currentPageNO;// 当前页码
    private List topicList;// 每页内容集合

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        if (totalPageCount > 0) {
            this.totalPageCount = totalPageCount;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
        }
        if (totalCount % pageSize != 0) {
            this.totalPageCount = totalCount / pageSize + 1;
        } else {
            this.totalPageCount = totalCount / pageSize;
        }
    }

    public int getCurrentPageNO() {
        return currentPageNO;
    }

    public void setCurrentPageNO(int currentPageNO) {
        if (currentPageNO > 0 && currentPageNO <= getTotalPageCount()) {
            this.currentPageNO = currentPageNO;
        }
    }

    public List getTopicList() {
        return topicList;
    }

    public void setTopicList(List topicList) {
        this.topicList = topicList;
    }

    public Page(int totalPageCount, int pageSize, int totalCount, int currentPageNO, List topicList) {
        super();
        this.totalPageCount = totalPageCount;// 总页数
        this.pageSize = pageSize;// 页面大小
        this.totalCount = totalCount;// 数据总数
        this.currentPageNO = currentPageNO;// 当前页码
        this.topicList = topicList;// 内容集合
    }

    public Page() {
        super();
        this.totalPageCount = 0;// 总页数
        this.pageSize = 1;// 页面大小
        this.totalCount = 0;// 数据总数
        this.currentPageNO = 1;// 当前页码
    }
}
