package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.GroupDao;
import peaksoft.entities.Company;
import peaksoft.entities.Course;
import peaksoft.entities.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = entityManager.createQuery("from Group ",Group.class).getResultList();
        return groups;
    }

    @Override
    public Group getGroupById(Long groupId) {
        Group group = entityManager.find(Group.class,groupId);
        return group;
    }

    @Override
    public void addGroup(Group group,Long id) {
        Course course = entityManager.find(Course.class,id);
        List<Course>courses=new ArrayList<>();
        courses.add(course);
        group.setCourses(courses);
        List<Group> groups=new ArrayList<>();
        groups.add(group);
        course.setGroups(groups);
        entityManager.persist(group);
    }

    @Override
    public void updateGroup(Long groupId, Group group,Long courseId) {
        Group group1 = getGroupById(groupId);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
        Course course = entityManager.find(Course.class,courseId);
        List<Group> groups = new ArrayList<>();
        groups.add(group1);
        course.setGroups(groups);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        group1.setCourses(courses);
        entityManager.merge(group1);
    }

    @Override
    public void deleteGroup(Group group) {
        entityManager.remove(entityManager.contains(group)? group:entityManager.merge(group));
    }
}
