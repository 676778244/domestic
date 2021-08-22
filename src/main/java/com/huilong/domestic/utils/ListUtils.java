package com.huilong.domestic.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

    private ListUtils() {
    }

    /**
     * List类型转换
     *
     * @param oList
     * @param c
     * @param <T>
     * @return
     */
    public static <T> List<T> copyPropertiesToList(List<?> oList, Class<T> c) {
        if (oList == null) {
            return new ArrayList<>();
        }
        return oList.stream().map(o -> {
            T t = null;
            try {
                t = c.newInstance();
                BeanUtils.copyProperties(o, t);
                return t;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }

    /**
     * 分页
     * @param list
     * @param pageNum
     * @param pageSize
     * @return
     */
    public static <T> List<T> page(List<T> list, Integer pageNum,
                            Integer pageSize) {
        if (list == null)
            return new ArrayList<>();

        if (CollectionUtils.isEmpty(list))
            return new ArrayList<>();


        Integer count = list.size(); // 记录总数
        int pageCount = 0; // 页数
        if (count % pageSize == 0)
            pageCount = count / pageSize;
        else
            pageCount = count / pageSize + 1;


        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引

        if (!pageNum.equals(pageCount)) {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = fromIndex + pageSize;
        } else {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = count;
        }

        if (fromIndex - 1 > count || toIndex - 1 > count)
            return new ArrayList<>();

        return list.subList(fromIndex, toIndex);

    }
    /**
     * 两个list交集
     * @param list1
     * @param list2
     * @return java.util.List<T> 返回新list
     */
    public static <T> List<T> retain(List<T> list1, List<T> list2) {
        return list1.stream().filter(list2::contains).collect(Collectors.toList());
    }

    /**
     * 两个list差集
     * @param list1
     * @param list2
     * @return java.util.List<T> 返回新list
     */
    public static <T> List<T> diff(List<T> list1, List<T> list2) {
        return list1.stream().filter(i -> !list2.contains(i)).collect(Collectors.toList());
    }
}
