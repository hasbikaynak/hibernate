package com.hb07.manytomany;

import com.hb06.bi_onetomany.Student06;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book07 {

    @Id
    private int id;
    private String bookName;

    @Enumerated(EnumType.STRING)//put string of the enum value
    private BookType type;

    @ManyToMany(mappedBy = "books")
    private List<Student07> students=new ArrayList<>();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BookType getType() {
        return type;
    }
    public void setType(BookType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book07 [id=" + id + ", bookName=" + bookName + "]";
    }
}
