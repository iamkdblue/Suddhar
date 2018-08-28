package app.kdblue.com.creditsuddhar.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import app.kdblue.com.creditsuddhar.R;
import app.kdblue.com.creditsuddhar.activity.LoginActivity;
import app.kdblue.com.creditsuddhar.activity.MainActivity;
import app.kdblue.com.creditsuddhar.db.UserDataBase;
import app.kdblue.com.creditsuddhar.model.UserDetail;
import app.kdblue.com.creditsuddhar.util.SavePref;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyAccountFragment extends Fragment {

    private SavePref savePref;
    private UserDataBase userDataBase;
    private TextView tvUserName,tvUserEmail,tvUserPhoneNo,tvUserAccountNo,tvUserCity;
    private Button btnLogout;

    public MyAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_account, container, false);
        tvUserName = view.findViewById(R.id.tvUserName);
        tvUserEmail = view.findViewById(R.id.tvUserEmail);
        tvUserPhoneNo = view.findViewById(R.id.tvUserPhoneNo);
        tvUserAccountNo = view.findViewById(R.id.tvUserAccountNo);
        tvUserCity = view.findViewById(R.id.tvUserCity);

        btnLogout = view.findViewById(R.id.btnLogout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        savePref = new SavePref(getActivity());

        userDataBase = UserDataBase.getAppDatabase(getActivity());

        int userId = savePref.getUserId();

        UserDetail userDetail = userDataBase.userDao().getUserDetail(userId);

        tvUserName.setText(userDetail.getUserName());
        tvUserEmail.setText(userDetail.getUserEmail());
        tvUserPhoneNo.setText(userDetail.getUserPhoneNo());
        tvUserAccountNo.setText(userDetail.getUserAccountNo());
        tvUserCity.setText(userDetail.getUserCity());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePref.clearAllData();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                getActivity().finish();
            }
        });
    }
}
