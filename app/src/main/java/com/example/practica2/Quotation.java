package com.example.practica2;

public class Quotation {
    private String quoteText;
    private String quoteAuthor;

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public Quotation setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
        return this;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public Quotation setQuoteText(String quoteText) {
        this.quoteText = quoteText;
        return this;
    }
}
