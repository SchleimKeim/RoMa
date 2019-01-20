package ch.zhaw.roma.model;

import javax.persistence.*;

@Entity
@Table(name = "AUTHORS")
@Access(AccessType.FIELD)
public class AuthorModel {
    @Id
    @Column(name = "AUTHOR_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BookModel.class, cascade = CascadeType.ALL)
    private Long bookId;
}
