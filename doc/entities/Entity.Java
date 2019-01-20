@Entity(name = "Person")
public static class Person {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    //Getters and setters are omitted for brevity

}

@Entity(name = "Book")
public static class Book {

    @Id
    private Long id;

    private String title;

    @NaturalId
    private String isbn;

    @ManyToOne
    private Person author;

    //Getters and setters are omitted for brevity

}