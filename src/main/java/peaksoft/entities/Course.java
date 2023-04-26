package peaksoft.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration_month")
    private String durationMonth;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;
    @Transient
    private Long companyId;
//    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinTable(name = "courses_groups",
//    joinColumns = @JoinColumn(name ="courses_id"),
//    inverseJoinColumns = @JoinColumn(name = "groups_id"))
//    private List<Group> groups;
//    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "course")
//    private Teacher teacher;
}
