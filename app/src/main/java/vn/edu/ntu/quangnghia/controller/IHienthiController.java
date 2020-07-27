package vn.edu.ntu.quangnghia.controller;

import java.util.List;

import vn.edu.ntu.quangnghia.model.Hienthi;

public interface IHienthiController {
    public List<Hienthi> getAllHienthi();
    public void addContact(Hienthi hienthi);
}
