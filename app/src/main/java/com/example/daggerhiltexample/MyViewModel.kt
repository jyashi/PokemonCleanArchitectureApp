package com.example.daggerhiltexample

import androidx.lifecycle.ViewModel
import com.example.daggerhiltexample.repository.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel@Inject constructor(private val repositoryInterface: RepositoryInterface): ViewModel() {


}