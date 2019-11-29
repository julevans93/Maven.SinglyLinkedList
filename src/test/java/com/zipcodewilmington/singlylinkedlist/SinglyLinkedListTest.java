package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest <E>{
    SinglyLinkedList<E> list;

    @Before
    public void setUp(){
        list = new SinglyLinkedList<E>();
        list.add((E)"test1");
        list.add((E) "test2");
        list.add((E) "test3");
    }

    @Test
    public void testRemove(){
        Assert.assertEquals(true, list.remove(1));
    }

    @Test
    public void testFind(){
        int expected = 1;
        int actual = list.find((E)"test2");

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testContains(){
        Assert.assertEquals(true, list.contains((E)"test3"));
    }

    @Test
    public void testGet(){
        E expected = (E) "test1";
        E actual = list.get(0);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testCopy(){
        E expected = (E) list;
        E actual = (E) list.copy();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testClear(){
        Assert.assertEquals(true, list.clear());
    }

}
