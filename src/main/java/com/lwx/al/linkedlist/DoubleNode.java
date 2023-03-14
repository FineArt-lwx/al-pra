package com.lwx.al.linkedlist;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class DoubleNode {

    int value;
    DoubleNode pre;
    DoubleNode next;
}
