package com.example.myapplicationfasfasfa;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    private static List<President> presidentList = new ArrayList<President>();
    private static int nextId = 6;

    public MyApplication(){
        fillPresidentList();
    }

    private void fillPresidentList() {
        President president0 = new President(0,"George Washington", 1789, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/300px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President president1 = new President(1, "John Adams", 1797, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/John_Adams_A18236.jpg/300px-John_Adams_A18236.jpg");
        President president2 = new President(2, "Thomas Jeferson", 1801, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg/300px-Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg");
        President president3 = new President(3, "James Madison", 1809, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/James_Madison.jpg/300px-James_Madison.jpg");
        President president4 = new President(4, "James Monroe", 1817, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/James_Monroe_White_House_portrait_1819.jpg/300px-James_Monroe_White_House_portrait_1819.jpg");
        President president5 = new President(5, "John Quincy Adams", 1825, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/John_Quincy_Adams_by_Charles_Osgood.jpg/300px-John_Quincy_Adams_by_Charles_Osgood.jpg");

        presidentList.addAll(Arrays.asList(new President[] {president0,president1,president2,president3,president4,president5}));
    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
