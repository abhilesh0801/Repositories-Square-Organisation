package com.poqtest.ui

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.poqtest.data.model.Repo
import com.poqtest.data.repository.RepoRepository
import com.poqtest.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepoListViewModel @Inject constructor(private val repoRepository: RepoRepository): ViewModel() {

    val TAG = "RepoListViewModel"

    // Controls hiding and showing of progress bar
    var loaderVisibility: MutableLiveData<Int> = MutableLiveData()

    // Controls hiding and showing of error message
    var errorVisibility: MutableLiveData<Int> = MutableLiveData()

    // Controls hiding and showing of recyclerView
    var recyclerViewVisibility: MutableLiveData<Int> = MutableLiveData()

    // Controls what error message is shown
    var errorText: MutableLiveData<String> = MutableLiveData()

    val repoListAdapter: RepoListAdapter = RepoListAdapter()

    init {
        loadRepositories()
    }

    fun loadRepositories() {
        Log.d(TAG,"loadRepositories")

        loaderVisibility.postValue(View.VISIBLE)
        errorVisibility.postValue(View.GONE)

        repoRepository.getRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<List<Repo>>() {
                override fun onComplete() {
                }

                override fun onNext(repositories: List<Repo>) {
                    if(repositories.isEmpty()) {
                        setErrorMessage(Constants.NO_REPOSITORIES_FOUND)
                    } else {
                        setRepositoryData(repositories)
                    }
                }

                override fun onError(e: Throwable) {
                    setErrorMessage(Constants.FAILED_TO_LOAD_REPOSITORIES)
                }
            })
    }

    private fun setRepositoryData(repositories: List<Repo>) {
        Log.d(TAG,"setRepositoryData")
        repoListAdapter.updateRepoList(repositories)
        recyclerViewVisibility.postValue(View.VISIBLE)
        errorVisibility.postValue(View.GONE)
        loaderVisibility.postValue(View.GONE)
    }

    fun setErrorMessage(message: String) {
        Log.d(TAG,"setErrorMessage: $message")
        errorVisibility.postValue(View.VISIBLE)
        errorText.postValue(message)
        recyclerViewVisibility.postValue(View.GONE)
        loaderVisibility.postValue(View.GONE)
    }
}