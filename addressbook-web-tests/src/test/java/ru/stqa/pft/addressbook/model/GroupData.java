package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  public final String name;
  public final String header;
  public final String footer;
  private int id;

  public GroupData(String name, String header, String footer, int id) {
    this.name = name;
    this.header = header;
    this.footer = footer;
    this.id = id;
  }

  public GroupData(String name, String header, String footer) {
    this.name = name;
    this.header = header;
    this.footer = footer;
    this.id = 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id && Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  public void setID(int id) {
    this.id = id;
  }
}