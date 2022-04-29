package com.codesquad.sidedish.order.domain;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String githubId;
    private String username;
    private Integer point;

    @MappedCollection(idColumn = "github_id")
    private Set<Order> orders = new HashSet<>();

    public User(String githubId, String username) {
        this.githubId = githubId;
        this.username = username;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void addPoint(Integer point) {
        this.point = point;
    }

    public User update(User user) {
        if (user == null) {
            return null;
        }

        this.githubId = user.githubId;
        this.username = user.username;
        return this;
    }
}
