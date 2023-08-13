package com.elinsky.threeonethree.controllers;

import com.elinsky.threeonethree.model.User;
import com.elinsky.threeonethree.service.RoleSrvImpl;
import com.elinsky.threeonethree.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Set;

@Controller
public class AdminController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final RoleSrvImpl roleService;

    public AdminController(UserDetailsServiceImpl userDetailsServiceImpl, RoleSrvImpl roleService) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.roleService = roleService;
    }


    @GetMapping("/admin")
    public String allUserList(ModelMap model, Principal principal) {
        User user = userDetailsServiceImpl.findByName(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("users", userDetailsServiceImpl.findAll());
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("newUser") @Valid User user,
                          @ModelAttribute("role") Long roleId) {
        return getUserRoleString(user, roleId);
    }

    @GetMapping("/delete/{id}")
    public String prepareToDeleteUser(Model model, @PathVariable("id") Long id) {
        User user = userDetailsServiceImpl.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("roleUser", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userDetailsServiceImpl.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    private String getUserRoleString(@ModelAttribute("newUser") User user,
                                     @ModelAttribute("role") Long roleId) {
        user.setRoles(Set.of(roleService.getOneRole(roleId)));
        userDetailsServiceImpl.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/update/{id}")
    public String prepareToUpdateUser(Model model, @PathVariable("id") Long id) {
        User user = userDetailsServiceImpl.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("roleUser", roleService.getAllRoles());
        return "admin";
    }
    @PutMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user")@Valid User user,
                             @ModelAttribute("role") Long roleId) {
        return getUserRoleString(user, roleId);
    }



    @GetMapping("/admin/gt/{id}")
    public String  gtUser(@PathVariable("id") Long userId, Model model) {
        model.addAttribute("users", userDetailsServiceImpl.findOne(userId));
        return "admin";
    }
}

