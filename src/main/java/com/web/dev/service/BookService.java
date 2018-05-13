package com.web.dev.service;

import com.web.dev.dao.BookManageDao;
import com.web.dev.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/5/13/0013.
 */
@Service
public class BookService {

    @Resource
    private BookManageDao bookManageDao;

    public void insertBook(Book book) {
        bookManageDao.insertBook(book);
    }

    public Book findBookById(int id) {
        return bookManageDao.selectBookById(id);
    }
}
