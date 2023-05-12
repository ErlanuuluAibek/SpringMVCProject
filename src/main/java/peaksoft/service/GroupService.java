package peaksoft.service;

import peaksoft.entities.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    Group getGroupById(Long groupId);
    void addGroup(Group group,Long id);
    void updateGroup(Long Id,Group group,Long courseId);
    void deleteGroup(Group group);
}
