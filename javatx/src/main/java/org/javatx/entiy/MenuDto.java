package org.javatx.entiy;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/12/2 9:49
 */
@Getter@Setter
public class MenuDto {
    private Integer id;
    private String menuName;
    private String path;
    private List<MenuDto> children;

    public MenuDto() {
    }

    public MenuDto(Integer id, String menuName, String path) {
        this.id = id;
        this.menuName = menuName;
        this.path = path;
    }
}
