package cn.org.szdaxh.portal.common.vo.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

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
@AllArgsConstructor
@NoArgsConstructor
public class PageData<T> {
    private List<T> data;
    private Pagination pagination;


    public static <T> PageData<T> of(Page<T> pages, PageRequest pageRequest) {

        Pagination pagination = Pagination.builder()
                .size(pages.getSize())
                .total(pages.getTotalElements())
                .number(pages.getNumber()+1)
                .totalPages(pages.getTotalPages())
                .first(pages.isFirst())
                .last(pages.isLast())
                .hasNext(pages.hasNext())
                .pageRequest(pageRequest)
                .build()
                .initPages();
        return new PageData<>(pages.getContent(), pagination);
    }
}
