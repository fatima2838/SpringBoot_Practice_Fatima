package com.example.book_shelf_1;


public class Book {
public int id ; 
public String name; 
public String author; 

public Book(int id, String name,String author){
this.id = id ; 
this.name = name; 
this.author =author; 

}

public Book(){

}

public void setId(int id){
    this.id = id ; 
}
public void setName(String name ){
this.name = name; 
}

public void setAuthor(String author){
this.author = author; 
}

public int getId(){
    return id ; 
}
public String getName(){
    return this.name;
}

public String getAuthor(){
    return this.author; 
}

}
