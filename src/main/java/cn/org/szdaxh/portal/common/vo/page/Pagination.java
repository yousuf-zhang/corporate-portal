package cn.org.szdaxh.portal.common.vo.page;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
    private static final int PAGE_LIST_FLAG = -99;
    private static final long PAGE_LIST_SIZE = 9;

    private int number;
    private int size;
    private long total;
    private int totalPages;
    private boolean first;
    private boolean last;
    private boolean hasNext;
    private Sort.Direction direction;
    private String[] sort;
    private List<Integer> pages;
    private PageRequest pageRequest;

    public Pagination initPages() {
        pages = Lists.newArrayList();
        if (this.total > 0) {
            if (this.totalPages <= PAGE_LIST_SIZE) {
                for (int i = 1; i <= totalPages; i++) {
                    this.pages.add(i);
                }
            } else {
                int left = Math.max(2, this.number - 2);
                int right = Math.min(this.number + 2, this.totalPages - 1);

                if (this.number - 1 <= 2) {
                    right = 5;
                }

                if (this.totalPages - this.number <= 2) {
                    left = (this.totalPages - 4);
                }
                this.pages.add(1);
                if (this.totalPages > PAGE_LIST_SIZE && this.number - 3 > 1) {
                    pages.add(PAGE_LIST_FLAG);
                }
                for (int i = left; i <= right; i++) {
                    this.pages.add(i);
                }
                if (this.totalPages > 9 && this.number + 3 < this.totalPages) {
                    this.pages.add(PAGE_LIST_FLAG);
                }
                this.pages.add(this.totalPages);
            }
        }
        return this;
    }
}
