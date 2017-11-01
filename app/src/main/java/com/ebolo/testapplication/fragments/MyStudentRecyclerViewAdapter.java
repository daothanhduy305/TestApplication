package com.ebolo.testapplication.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ebolo.testapplication.R;
import com.ebolo.testapplication.data.entities.Student;
import com.ebolo.testapplication.fragments.StudentFragment.OnListFragmentInteractionListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyStudentRecyclerViewAdapter extends RecyclerView.Adapter<MyStudentRecyclerViewAdapter.ViewHolder> {

    private final List<Student> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyStudentRecyclerViewAdapter(List<Student> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.render(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.school)
        TextView school;
        @BindView(R.id.age)
        TextView age;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

        void render(Student student) {
            name.setText(student.getName());
            school.setText(student.getSchool());
            age.setText(student.getAge().toString());
        }
    }
}
