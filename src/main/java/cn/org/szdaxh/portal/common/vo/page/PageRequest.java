package cn.org.szdaxh.portal.common.vo.page;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/6/28
 */
@Data
public class PageRequest {
    private int page = 1;
    private int size = 10;
    private Sort sort = Sort.unsorted();
    private String direction;
    private String sorts;

    public void initSort() {
        if (sorts == null) {
            this.sorts = "modifyAt";
        }

        Sort.Direction direction = Sort.Direction
                .fromOptionalString(this.direction)
                .orElse(Sort.Direction.DESC);
        this.sort = Sort.by(direction, sorts.trim().split(" +"));
    }

    public static Pageable valueOf(PageRequest request) {
        request.initSort();
        return org.springframework.data.domain.PageRequest.of(request.getPage()-1, request.getSize(),
                request.getSort());
    }
}
