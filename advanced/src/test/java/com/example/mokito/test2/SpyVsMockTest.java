package com.example.mokito.test2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SpyVsMockTest {

    @Test
    public void mock_test() {

        List<String> objectToBeMocked = new ArrayList<>();

        List<String> mockedList = Mockito.mock(objectToBeMocked.getClass());

        mockedList.add("one");
        mockedList.add("two");

        Mockito.verify(mockedList).add("one");
        Mockito.verify(mockedList).add("two");

        // assertEquals(2, mockedList.size());  -> it fails

        Mockito.doReturn(2).when(mockedList).size();
        assertEquals(2, mockedList.size());
    }


    @Test
    public void spy_test() {

        ArrayList<String> objectToBeSpied = new ArrayList<>();

        List<String> spiedList = Mockito.spy(objectToBeSpied);

        // notice no when()..
        spiedList.add("one");
        spiedList.add("two");

        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");

         assertEquals(2, spiedList.size());  // it works

        Mockito.doReturn(10).when(spiedList).size();
        assertEquals(10, spiedList.size());
    }

}
