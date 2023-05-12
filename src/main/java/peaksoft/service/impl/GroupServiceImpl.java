package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.GroupDao;
import peaksoft.entities.Group;
import peaksoft.service.GroupService;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService {
    private final GroupDao groupDao;
    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @Override
    public Group getGroupById(Long groupId) {
        return groupDao.getGroupById(groupId);
    }

    @Override
    public void addGroup(Group group,Long id) {
        groupDao.addGroup(group,id);
    }

    @Override
    public void updateGroup(Long Id, Group group,Long courseId) {
        groupDao.updateGroup(Id,group,courseId);
    }

    @Override
    public void deleteGroup(Group group) {
        groupDao.deleteGroup(group);
    }
}
