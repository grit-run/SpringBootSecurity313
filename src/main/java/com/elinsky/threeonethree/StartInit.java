//package com.elinsky.threeonethree;
//
//import com.elinsky.threeonethree.model.Role;
//import com.elinsky.threeonethree.model.User;
//import com.elinsky.threeonethree.service.RoleSrvImpl;
//import com.elinsky.threeonethree.service.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class StartInit {
//    private final RoleSrvImpl roleService;
//    private final UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    public StartInit(RoleSrvImpl roleService, UserDetailsServiceImpl userDetailsService) {
//
//        this.roleService = roleService;
//        this.userDetailsService = userDetailsService;
//    }
//
//    private final Role roleAdmin = new Role("ROLE_ADMIN");
//    private final Role roleUser = new Role("ROLE_USER");
//
//
//    public Set<Role> setAdminRole() {
//        Set<Role> adminRole = new HashSet<>();
//        adminRole.add(roleAdmin);
//        return adminRole;
//    }
//
//    public Set<Role> setUserRole() {
//        Set<Role> userRole = new HashSet<>();
//        userRole.add(roleUser);
//        return userRole;
//    }
//
////    @Transactional
//    @Bean
//    public void addStartUsers() {
//        roleService.save(roleAdmin);
//        roleService.save(roleUser);
//
//        userDetailsService.saveUser(new User("FirstUser", "fu@bk.ru", 34, "admin"
//                , "Admin",
//                setAdminRole())); //Admin -> admin
//        userDetailsService.saveUser(new User("SecondUser", "su@bk,ru", 25,
//                "user", "User",
//                setUserRole())); // User -> user
//         }
//}
//
