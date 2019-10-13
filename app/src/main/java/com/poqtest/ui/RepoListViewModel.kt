package com.poqtest.ui

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

    var loaderVisibility: MutableLiveData<Int> = MutableLiveData()
    var errorVisibility: MutableLiveData<Int> = MutableLiveData()
    var errorText: MutableLiveData<String> = MutableLiveData()
    val repoListAdapter: RepoListAdapter = RepoListAdapter()

    init {
        loadRepositories()
    }

    public fun loadRepositories() {
        loaderVisibility.postValue(View.VISIBLE)
        errorVisibility.postValue(View.GONE)

        repoRepository.getRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<List<Repo>>() {
                override fun onComplete() {
                }

                override fun onNext(repositories: List<Repo>) {
                    setRepositoryData(repositories)
                }

                override fun onError(e: Throwable) {
                    setErrorMessage()
                }
            })
    }

    private fun setRepositoryData(repositories: List<Repo>) {
        if(repositories.isEmpty()) {
            errorVisibility.postValue(View.VISIBLE)
            errorText.postValue(Constants.NO_REPOSITORIES_FOUND)
        } else {
            errorVisibility.postValue(View.GONE)
        }
        repoListAdapter.updateRepoList(repositories)
        loaderVisibility.postValue(View.GONE)
    }

    private fun setErrorMessage() {
        errorVisibility.postValue(View.VISIBLE)
        errorText.postValue(Constants.FAILED_TO_LOAD_REPOSITORIES)
        loaderVisibility.postValue(View.GONE)
    }
}