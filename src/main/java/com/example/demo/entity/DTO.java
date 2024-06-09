package com.example.demo.entity;

public class DTO {
    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public static DTO convertToDto(Book book) {
        DTO dto = new DTO();
        dto.setBookName(book.getBookName());
        return dto;
    }
}
