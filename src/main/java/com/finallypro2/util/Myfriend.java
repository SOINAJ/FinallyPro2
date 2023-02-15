package com.finallypro2.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Myfriend{
    private String groupname;
    private String id;
    private List<Mymine> list;
}