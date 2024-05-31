package com.example.myapplicationfasfasfa;

import java.util.Comparator;

public class President {
    private int id;
    private String name;
    private int data;
    private String image;

    public static Comparator<President> presidentComparator1 = new Comparator<President>() {
        @Override
        public int compare(President president, President t1) {
            return president.getName().compareTo(t1.getName());
        }
    };

    public static Comparator<President> presidentComparator2 = new Comparator<President>() {
        @Override
        public int compare(President president, President t1) {
            return t1.getName().compareTo(president.getName());
        }
    };
        public static Comparator<President> presidentComparator3 = new Comparator<President>() {
            @Override
            public int compare(President president, President t1) {
                return president.getData() - t1.getData();
            }
        };

        public static Comparator<President> presidentComparator4 = new Comparator<President>() {
            @Override
            public int compare(President president, President t1) {
                return t1.getData() - president.getData();
            }
        };

    public President(int id, String name, int data, String image) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "President{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", data=" + data +
                ", image='" + image + '\'' +
                '}';
    }
}
