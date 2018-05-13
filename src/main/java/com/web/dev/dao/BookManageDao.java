package com.web.dev.dao;

import com.web.dev.pojo.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/5/13/0013.
 */
@Service
public interface BookManageDao {

    String TABLE = "test";
    String FIELDS = " (name,format,valid,ctime)";
    String VALUES = "(#{name},#{format},1,now())";

    @Insert("insert into " + TABLE + FIELDS + "values" + VALUES)
    public void insertBook(@RequestParam("book")Book book);

    @Select("select * from " + TABLE + " where id=#{id}")
    public Book selectBookById(@RequestParam("id") int id);
}
