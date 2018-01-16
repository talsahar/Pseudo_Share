package com.tal.pseudo_share.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseUser;
import com.tal.pseudo_share.model.authentication.AuthenticationRepository;

import java.util.concurrent.Future;

/**
 * Created by talsahar73 on 10/01/2018.
 */

    public class AuthenticationViewModel extends ViewModel {
    MutableLiveData<FirebaseUser> userLiveData;
    MutableLiveData<Exception> exceptionLiveData;

    public void signin(String email, String password) {
    AuthenticationRepository.login(email,password);
    }

    public void signup(String email, String password,String nickname) {
        AuthenticationRepository.signup(email,password,nickname);
    }

    public void signout(){
        AuthenticationRepository.logout();
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        if(userLiveData==null)
            userLiveData=AuthenticationRepository.getUserMutableLiveData();
        return userLiveData;
    }

    public MutableLiveData<Exception> getExceptionLiveData() {
        if(exceptionLiveData==null)
            exceptionLiveData=AuthenticationRepository.getExceptionMutableLiveData();
        return exceptionLiveData;
    }

    public void loadCurrUser() {
    }
}
