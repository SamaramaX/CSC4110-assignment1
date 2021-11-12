import java.util.Scanner;

interface Book_info{

    public void setAuthor(String authorName);
    public void setTitle(String book_title);
    public void setRating(double rating);
    public void setPublisher(String publisher);
    public void setPublish_date(String publish_date);
    public void setPublish_location(String publish_location);
    public void setISBN(String isbn_number);
    public void setSummary(String summary);
}

class BookPage implements Book_info{

    private String authorName;
    private String book_title;
    private double rating;
    private String publisher;
    private String publish_date;
    private String publish_location;
    private String isbn_number;
    private String summary;

    
    public void setAuthor(String authorName){
        this.authorName = authorName;
    }
    public void setTitle(String book_title){
        this.book_title = book_title;
    }
    public void setRating(double rating){
        this.rating = rating;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public void setPublish_date(String publish_date){
        this.publish_date = publish_date;
    }
    public void setPublish_location(String publish_location){
        this.publish_location = publish_location;
    }
    public void setISBN(String isbn_number){
        this.isbn_number = isbn_number;
    }
    public void setSummary(String summary){
        this.summary = summary;
    }

}

interface BookBuilder{

    public void buildAuthor();
    public void buildTitle();
    public void buildRating();
    public void buildPublisher();
    public void buildPublish_date();
    public void buildPublish_location();
    public void buildISBN();
    public void buildSummary();
    public BookPage getBookDetails();

}

class novelBuilder implements BookBuilder{

    private BookPage bookpage;

    
    public novelBuilder(){
        this.bookpage = new BookPage();
    }
    
    public void buildAuthor(){
        bookpage.setAuthor("J.K. Rowling");
    }
    public void buildTitle(){
        bookpage.setTitle("Harry Potter and the Sorcerer's Stone");
    }
    public void buildRating(){
        bookpage.setRating(4.47);
    }
    public void buildPublisher(){
        bookpage.setPublisher("Scholastic_Inc");
    }
    public void buildPublish_date(){
        bookpage.setPublish_date("06-26-1997");
    }
    public void buildPublish_location(){
        bookpage.setPublish_location("N/A");
    }
    public void buildISBN(){
        bookpage.setISBN("978-0439708180");
    }
    public void buildSummary(){
        bookpage.setSummary("Lorem bla bla bla bla");
    }
    public BookPage getBookDetails(){
        return this.bookpage;
    }

}

class BookComposer{

    private BookBuilder bookBuilder;

    public BookComposer(BookBuilder bookBuilder){
        this.bookBuilder = bookBuilder;
    }

    public BookPage getBookDetails(){
        return this.bookBuilder.getBookDetails();
    }

    public void composeBookInfo(){

        this.bookBuilder.buildAuthor();
        this.bookBuilder.buildTitle();
        this.bookBuilder.buildRating();
        this.bookBuilder.buildPublisher();
        this.bookBuilder.buildPublish_date();
        this.bookBuilder.buildPublish_location();
        this.bookBuilder.buildISBN();
        this.bookBuilder.buildSummary();
    }
}

class BuildBookPage{
    public static void main(String[] args){

        BookBuilder novel = new novelBuilder();
        BookComposer book = new BookComposer(novel);

        book.composeBookInfo();

        BookPage bookPage = book.getBookDetails();

        System.out.println("Book build: " + bookPage);
    }
}