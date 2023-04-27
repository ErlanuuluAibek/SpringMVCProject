package peaksoft.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "date_of_start")
    private String dateOfStart;
    @Column(name = "date_of_finish")
    private String dateOfFinish;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH} ,mappedBy = "groups")
    private List<Course> courses;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "group")
    private List<Student> students;
    @Transient
    private Long courseId;
}
