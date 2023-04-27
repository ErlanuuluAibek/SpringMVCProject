package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;

import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    private final CourseService courseService;

    public GroupController(GroupService groupService, CourseService courseService) {
        this.groupService = groupService;
        this.courseService = courseService;
    }

    @ModelAttribute("courseList")
    public List<Course> getCourseList(){
        return courseService.getAllCourses();
    }
    @GetMapping("/groups")
    public String getAllGroups(Model model) {
        List<Group> groups = groupService.getAllGroups();
        model.addAttribute("groups", groups);
        return "group/groups";
    }

    @GetMapping("/addGroup")
    public String addGroup(Model model) {
        model.addAttribute("group", new Group());
        return "group/saveGroup";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group) {
        groupService.addGroup(group, group.getCourseId());
        return "redirect:/groups/groups";
    }

    @GetMapping("/update/{id}")
    public String updateGroup(@PathVariable("id") Long id, Model model) {
        Group group = groupService.getGroupById(id);
        model.addAttribute("updateGroup", group);
        return "group/updateGroup";
    }

    @PatchMapping("/{id}")
    public String saveGroupUpdate(@PathVariable("id") Long id, @ModelAttribute("group") Group group) {
        groupService.updateGroup(id,group);
        return "redirect:/groups/groups";
    }

    @DeleteMapping("/delete")
    public String deleteGroup(@RequestParam("id") Long id) {
        Group group = groupService.getGroupById(id);
        groupService.deleteGroup(group);
        return "redirect:/groups/groups";
    }
}
