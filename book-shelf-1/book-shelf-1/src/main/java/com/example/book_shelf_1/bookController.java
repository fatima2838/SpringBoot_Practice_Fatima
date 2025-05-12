package com.example.book_shelf_1;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class bookController {
    // create a hasmap of books <ID, BOOK OBJECT> 
    Map<Integer, Book> allBooks = new HashMap<>();

    // Initialize books
    // create 
    public bookController() {
        allBooks.put(1, new Book(1, "The Hunger Games", "Suzanne Collins"));
        allBooks.put(2, new Book(2, "Harry Potter", "J.K. Rowling"));
        allBooks.put(3, new Book(3, "1984", "George Orwell"));
        allBooks.put(4, new Book(4, "The Alchemist", "Paulo Coelho"));
    }

    //display book 
    //read - using parameter 
    @GetMapping("viewBook") // path in the url 
    public String displayOneBook(@RequestParam(name = "id", required = true) int id, Model myModel) {
        Book bookObject = allBooks.get(id); // retrieve book by ID
        myModel.addAttribute("book", bookObject);
        return "BookInfo"; // name of the template file: BookInfo.html
    }

    // make sure that u never repeat the same mapping for different functions -> ambigous mapping errror

    @GetMapping("allBooks")
    public String displayAllBooks(Model model){
        model.addAttribute("booklist", allBooks); 


        return "allBooks"; 
    }

    
// UPDATE - Show form
@GetMapping("/editBook")
public String showEditForm(@RequestParam("id") int id, Model model) {
    Book book = allBooks.get(id);
    model.addAttribute("book", book);
    return "editBook";
}

// UPDATE - Handle form submission
@GetMapping("/updateBook")
public String updateBook(@RequestParam("id") int id,
                         @RequestParam("name") String name,
                         @RequestParam("author") String author) {
    Book book = allBooks.get(id);
    if (book != null) {
        book.setName(name);
        book.setAuthor(author);
    }
    return "redirect:/allBooks";
}

// DELETE
@GetMapping("/deleteBook")
public String deleteBook(@RequestParam("id") int id) {
    allBooks.remove(id);
    return "redirect:/allBooks";
}


    
}
