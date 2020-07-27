package vn.edu.ntu.quangnghia.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quangnghia.model.Hienthi;

public class HienthiController extends Application implements IHienthiController {

    List<Hienthi> listhienthis = new ArrayList<>();
    public HienthiController()
    {
        listhienthis.add(new Hienthi(1,"a","10/10/2020","11/11/2020","d","s"));
        listhienthis.add(new Hienthi(2,"a","12/10/2020","22/10/2020","d","s"));
        listhienthis.add(new Hienthi(3,"a","b","c","d","s"));
        listhienthis.add(new Hienthi(4,"a","b","c","d","s"));

    }

    @Override
    public List<Hienthi> getAllHienthi() {
        return listhienthis;
    }

    @Override
    public void addContact(Hienthi hienthi) {
        listhienthis.add(hienthi);
    }

}
