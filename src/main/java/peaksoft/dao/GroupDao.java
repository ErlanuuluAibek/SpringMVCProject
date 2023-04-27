package peaksoft.dao;

import peaksoft.entities.Company;
import peaksoft.entities.Group;

import java.util.List;

public interface GroupDao {
    List<Group> getAllGroups();
    Group getGroupById(Long groupId);
    void addGroup(Group group,Long id);
    void updateGroup(Long Id,Group group);
    void deleteGroup(Group group);
}
