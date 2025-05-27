//package com.example.ko_app.Security.User;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public enum Role {
//
//    USER(Collections.EMPTY_SET),
//    ADMIN(
//            Set.of(
//                    Permission.ADMIN_READ,
//                    Permission.ADMIN_UPDATE,
//                    Permission.ADMIN_CREATE,
//                    Permission.ADMIN_DELETE
//            )
//    ),
//    SUBADMIN(
//            Set.of(
//                    Permission.SUBADMIN_READ,
//                    Permission.SUBADMIN_UPDATE,
//                    Permission.SUBADMIN_CREATE,
//                    Permission.SUBADMIN_DELETE
//
//            )
//    ),
//
//    CUSTOMER(
//            Set.of(
//            Permission.CUSTOMER_READ,
//            Permission.CUSTOMER_UPDATE,
//            Permission.CUSTOMER_CREATE,
//            Permission.CUSTOMER_DELETE
//
//            )
//    ),
//
//    DRIVER(
//            Set.of(
//                    Permission.DRIVER_READ,
//                    Permission.DRIVER_UPDATE,
//                    Permission.DRIVER_CREATE,
//                    Permission.DRIVER_DELETE
//
//            )
//    );
//
//    private final Set<Permission> permissionset;
//
//    Role(Set<Permission> permissionset) {
//        this.permissionset = permissionset;
//    }
//
//    public Set<Permission> getPermissionset() {
//        return permissionset;
//    }
//
//    public List<SimpleGrantedAuthority> getAuthority() {
//        List<SimpleGrantedAuthority> auth = getPermissionset()
//                .stream()
//                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
//                .collect(Collectors.toList());
//        auth.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
//        return auth;
//    }
//}
