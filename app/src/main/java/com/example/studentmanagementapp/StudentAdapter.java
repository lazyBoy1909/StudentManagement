package com.example.studentmanagementapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    List<Student> listStudent;

    public StudentAdapter (List<Student> listStudent) {
        this.listStudent = listStudent;
    }

    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int i) {
        return listStudent.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    class MyViewHolder {
        TextView idTextView;
        TextView nameTextView;
        TextView dateOfBirthTextView;
        TextView emailTextView;
    }
}
