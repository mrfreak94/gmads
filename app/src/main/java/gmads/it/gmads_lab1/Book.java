package gmads.it.gmads_lab1;

import android.graphics.Bitmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book {
    private String bId;
    private String isbn;
    private String title;
    private String description;
    private String urlimage;
    private String publishDate;
    private List<String> author;
    private List<String> categories;//
    private double avgRating;
    private int nRates;
    private double sumRates;
    private String publisher;
    private List<String> comments;
    private String condition;
    private String owner;
    private String holder;
    private List<Bitmap> images;
    private String indirizzo;
    private Geoloc _geoloc;

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor( List<String> author ) {
        this.author = author;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories( List<String> categories ) {
        this.categories = categories;
    }

    public Map<String, String> getNotes() {
        return notes;
    }

    public void setNotes( Map<String, String> notes ) {
        this.notes = notes;
    }

    private Map<String,String> notes=new  HashMap<>();

    public Geoloc get_geoloc() {
        return _geoloc;
    }

    public void set_geoloc(Geoloc _geoloc) {
        this._geoloc = _geoloc;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo( String indirizzo ) {
        this.indirizzo = indirizzo;
    }

    public Book( String BId, String isbn, String title, String description, String urlimage, String publishDate, List<String> author, List<String> categories, String publisher, String owner, Double lat, Double lng) {
        this.BId = BId;
    public Book( String bId, String isbn, String title, String description, String urlimage, String publishDate, String author, String categories, String publisher, String owner, Double lat, Double lng) {
        this.bId = bId;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.urlimage = urlimage;
        this.publishDate = publishDate;
        this.author = author;
        this.categories = categories;
        this.publisher = publisher;
        this.owner = owner;
        this._geoloc = new Geoloc(lat, lng);
        comments= Collections.emptyList();
        images=Collections.emptyList();
        notes= Collections.emptyMap();
        avgRating=0;
        nRates=0;
        sumRates=0;

    }

    public Book() {
    }

    public List<Bitmap> getImages() {
        return images;
    }

    public void setImages(List<Bitmap> images) {
        this.images = images;
    }

    public String getBId() {
        return bId;
    }

    public void setBId(String BId) {
        this.bId = BId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }



    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public int getnRates() {
        return nRates;
    }

    public void setnRates(int nRates) {
        this.nRates = nRates;
    }

    public double getSumRates() {
        return sumRates;
    }

    public void setSumRates(double sumRates) {
        this.sumRates = sumRates;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) { this.owner = owner; }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }
}
