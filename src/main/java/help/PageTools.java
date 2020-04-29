package help;

import entity.Page;

public class PageTools {

    public Page getPage(int num, int pageNo){
        Page page = new Page();
        page.setPageSize(8);
        page.setTotalCount(num);
        if (page.getTotalPageCount() <= pageNo) {
            pageNo = page.getTotalPageCount();
        } else if (pageNo <= 1) {
            pageNo = 1;
        }
        page.setCurrentPageNO(pageNo);
        return page;
    }
}
